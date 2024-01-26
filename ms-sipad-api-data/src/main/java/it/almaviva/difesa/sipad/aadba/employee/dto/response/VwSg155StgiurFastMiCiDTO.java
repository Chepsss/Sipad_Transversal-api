package it.almaviva.difesa.sipad.aadba.employee.dto.response;

import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiurFastMiCiEntity;
import it.almaviva.difesa.sipad.shared.dto.GenericResponseDTO;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link VwSg155StgiurFastMiCiEntity} entity
 */
@Data
public class VwSg155StgiurFastMiCiDTO implements Serializable, GenericResponseDTO {
    private static final long serialVersionUID = -413017014052025824L;
    private Long sg155IdDip;
    private String sg155Cognome;
    private String sg155Nome;
    private String sg155CodiceFiscale;
    private LocalDate sg155DataNascita;
    private String sg155Sesso;
    private String sg155Mail;
    private String sg155CodGrado;
    private String sg155DescrGrado;
    private String sg155CodFfaa;
    private String sg155DescrFfaa;
}