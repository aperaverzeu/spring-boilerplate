package me.aperaverzeu.rest.repository;

import me.aperaverzeu.rest.model.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicRepository extends JpaRepository<BasicEntity, Long> {}
