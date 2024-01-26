package it.almaviva.difesa.sipad.aadba.immissione.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ImmissioneDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificativo univoco del dipendente
     */
    private Long id;

    /**
     * Progressivo immissione in servizio
     */
    private Long prgPk;

    /**
     * Data di prima immissione in servizio da usare per il calcolo dell''anzianità di servizio. (Coincide con al data di arruolamento?)
     */
    private LocalDate dataImm;

    /**
     * Data decorrenza Giuridica
     */
    private LocalDate dataDecGiu;

    /**
     * Data decorrenza Economica
     */
    private LocalDate dataDecEco;

    /**
     * Data del giuramento. Forse va eliminata
     */
    private LocalDate dataGiuramento;

    /**
     * Sede dove è stato prestato il giuramento. Forse va eliminata
     */
    private String descrSedeGiu;

    /**
     * Data decorrenza giuridica precedente alla legge 186????. Va chiarito il significato
     */
    private LocalDate dataAnteGiu186;

    /**
     *  Flag legge 186 (0 = nessuna legge applicata / 1 = tipologia legge applicata)
     */
    private String flagLegge;

    /**
     * Data fine decorrenza
     */
    private LocalDate dataCes;

    /**
     * Codice identificativo della causale immissione
     */
    private String sgcaiCod;

    /**
     * Codice identificativo della causale cessazione
     */
    private String sgcacCod;

    /**
     * Identificativo univoco della categoria di posizione di stato
     */
    private Long sgctsId;

    /**
     * Codice della FF.AA. di appartenenza
     */
    private String stfaaId;

    /**
     * Codice Identificativo della qualifica attribuita all''atto dell''immissione nella categoria di P.S.
     */
    private String sgquaCod;

    /**
     * Identificativo univoco della categoria del personale militare all''atto dell''imissione in servizio
     */
    private Long sgctpId;

    /**
     * Codice della tipologia di Arma e Corpo
     */
    private String starcCod;


    /**
     * Codice stato del record
     */
    private String sgstaCod;

    /**
     * Identificativo univoco del documento che sancisce la situazione giuridica del record di riferimento.
     * Al momento la tabella riferisce la tabella TB_SGDOC,  ma a regime dovrà riferire la tabella TB_DODOC
     * nella quale dovranno confluire sia i documenti pregressi che quelli generati dai procedimenti amministrativi.
     */
    private Long dodocSeq;

    /**
     * Codice fonte de dato
     */
    private String opfonCod;

    /**
     * Identificativo codice  della variazione
     */
    private String prtivCodUid;


}
