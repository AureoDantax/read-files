package br.com.spring.readfiles.beans;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@SuperBuilder
@Table(name = "FUNCIONARIO")
@NoArgsConstructor
public class Funcionario extends BaseEntity{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column
   private UUID id;


    @Column
    private String nome;

    @ManyToOne
    private Departamento departamento;

    private BigDecimal salario;
}
