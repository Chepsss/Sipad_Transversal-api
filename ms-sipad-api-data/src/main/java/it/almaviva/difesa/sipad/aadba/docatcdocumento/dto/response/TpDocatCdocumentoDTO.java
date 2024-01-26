package it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpDocatCdocumentoDTO implements Serializable {

    private static final long serialVersionUID = 4270486760217605345L;

    private Long id;
    @JsonProperty("docatDescrCat")
    private String descrCat;
    @JsonProperty("docatAcrCat")
    private String acrCat;
    @JsonProperty("docatDataIniz")
    private LocalDate dataIniz;
    @JsonProperty("docatDataFine")
    private LocalDate dataFine;


}
