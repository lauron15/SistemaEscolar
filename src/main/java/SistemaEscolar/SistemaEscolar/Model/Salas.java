package SistemaEscolar.SistemaEscolar.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "")
@Data

public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private Long id;

    @Column(name = "")
    private String numero;

    @Column(name = "")
    private int capacidade;

}
