package it.almaviva.difesa.sipad.aadba.hierarchy.dto;


import it.almaviva.difesa.sipad.shared.dto.GenericResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VwSg003SggraGradoDTO implements GenericResponseDTO {


    private String sg003CodiceGrado;
    private String sg003DescrGrado;
    private LocalDate sg003DataIniz;
    private LocalDate sg003DataFine;
    private Long sg003SgctpId;
    private String sg003StfaaId;
    private String sg003CodiceSipad1;
    private String sg003CodUid;
    private String sg003SggraCodSup;
    private Integer sg003SggraValGerarchia;
}
