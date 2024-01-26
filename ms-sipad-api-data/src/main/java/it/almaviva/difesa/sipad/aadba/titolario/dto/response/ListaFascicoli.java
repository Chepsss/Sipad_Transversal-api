package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ListaFascicoli implements Serializable {
 private static final long serialVersionUID = -6062180350849068340L;
 private transient List<TitolarioOption> fascicoli;

}
