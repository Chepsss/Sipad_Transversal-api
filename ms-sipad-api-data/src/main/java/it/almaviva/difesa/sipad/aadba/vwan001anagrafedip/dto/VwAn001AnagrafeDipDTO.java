package it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.dto;

import it.almaviva.difesa.sipad.shared.dto.GenericResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VwAn001AnagrafeDipDTO implements GenericResponseDTO {

    private Long idDip;
    private String cognome;
    private String nome;
    private String codFiscale;
    private LocalDate dataNascita;
    private String sesso;
    private String codMatricola;
    private String mailUfficio;
    private String descrComNas;
    private Long idComNas;
    private String descrProNas;
    private String codProNas;
    private String descrNazNas;
    private String indRes;
    private String capRes;
    private String descrComRes;
    private String descrProRes;
    private String codProRes;
    private String descrStatoCivile;
    private LocalDate dataStatoCivile;
    private Long idStatoCivile;
    private String resEstera;
    private String indDomicilio;
    private String capDomicilio;
    private String comuneDomicilio;
    private String nazioneEsteraDom;
    private String provinciaDomicilio;
    private String codProvDom;
    private String stfaa;

}
