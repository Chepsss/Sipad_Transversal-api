package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ListaSottofascicoli implements Serializable {
 private static final long serialVersionUID = 4562405572777966498L;
 private transient List<TitolarioOption> sottofascicoli;

}
