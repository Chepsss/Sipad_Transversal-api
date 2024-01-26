package it.almaviva.difesa.sipad.aadba.dosta.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpDostaStatoDTO implements Serializable {

    private static final long serialVersionUID = 6299470392383103632L;

    private Long id;
    private String descrSta;
    private String acrSta;
    private Date dataIniz;
    private Date dataFine;

}
