package br.com.spring.readfiles.beans;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@SuperBuilder
@Table(name = "DEPARTAMENTO")
@NoArgsConstructor
@Data
public class Departamento extends BaseEntity {


    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String nome;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @Builder.Default
    private Set<Funcionario> funcionario = new HashSet<>();
}
