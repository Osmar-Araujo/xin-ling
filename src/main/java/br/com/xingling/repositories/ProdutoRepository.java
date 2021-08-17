package br.com.xingling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xingling.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
