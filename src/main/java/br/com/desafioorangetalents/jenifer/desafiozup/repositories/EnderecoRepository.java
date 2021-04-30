package br.com.desafioorangetalents.jenifer.desafiozup.repositories;

import br.com.desafioorangetalents.jenifer.desafiozup.models.Endereco;
import br.com.desafioorangetalents.jenifer.desafiozup.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
List<Endereco> findAllByUsuarioId(Long id);
}
