package br.com.xingling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xingling.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
}
