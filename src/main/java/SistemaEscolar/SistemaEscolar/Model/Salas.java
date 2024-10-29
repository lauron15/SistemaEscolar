package SistemaEscolar.SistemaEscolar.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "salas")
@Data

public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "capacidade")
    private int capacidade;

}
