package br.com.spring.readfiles.inputfiles.repositories;

import br.com.spring.readfiles.beans.Departamento;
import br.com.spring.readfiles.beans.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FuncionarioRepository extends CrudRepository<Funcionario, UUID> {
}
