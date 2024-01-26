package it.almaviva.difesa.sipad.aadba.titolario.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class InputTitolarioDTO implements Serializable {

    private String codiceTitolo;
    private String codiceClasse;
    private String codiceSottoclasse;
    private String codiceFascicolo;
    private String codiceSottofascicolo;

    private String filtro;
    private Integer max;

}
