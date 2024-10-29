package SistemaEscolar.SistemaEscolar.Controller;


import SistemaEscolar.SistemaEscolar.Model.Alunos;
import SistemaEscolar.SistemaEscolar.Service.AlunosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping
    public ResponseEntity<List<Alunos>> listarAlunos() {
        List<Alunos> alunos = alunosService.listarAlunos();
        return ResponseEntity.status(200).body(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alunos> listarAlunosPorId(@PathVariable Long id) {
        Optional<Alunos> alunos = alunosService.listarAlunosPorId(id);
        return alunos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Alunos> cadastrarAlunos(@RequestBody Alunos alunos) {
        return ResponseEntity.status(201).body(alunosService.cadastrarAlunos(alunos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alunos> editarAluno(@RequestBody Alunos alunos, @PathVariable Long id) {

        Alunos alunosAtualizados = alunosService.editarAluno(alunos, id);
        return ResponseEntity.status(200).body(alunosAtualizados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAlunos(@PathVariable Long id) {
        alunosService.excluirAluno(id);
        return ResponseEntity.status(204).build();
    }

}
