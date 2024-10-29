package SistemaEscolar.SistemaEscolar.Service;

import SistemaEscolar.SistemaEscolar.Model.Usuario;
import SistemaEscolar.SistemaEscolar.Repository.IUsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final IUsuarioRepository repository;
    private PasswordEncoder passwordEncoder; //methodo para codificar senha

    public UsuarioService(IUsuarioRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder(); //segunda parte da cryptografia
    }

    //PEGAR

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    //PEGAR POR ID

    public Optional<Usuario> listarUsuarioPorId(Long id) {
        return repository.findById(id);
    }

    // CRIAR USUARIO

    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha()); // interceptação para pegar a senha na criação do usuário e a devolver codificada.
        usuario.setSenha(encoder); //segunda parte, estamos setando a senha codificada.
        return repository.save(usuario);
    }

    //EDITAR USUARIO
    public Usuario editarUsuario(Usuario usuario, Long id) {
        usuario.setId(id);
        return repository.findById(id).map(usuarioExistente -> repository.save(usuario))
                .orElseThrow(() -> new RuntimeException("O usuario com o ID" + id + "não foi encontrada"));
    }

    public boolean excluirUsuario(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Usuario com o ID" + id + "não encontrado");
        }
    }
}
