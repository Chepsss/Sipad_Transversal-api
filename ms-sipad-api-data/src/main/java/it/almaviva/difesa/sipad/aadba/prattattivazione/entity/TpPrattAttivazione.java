package it.almaviva.difesa.sipad.aadba.prattattivazione.entity;

import it.almaviva.difesa.sipad.aadba.pratpprocatt.entity.TpPratpProcAtt;
import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 * Modalità di attivazione di un tipo procedimento amministrativo:
 * <ul>
 *  <li>Su istanza diretta.</li>
 *  <li>D'ufficio su istanza di terzi</li>
 *  <li>D'ufficio per esigenze interne all'amministrazione</li>
 *  <li>Da altro procedimento amministrativo</li>
 *  <li>..........</li>
 * </ul>
 * </p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TP_PRATT_ATTIVAZIONE")
public class TpPrattAttivazione implements GenericEntity {

    private static final long serialVersionUID = 1212531529675886848L;

    @Id
    @Column(name = "PRATT_ID_PK", nullable = false)
    private Long id;

    @Column(name = "PRATT_DESCR_ATT", length = 100)
    private String prattDescrAtt;

    @Column(name = "PRATT_ACR_ATT", length = 30)
    private String prattAcrAtt;

    @Column(name = "PRATT_DATA_INIZ")
    private LocalDate prattDataIniz;

    @Column(name = "PRATT_DATA_FINE")
    private LocalDate prattDataFine;

    @Column(name = "PRATT_DATA_INS", nullable = false)
    private LocalDateTime prattDataIns;

    @Column(name = "PRATT_DATA_ULT_AGG", nullable = false)
    private LocalDateTime prattDataUltAgg;

    @Column(name = "PRATT_COD_ULT_AGG", nullable = false, length = 50)
    private String prattCodUltAgg;

    @OneToMany(mappedBy = "pratpPrattIdPk")
    private Set<TpPratpProcAtt> tpPratpProcAtts = new LinkedHashSet<>();

//    @Override
//    public Sort getSort() {
//        return SortConstant.SORT_BY_ID;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TpPrattAttivazione that = (TpPrattAttivazione) o;
        return id.equals(that.id)
                && Objects.equals(prattDescrAtt, that.prattDescrAtt)
                && Objects.equals(prattAcrAtt, that.prattAcrAtt)
                && Objects.equals(prattDataIniz, that.prattDataIniz)
                && Objects.equals(prattDataFine, that.prattDataFine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prattDescrAtt, prattAcrAtt, prattDataIniz, prattDataFine);
    }
}