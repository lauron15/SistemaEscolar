package SistemaEscolar.SistemaEscolar.Controller;

import SistemaEscolar.SistemaEscolar.Model.Usuario;
import SistemaEscolar.SistemaEscolar.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/usuario")

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.listarUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        Usuario usuaroAtualizado = usuarioService.editarUsuario(usuario, id);
        return ResponseEntity.status(200).body(usuaroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> validarSenha(@RequestBody Usuario usuario) {
        Boolean valid = usuarioService.validarSenha(usuario);
        if (!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.status(200).build();
        }
    }

}



