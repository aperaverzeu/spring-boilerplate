package me.aperaverzeu.rest.service;

import lombok.RequiredArgsConstructor;
import me.aperaverzeu.rest.model.BasicEntity;
import me.aperaverzeu.rest.repository.BasicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class BasicService {
    private final BasicRepository repository;

    public Optional<BasicEntity> getAny() {
        return repository.findAll().stream().findAny();
    }

    public List<BasicEntity> getAll() {
        return repository.findAll();
    }

    public BasicEntity save(BasicEntity basicEntity) {
        return repository.save(basicEntity);
    }

//    public BasicEntity modify(BasicEntity basicEntity) {
//        repository.findById(basicEntity.getId())
//                .ifPresent(
//                        (Consumer<BasicEntity>) entity -> {
//                            return repository.save(entity);
//                        }
//                );
//    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
