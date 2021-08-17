package br.com.xingling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xingling.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
