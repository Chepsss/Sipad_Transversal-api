package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class Sottoclasse implements Serializable {
    private static final long serialVersionUID = 5795178570352211252L;

    private String descrizione;
    private String identificativo;
    private List<Fascicolo> fascicoli;

}
