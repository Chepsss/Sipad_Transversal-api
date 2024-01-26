package it.almaviva.difesa.sipad.aadba.proceeding.dto.response;

import it.almaviva.difesa.sipad.shared.dto.GenericResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VwDo007ProcedimentiDTO implements GenericResponseDTO {

    private String do007CodFisc;
    private String do007PrproId;
    private String do007PrproCodPro;
    private LocalDate do007DataAvvio;
    private LocalDate do007DataFine;
    private String do007Fase;
    private String do007Stato;
    private String do007TipoProc;
    private String do007Autore;
}
