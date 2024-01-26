package it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CategoriaDto implements Serializable {
    private static final long serialVersionUID = -7955660111503287103L;

    private String codice;
    private String descrizione;

}
