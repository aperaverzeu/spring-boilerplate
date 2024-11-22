package me.aperaverzeu.rest.controller;

import lombok.RequiredArgsConstructor;
import me.aperaverzeu.rest.model.BasicEntity;
import me.aperaverzeu.rest.service.BasicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class BasicController {
    private final BasicService service;

    @GetMapping("any")
    public ResponseEntity<BasicEntity> getAny() {
        return ResponseEntity.ok(service.getAny().orElseThrow(() -> new IllegalStateException("There are no entities!")));
    }

    @GetMapping("all")
    public ResponseEntity<List<BasicEntity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("")
    public ResponseEntity<BasicEntity> saveOne(@RequestBody BasicEntity entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(Long id) {
        service.delete(id);
        return ResponseEntity.ok("deleted " + id);
    }
}
