package me.aperaverzeu.rest.controller;

import lombok.RequiredArgsConstructor;
import me.aperaverzeu.rest.model.BasicEntity;
import me.aperaverzeu.rest.model.BasicEntityNotFoundException;
import me.aperaverzeu.rest.service.BasicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class BasicController {
    private final BasicService service;

    @GetMapping("/rest/{id}")
    public ResponseEntity<BasicEntity> getOneById(@PathVariable("id") Long id) {
        return ResponseEntity.status(OK)
                .body(service.getOneById(id).orElseThrow(() -> new BasicEntityNotFoundException(id)));
    }

    @GetMapping("/rest/any")
    public ResponseEntity<BasicEntity> getAny() {
        return ResponseEntity.status(OK).body(service.getAny().orElseThrow());
    }

    @GetMapping("/rest/all")
    public ResponseEntity<List<BasicEntity>> getAll() {
        return ResponseEntity.status(OK).body(service.getAll());
    }

    @PostMapping("/rest/")
    public ResponseEntity<BasicEntity> saveOne(@RequestBody BasicEntity entity) {
        return ResponseEntity.status(CREATED).body(service.save(entity));
    }

    @PutMapping("/rest/{id}")
    public ResponseEntity<BasicEntity> modifyOne(@RequestBody BasicEntity entity, @PathVariable Long id) {
        return ResponseEntity.status(OK).body(service.modify(entity, id));
    }

    @DeleteMapping("/rest/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
