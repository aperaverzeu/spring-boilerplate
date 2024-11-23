package me.aperaverzeu.rest.service;

import lombok.RequiredArgsConstructor;
import me.aperaverzeu.rest.model.BasicEntity;
import me.aperaverzeu.rest.repository.BasicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasicService {
    private final BasicRepository repository;

    public Optional<BasicEntity> getOneById(Long id) {
        return repository.findById(id);
    }

    public Optional<BasicEntity> getAny() {
        return repository.findAll().stream().findAny();
    }

    public List<BasicEntity> getAll() {
        return repository.findAll();
    }

    public BasicEntity save(BasicEntity basicEntity) {
        return repository.save(basicEntity);
    }

    public BasicEntity modify(BasicEntity basicEntity) {
        var entity = repository.findById(basicEntity.getId()).orElseThrow();
        var modifiedEntity = BasicEntity.builder()
                .id(entity.getId())
                .name(basicEntity.getName())
                .values(basicEntity.getValues())
                .build();
        return repository.save(modifiedEntity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
