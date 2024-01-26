package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class Classe implements Serializable {

    private static final long serialVersionUID = 2398099729654120723L;

    private String descrizione;
    private String identificativo;
    private List<Sottoclasse> sottoclassi;
}
