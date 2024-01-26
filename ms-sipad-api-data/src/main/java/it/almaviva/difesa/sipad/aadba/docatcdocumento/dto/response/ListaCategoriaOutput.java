package it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ListaCategoriaOutput implements Serializable {
    private static final long serialVersionUID = 8438928016280971954L;


    private List<CategoriaDto> categorie;
}
