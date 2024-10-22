package SistemaEscolar.SistemaEscolar.Service;

import SistemaEscolar.SistemaEscolar.Model.Usuario;
import SistemaEscolar.SistemaEscolar.Repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final IUsuarioRepository repository;

    public UsuarioService(IUsuarioRepository repository) {
        this.repository = repository;
    }

    //PEGAR

    public List<Usuario> listarUsuarios(){
        return repository.findAll();
    }

    //PEGAR POR ID

    public Optional<Usuario>listarUsuarioPorId(Long id){
        return repository.findById(id);
    }

    // CRIAR USUARIO

    public Usuario criarUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    //EDITAR USUARIO
    public Usuario editarUsuario (Usuario usuario, Long id){
        usuario.setId(id);
        return repository.findById(id).map(usuarioExistente -> repository.save(usuario))
                .orElseThrow(() -> new RuntimeException("O usuario com o ID" + id + "não foi encontrada" ));
    }
}
