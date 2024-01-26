package it.almaviva.difesa.sipad.aadba.dsctpcatmilit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpDsctpCatmilitDTO implements Serializable {

    private static final long serialVersionUID = 7275709639860808801L;

    private Long id;
    private String dsctpDescrCatmilit;
    private String dsctpAcrCatmilit;
    private String dsctpSgctpId;
    private LocalDate dsctpDataIniz;
    private LocalDate dsctpDataFine;
    private Long dsctpNumOrd;
    private Long dsctpSggraValGerarchiaDa;
    private Long dsctpSggraValGerarchiaA;

}
