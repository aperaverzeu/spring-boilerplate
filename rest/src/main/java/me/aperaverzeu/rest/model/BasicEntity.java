package me.aperaverzeu.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "base")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column
    private String name;
    @Column
    private List<String> values;
}
