package it.almaviva.difesa.sipad.aadba.stnaznazione.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_STNAZ_NAZIONE")
public class TpStnazNazione implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = 2242274558306297492L;

    @Id
    @Column(name = "STNAZ_ID_PK", nullable = false, length = 12)
    private Long id;

    @Column(name = "STNAZ_COD_NAZIONE", length = 4)
    private String stnazCodNazione;

    @Column(name = "STNAZ_COD_ISTAT", length = 10)
    private String stnazCodIstat;

    @Column(name = "STNAZ_ACR_NAZIONE", length = 20)
    private String stnazAcrNazione;

    @Column(name = "STNAZ_DESCR_NAZIONE", nullable = false, length = 100)
    private String stnazDescrNazione;

    @Column(name = "STNAZ_DATA_INIZ", nullable = false)
    private LocalDateTime stnazDataIniz;

    @Column(name = "STNAZ_DATA_FINE", nullable = false)
    private LocalDateTime stnazDataFine;

    @Column(name = "STNAZ_DATA_INS", nullable = false)
    private LocalDateTime stnazDataIns;

    @Column(name = "STNAZ_COD_ULT_AGG", nullable = false, length = 50)
    private String stnazCodUltAgg;

    @Column(name = "STNAZ_DATA_ULT_AGG", nullable = false)
    private LocalDateTime stnazDataUltAgg;

    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}