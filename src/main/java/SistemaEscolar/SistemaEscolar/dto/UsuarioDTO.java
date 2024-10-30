package SistemaEscolar.SistemaEscolar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private String username;
    private String senha;

    public UsuarioDTO(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }
}


//DTO data transfer object