package SistemaEscolar.SistemaEscolar.Controller;


import SistemaEscolar.SistemaEscolar.Model.Cursos;
import SistemaEscolar.SistemaEscolar.Repository.ICursoRepository;
import SistemaEscolar.SistemaEscolar.Service.CursosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/cursos")
public class CursosController {

    private final CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    @GetMapping
    public ResponseEntity<List<Cursos>> listarCursos() {
        List<Cursos> cursos = cursosService.listarCursos();
        return ResponseEntity.status(200).body(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> buscarCursoPorId(@PathVariable Long id) {
        Optional<Cursos> cursos = cursosService.buscarCursoPorId(id);
        return cursos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Cursos> criarCurso(@RequestBody Cursos cursos) {
        return ResponseEntity.status(201).body(cursosService.criarCurso(cursos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cursos> editarCurso(@RequestBody Cursos cursos, @PathVariable Long id) {
        Cursos cursosAtualizados = cursosService.editarCurso(cursos, id);
        return ResponseEntity.status(200).body(cursosAtualizados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> editarUsuario(@PathVariable Long id) {
        cursosService.excluirCurso(id);
        return ResponseEntity.status(204).build();
    }

}
