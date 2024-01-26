package it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response;

import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.CategoriaDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ListaTipiDocumentiOutput implements Serializable {
    private static final long serialVersionUID = -6971539081151543014L;


    private List<CategoriaDto> tipiDocumenti;
}
