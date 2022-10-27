package br.com.spring.readfiles.inputfiles.repositories;

import br.com.spring.readfiles.beans.Departamento;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DepartamentoRepository extends CrudRepository<Departamento, UUID> {

    Departamento findFirstByNome (String nome);
}
