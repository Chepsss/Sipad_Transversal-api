package it.almaviva.difesa.sipad.aastg.stgcecessazione.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TsStgceCessazioneDTO implements Serializable {

    private static final long serialVersionUID = 7273609639860808801L;

    private String stgceCodiceFiscale;
    private LocalDate stgceDataDecorrenza;
    private String stgceCodUidTt01; //codUid Forza armata
    private String stgceCodUidTt03; // codUid CatMilitare
    private String stgceCodUidTt05; // "AE110" = MILITARI IN CONGEDO
    private String stgceCodUidTt06; // "AF53" = CONGEDO
    private String stgceCodUidTt07; // codUid PosizioneStato
    private String stgceCodUidTt51; // acrTiv CetipCessazione
    private String stgceNumeroDecreto; // numero protocollo decreto
    private LocalDate stgceDataDecreto; // data inserimento protocollo
    private String stgceOggettoDecreto;
    private Long stgceDodocSeq;
    private String stgceFlagElaborato;
    private String stgceElabMsg;
    private LocalDate stgceDataElab;
    private String stgceCodUltAgg; // Campo di audit indicante l'ultimo utente in aggiornamento sul record
    private String stgcePromTitOnor; // promozione a titolo onorario (Valori ammessi S, N, null )
}
