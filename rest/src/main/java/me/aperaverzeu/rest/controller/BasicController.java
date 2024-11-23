package me.aperaverzeu.rest.controller;

import lombok.RequiredArgsConstructor;
import me.aperaverzeu.rest.model.BasicEntity;
import me.aperaverzeu.rest.service.BasicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController("/")
@RequiredArgsConstructor
public class BasicController {
    private final BasicService service;

    @GetMapping
    public ResponseEntity<BasicEntity> getOneById(@RequestParam("id") Long id) {
        return ResponseEntity.status(OK).body(service.getOneById(id).orElseThrow());
    }

    @GetMapping("any")
    public ResponseEntity<BasicEntity> getAny() {
        return ResponseEntity.status(OK).body(service.getAny().orElseThrow());
    }

    @GetMapping("all")
    public ResponseEntity<List<BasicEntity>> getAll() {
        return ResponseEntity.status(OK).body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<BasicEntity> saveOne(@RequestBody BasicEntity entity) {
        return ResponseEntity.status(CREATED).body(service.save(entity));
    }

    @PutMapping
    public ResponseEntity<BasicEntity> modifyOne(@RequestBody BasicEntity entity) {
        return ResponseEntity.status(OK).body(service.modify(entity));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(OK).body("deleted " + id);
    }
}
