package it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.dto;

import it.almaviva.difesa.sipad.shared.dto.GenericResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VwDo001TemplateAnagrDTO implements GenericResponseDTO {

    private Long idDip;
    private String descrCogn;
    private String descrNome;
    private LocalDate dataNasc;
    private String codFsc;
    private Long idNasc;
    private String descrComuneNasc;
    private String siglaProv;
    private String codCatPers;
    private String descrCatPers;
    private String descrPosServ;
    private Long codStatoGiu;
    private String descrStatoGiu;
    private String descrGrado;
    private String descrRuolo;
    private String codFfaa;
    private String codArmaCorpo;
    private String descrArmaCorpo;
    private String codMatricola;
    private LocalDate dataArr;
}
