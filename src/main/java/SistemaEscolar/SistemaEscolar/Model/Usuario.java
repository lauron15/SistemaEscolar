package SistemaEscolar.SistemaEscolar.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private Long id;

    @Column(name = "")
    private String username;

    @Column(name = "")
    private String senha;

    @Column(name = "")
    private String role;

}
