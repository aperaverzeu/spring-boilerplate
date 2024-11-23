package me.aperaverzeu.serverless;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@Slf4j
public class ServerlessApplication {
    private final String _url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=be&dt=t&q=";

    private final WebClient _webClient = WebClient.create();

    public static void main(String[] args) {
        SpringApplication.run(ServerlessApplication.class, args);
    }

    @Bean
    public Supplier<Mono<String>> hello() {
        return () -> Mono.just("Hi!");
    }

    @Bean
    public Consumer<Mono<?>> destiny() {
        return mono -> log.info("Accepted from {}", mono.toString());
    }

    @Bean
    public Function<String, String> translate() {
        return input -> _webClient
                .get()
                .uri(_url + input)
                .retrieve()
                .bodyToMono(String.class)
                .map(s -> s.split("\"")[1])
                .block();
    }
}
