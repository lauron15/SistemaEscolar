package SistemaEscolar.SistemaEscolar.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    public Long id;

    @Column(name = "")
    private String nome;

    @Column(name = "")
    private int cargaHoraria;

}
