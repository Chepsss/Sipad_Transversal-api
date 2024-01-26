package it.almaviva.difesa.sipad.aadba.ageLimits.dto.request;

import it.almaviva.difesa.sipad.shared.dto.GenericRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
public class TpCelceLimitiCszPerEtaRequestDTO implements GenericRequestDTO {

    private String celceSggraSeqPk;
    private String celceSgruoSeqPk;
    private String celceSgffaSeqPk;
    private Integer celceLimitaEta;
    private LocalDate celceDataIniz;
    private LocalDate celceDataFine;
    private Instant celceDataIns;
    private Instant celceDataUltAgg;
    private String celceCodUltAgg;
}
