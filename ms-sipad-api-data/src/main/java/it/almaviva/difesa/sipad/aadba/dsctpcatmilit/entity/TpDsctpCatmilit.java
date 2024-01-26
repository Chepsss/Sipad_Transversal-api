package it.almaviva.difesa.sipad.aadba.dsctpcatmilit.entity;

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
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_DSCTP_CATMILIT")
public class TpDsctpCatmilit implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = 1131174558306297492L;

    @Id
    @Column(name = "dsctp_id_pk", nullable = false)
    private Long id;

    @Column(name = "dsctp_descr_catmilit", nullable = false)
    private String dsctpDescrCatmilit;

    @Column(name = "dsctp_acr_catmilit", length = 10)
    private String dsctpAcrCatmilit;

    @Column(name = "dsctp_sgctp_id_pk", nullable = false)
    private String dsctpSgctpId;

    @Column(name = "dsctp_data_iniz", nullable = false)
    private LocalDate dsctpDataIniz;

    @Column(name = "dsctp_data_fine")
    private LocalDate dsctpDataFine;

    @Column(name = "dsctp_num_ord")
    private Long dsctpNumOrd;

    @Column(name = "dsctp_data_ins", nullable = false)
    private LocalDateTime dsctpDataIns;

    @Column(name = "dsctp_data_ult_agg", nullable = false)
    private LocalDateTime dsctpDataUltAgg;

    @Column(name = "dsctp_cod_ult_agg", nullable = false, length = 50)
    private String dsctpCodUltAgg;

    @Column(name = "dsctp_sggra_val_gerarchia_da")
    private Long dsctpSggraValGerarchiaDa;

    @Column(name = "dsctp_sggra_val_gerarchia_a")
    private Long dsctpSggraValGerarchiaA;


    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}