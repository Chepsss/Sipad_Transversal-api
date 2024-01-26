package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class Titolario implements Serializable {

    private static final long serialVersionUID = -3329486715095748435L;

    private List<Titolo> titoli;
}
