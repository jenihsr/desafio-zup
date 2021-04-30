package br.com.desafioorangetalents.jenifer.desafiozup.controllers;

import br.com.desafioorangetalents.jenifer.desafiozup.models.Endereco;
import br.com.desafioorangetalents.jenifer.desafiozup.repositories.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> createAddress (@RequestBody Endereco endereco, UriComponentsBuilder uri) {
        enderecoRepository.save(endereco);
        URI uriCreated = uri.path("/endereco/{id}").build(endereco.getId());
        return ResponseEntity.created(uriCreated).build();
    }
    @GetMapping
    public ResponseEntity<?> buscaEnderecos (@RequestParam Long idUsuario){
        List<Endereco> enderecos = enderecoRepository.findAllByUsuarioId(idUsuario);
        return ResponseEntity.ok(enderecos);
    }
}
