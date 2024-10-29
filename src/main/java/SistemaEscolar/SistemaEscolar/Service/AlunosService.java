package SistemaEscolar.SistemaEscolar.Service;

import SistemaEscolar.SistemaEscolar.Model.Alunos;
import SistemaEscolar.SistemaEscolar.Repository.IAlunosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    private final IAlunosRepository repository;

    public AlunosService(IAlunosRepository repository) {
        this.repository = repository;
    }

    //BUSCAR

    public List<Alunos> listarAlunos() {
        return repository.findAll();
    }

    //BUSCAR COM ID

    public Optional<Alunos> listarAlunosPorId(Long id) {
        return repository.findById(id);
    }

    // CADASTRAR ALUNO

    public Alunos cadastrarAlunos(Alunos alunos) {
        return repository.save(alunos);
    }

    // EDITAR ALUNO

    public Alunos editarAluno(Alunos alunos, Long id) {
        alunos.setId(id);
        return repository.findById(id).map(alunoExistente -> repository.save(alunos))
                .orElseThrow(() -> new RuntimeException("O Aluno com o ID" + id + "não foi encontrado"));
    }

    public boolean excluirAluno(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("O Aluno com o id" + id + "não foi encontrado");
        }

    }


}
