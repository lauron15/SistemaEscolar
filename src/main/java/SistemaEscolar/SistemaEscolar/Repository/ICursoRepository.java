package SistemaEscolar.SistemaEscolar.Repository;

import SistemaEscolar.SistemaEscolar.Model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Cursos, Long> {
}
