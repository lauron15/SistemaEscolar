package SistemaEscolar.SistemaEscolar.Model;


import jakarta.persistence.*;
import lombok.Data;
;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "senha")
    private String senha;

    //Quando for criptografar senhas, lembrar de aumentar o tamanho, para 255


    @Column(name = "role")
    private String role;

}
