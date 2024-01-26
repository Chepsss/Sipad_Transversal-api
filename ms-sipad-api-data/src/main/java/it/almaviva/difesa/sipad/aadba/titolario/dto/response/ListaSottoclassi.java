package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ListaSottoclassi implements Serializable {
 private static final long serialVersionUID = 515636642122351398L;
 private transient List<TitolarioOption> sottoclassi;

}
