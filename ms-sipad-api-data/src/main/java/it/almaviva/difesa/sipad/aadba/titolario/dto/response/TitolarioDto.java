package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import it.almaviva.difesa.sipad.shared.dto.GenericResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TitolarioDto implements GenericResponseDTO {

    private static final long serialVersionUID = 1315794245889452627L;
    private String staooCod;
    private String codTit;
    private String descrTit;
    private String codCla;
    private String descrCla;
    private String codSotcla;
    private String descrSotcla;
    private String codFas;
    private String descrFas;
    private String codSotfas;
    private String descrSotfas;
    private Timestamp dataIns;
    private Timestamp dataUltAgg;
    private String codUltAgg;
    private String flagVers;
}
