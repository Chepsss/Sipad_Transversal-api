package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ListaClassi implements Serializable {
 private static final long serialVersionUID = 9217758974819446058L;
 private transient List<TitolarioOption> classi;

}
