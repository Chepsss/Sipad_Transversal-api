package it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import lombok.*;
import org.springframework.data.domain.Sort;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "vw_sg001_stgiuridico_mil")
public class VwSg001StgiuridicoMil implements Serializable, GenericEntity, Sortable {

    private static final long serialVersionUID = 1329418803254197752L;

    @Column(name = "sg001_descr_grado_sup", length = 100)
    private String descrGradoSup;

    @Id
    @Column(name = "sg001_id_dip")
    private Long idDip;

    @Column(name = "sg001_id_forza_armata", length = 12)
    private String idForzaArmata;

    @Column(name = "sg001_descr_forza_armata")
    private String descrForzaArmata;

    @Column(name = "sg001_cod_grado", length = 12)
    private String codGrado;

    @Column(name = "sg001_descr_grado", length = 100)
    private String descrGrado;

    @Column(name = "sg001_data_dec_giu_grado")
    private LocalDate dataDecGiuGrado;

    @Column(name = "sg001_descr_stato_grado", length = 100)
    private String descrStatoGrado;

    @Column(name = "sg001_descr_categoria")
    private String descrCategoria;

    @Column(name = "sg001_cod_ruolo", length = 12)
    private String codRuolo;

    @Column(name = "sg001_descr_ruolo")
    private String descrRuolo;

    @Column(name = "sg001_data_dec_giu_ruolo")
    private LocalDate dataDecGiuRuolo;

    @Column(name = "sg001_descr_stato_ruolo", length = 100)
    private String descrStatoRuolo;

    @Column(name = "sg001_cod_posizione", length = 12)
    private String codPosizione;

    @Column(name = "sg001_data_dec_giu_posizione")
    private LocalDate dataDecGiuPosizione;

    @Column(name = "sg001_descr_posizione", length = 100)
    private String descrPosizione;

    @Column(name = "sg001_descr_stato_posizione", length = 100)
    private String descrStatoPosizione;

    @Column(name = "sg001_cod_tip_arma_corpo", length = 12)
    private String codTipArmaCorpo;

    @Column(name = "sg001_descr_tipo_arma_corpo", length = 100)
    private String descrTipoArmaCorpo;

    @Column(name = "sg001_data_dec_giu_imm")
    private LocalDate dataDecGiuImm;

    @Column(name = "sg001_data_imm")
    private LocalDate dataImm;

    @Column(name = "sg001_id_cat_personale")
    private Long idCatPersonale;

    @Column(name = "sg001_id_cat_pos_stato")
    private Long idCatPosStato;

    @Column(name = "sg001_descr_cato_pos_stato", length = 100)
    private String descrCatoPosStato;

    @Column(name = "sg001_data_ini_tip_pos_stato")
    private LocalDate dataIniTipPosStato;

    @Column(name = "sg001_decor_econ_ruolo")
    private LocalDate decorEconRuolo;

    @Column(name = "sg001_decor_econ_grado")
    private LocalDate decorEconGrado;

    @Column(name = "sg001_data_descr_posser")
    private LocalDate dataDescrPosser;

    @Column(name = "sg001_descr_posser", length = 100)
    private String descrPosser;

    @Column(name = "sg001_id_ctp_cat_personale")
    private Long idCtpCatPersonale;

    @Column(name = "sg001_id_posser", length = 10)
    private String idPosser;

    @Override
    public Sort getSort() {
        return null;
    }

}
