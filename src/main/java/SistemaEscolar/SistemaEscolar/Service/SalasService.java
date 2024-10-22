package SistemaEscolar.SistemaEscolar.Service;

import SistemaEscolar.SistemaEscolar.Model.Salas;
import SistemaEscolar.SistemaEscolar.Repository.ISalasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalasService {

    private final ISalasRepository repository;

    public SalasService(ISalasRepository repository) {
        this.repository = repository;
    }

    public List<Salas> listarSalas() {
        return repository.findAll();
    }

    public Optional<Salas> listarSalasPorId(Long id) {
        return repository.findById(id);
    }

    public Salas criarSalar(Salas salas) {
        return repository.save(salas);
    }

    public Salas editarSalas(Salas salas, Long id) {
        salas.setId(id);
        return repository.findById(id).map(SalaExistente -> repository.save(salas))
                .orElseThrow(() -> new RuntimeException("A Sala com o id" + id + "não foi encontrada"));
    }

    public boolean excluirSalas(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Vaga com o ID" + id + "não encontrada");
        }
    }

}
