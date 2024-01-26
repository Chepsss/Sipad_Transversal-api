package it.almaviva.difesa.sipad.aadba.registrosegnatura.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TpRegistroSegnaturaDTO implements Serializable {

    private Long pkId;
    private String nomeRegistro;
    private String tipoRegistro;
    private String regCodAdhoc;
    private String regCodAdhocIngresso;
}
