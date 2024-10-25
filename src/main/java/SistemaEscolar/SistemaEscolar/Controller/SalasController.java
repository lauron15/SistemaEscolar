package SistemaEscolar.SistemaEscolar.Controller;

import SistemaEscolar.SistemaEscolar.Model.Salas;
import SistemaEscolar.SistemaEscolar.Service.SalasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
@CrossOrigin("*")
public class SalasController {

    private final SalasService salasService;

    public SalasController(SalasService salasService) {
        this.salasService = salasService;
    }

    @GetMapping
    public ResponseEntity<List<Salas>> listarSalas() {
        List<Salas> salas = salasService.listarSalas();
        return ResponseEntity.status(200).body(salas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salas> listarSalasPorId(@PathVariable Long id) {
        Optional<Salas> salas = salasService.listarSalasPorId(id);
        return salas.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Salas> criaSalar(@RequestBody Salas salas) {
        return ResponseEntity.status(201).body(salasService.criarSalas(salas));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salas> editarSalas(@RequestBody Salas salas, @PathVariable Long id) {
        Salas salasAtualizadas = salasService.editarSalas(salas, id);
        return ResponseEntity.status(200).body(salasAtualizadas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSalas(@PathVariable Long id) {
        salasService.excluirSalas(id);
        return ResponseEntity.status(204).build();
    }
}
