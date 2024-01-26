package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Fascicolo implements Serializable {
    private static final long serialVersionUID = 5807232861272083827L;

    private String descrizione;
    private String identificativo;

}
