package SistemaEscolar.SistemaEscolar.Repository;

import SistemaEscolar.SistemaEscolar.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByusername(String username);
}
