package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ListaTitoli implements Serializable {

 private static final long serialVersionUID = -6345742843443857170L;
 private transient List<TitolarioOption> titoli;

}
