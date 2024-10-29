package SistemaEscolar.SistemaEscolar.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cursos")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cargahoraria")
    private int cargaHoraria;

}
