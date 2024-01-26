package it.almaviva.difesa.sipad.aadba.employee.dto.response;

import it.almaviva.difesa.sipad.shared.dto.GenericResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class VwSg155StgiuridicoFastDTO implements GenericResponseDTO {

    private Long sg155IdDip;
    private String sg155Cognome;
    private String sg155Nome;
    private String sg155CodiceFiscale;
    private Date sg155DataNascita;
    private String sg155DescrGrado;
    private String sg155DescrRuolo;
    private String sg155DescrPosser;
    private Short sg155ValGerarchia;
    private String sg155CodFfaa;
}
