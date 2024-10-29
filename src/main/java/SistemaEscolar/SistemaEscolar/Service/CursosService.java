package SistemaEscolar.SistemaEscolar.Service;

import SistemaEscolar.SistemaEscolar.Model.Cursos;
import SistemaEscolar.SistemaEscolar.Repository.ICursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    private final ICursoRepository repository;

    public CursosService(ICursoRepository repository) {
        this.repository = repository;
    }

    //BUSCAR TODOS

    public List<Cursos> listarCursos() {
        return repository.findAll();
    }

    // BUSCAR POR ID

    public Optional<Cursos> buscarCursoPorId(Long id) {
        return repository.findById(id);
    }

    //Criar Curso
    public Cursos criarCurso(Cursos cursos) {
        return repository.save(cursos);
    }

    //EditarCurso

    public Cursos editarCurso(Cursos cursos, Long id) {
        cursos.setId(id);
        return repository.findById(id).map(CursoExistente -> repository.save(cursos))
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

    }

    //ExcluirVaga

    public boolean excluirCurso(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Vaga com o Id" + id + "Não encontrada.");
        }
    }

}
