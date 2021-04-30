package br.com.desafioorangetalents.jenifer.desafiozup.controllers;

import br.com.desafioorangetalents.jenifer.desafiozup.models.Endereco;
import br.com.desafioorangetalents.jenifer.desafiozup.models.Usuario;
import br.com.desafioorangetalents.jenifer.desafiozup.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> createUser (@RequestBody Usuario usuario, UriComponentsBuilder uri) {
        usuarioRepository.save(usuario);
        URI uriCreated = uri.path("/usuario/{id}").build(usuario.getId());
        return ResponseEntity.created(uriCreated).build();
    }
//    @GetMapping(value = "/{id}")
//    public List<Endereco> AchaEnderecoDOUser(@PathVariable Long id) throws Exception {
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        if(usuario.isPresent()){
//            return usuario.get().getEnderecos();
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping ("/{id}/enderecos")
//    public void adicionaEndereco (@Valid @PathVariable Long id, Endereco endereco) {
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        if(usuario.isPresent()){
//           usuario.get().getEnderecos().add(endereco);
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }
}
