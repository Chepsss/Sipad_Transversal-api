package it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.entity;


import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Sort;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "VW_SG123_STGIURIDICO_DSUNIFIC")
public class VwSg123StgiuridicoDsunific implements Serializable, GenericEntity, Sortable {

    private static final long serialVersionUID = 2030518803254197752L;

    @Id
    @Column(name = "sg123_id_dip")
    private Long sg123IdDip;

    @Column(name = "sg123_cognome", nullable = false, length = 50)
    private String sg123Cognome;

    @Column(name = "sg123_nome", nullable = false, length = 50)
    private String sg123Nome;

    @Column(name = "sg123_codice_fiscale", nullable = false, length = 16)
    private String sg123CodiceFiscale;

    @Column(name = "sg123_data_nascita", nullable = false)
    private LocalDate sg123DataNascita;

    @Column(name = "sg123_matricola", length = 20)
    private String sg123Matricola;

    @Column(name = "sg123_data_arruolamento")
    private LocalDate sg123DataArruolamento;

    @Column(name = "sg123_id_forza_armata")
    private String sg123IdForzaArmata;

    @Column(name = "sg123_descr_forza_armata")
    private String sg123DescrForzaArmata;

    @Column(name = "sg123_cod_grado")
    private String sg123CodGrado;

    @Column(name = "sg123_descr_grado")
    private String sg123DescrGrado;

    @Column(name = "sg123_data_dec_giu_grado")
    private LocalDate sg123DataDecGiuGrado;

    @Column(name = "sg123_descr_stato_grado")
    private String sg123DescrStatoGrado;

    @Column(name = "sg123_descr_categoria")
    private String sg123DescrCategoria;

    @Column(name = "sg123_cod_ruolo")
    private String sg123CodRuolo;

    @Column(name = "sg123_descr_ruolo")
    private String sg123DescrRuolo;

    @Column(name = "sg123_data_dec_giu_ruolo")
    private LocalDate sg123DataDecGiuRuolo;

    @Column(name = "sg123_descr_stato_ruolo")
    private String sg123DescrStatoRuolo;

    @Column(name = "sg123_cod_posizione")
    private String sg123CodPosizione;

    @Column(name = "sg123_data_dec_giu_posizione")
    private LocalDate sg123DataDecGiuPosizione;

    @Column(name = "sg123_descr_posizione")
    private String sg123DescrPosizione;

    @Column(name = "sg123_descr_stato_posizione")
    private String sg123DescrStatoPosizione;

    @Column(name = "sg123_cod_tip_arma_corpo")
    private String sg123CodTipArmaCorpo;

    @Column(name = "sg123_descr_tipo_arma_corpo")
    private String sg123DescrTipoArmaCorpo;

    @Column(name = "sg123_data_dec_giu_imm")
    private LocalDate sg123DataDecGiuImm;

    @Column(name = "sg123_data_imm")
    private LocalDate sg123DataImm;

    @Column(name = "sg123_id_cat_personale")
    private Long sg123IdCatPersonale;

    @Column(name = "sg123_id_cat_pos_stato")
    private Long sg123IdCatPosStato;

    @Column(name = "sg123_descr_cato_pos_stato")
    private String sg123DescrCatoPosStato;

    @Column(name = "sg123_data_ini_tip_pos_stato")
    private LocalDate sg123DataIniTipPosStato;

    @Column(name = "sg123_decor_econ_ruolo")
    private LocalDate sg123DecorEconRuolo;

    @Column(name = "sg123_decor_econ_grado")
    private LocalDate sg123DecorEconGrado;

    @Column(name = "sg123_data_descr_posser")
    private LocalDate sg123DataDescrPosser;

    @Column(name = "sg123_id_posser")
    private String sg123IdPosser;

    @Column(name = "sg123_descr_posser")
    private String sg123DescrPosser;

    @Column(name = "sg123_id_ctp_cat_personale")
    private Long sg123IdCtpCatPersonale;

    @Column(name = "sg123_decgiu_cato_pos_stato")
    private LocalDate sg123DecgiuCatoPosStato;

    @Column(name = "sg123_id_forza_armata_prec")
    private String sg123IdForzaArmataPrec;

    @Column(name = "sg123_descr_forza_armata_prec")
    private String sg123DescrForzaArmataPrec;

    @Column(name = "sg123_cod_grado_prec")
    private String sg123CodGradoPrec;

    @Column(name = "sg123_descr_grado_prec")
    private String sg123DescrGradoPrec;

    @Column(name = "sg123_id_cat_pers_prec")
    private Long sg123IdCatPersPrec;

    @Column(name = "sg123_descr_cat_pers_prec")
    private String sg123DescrCatPersPrec;

    @Column(name = "sg123_dsctp_id_pk")
    private Long sg123DsctpIdPk;

    @Column(name = "sg123_dsctp_descr_catmilit")
    private String sg123DsctpDescrCatmilit;

    @Column(name = "sg123_sgcts_id_cat_sg_prec")
    private Long sg123SgctsIdCatSgPrec;

    @Column(name = "sg123_sgcts_descr_cat_sg_prec")
    private String sg123SgctsDescrCatSgPrec;

    @Column(name = "sg123_sgtpo_cod_cat_per_prec")
    private String sg123SgtpoCodCatPerPrec;

    @Column(name = "sg123_sgtpo_descr_cat_per_prec")
    private String sg123SgtpoDescrCatPerPrec;

    @Column(name = "sg123_sgtps_id_pos_sta_prec")
    private String sg123SgtpsIdPosStaPrec;

    @Column(name = "sg123_sgtps_descr_pos_sta_prec")
    private String sg123SgtpsDescrPosStaPrec;

    @Column(name = "sg123_gtps_data_pos_sta_prec")
    private LocalDate sg123GtpsDataPosStaPrec;

    @Column(name = "sg123_data_dec_giu_grado_prec")
    private LocalDate sg123DataDecGiuGradoPrec;

    @Column(name = "sg123_cod_ruolo_prec")
    private String sg123CodRuoloPrec;

    @Column(name = "sg123_descr_ruolo_prec")
    private String sg123DescrRuoloPrec;

    @Column(name = "sg123_data_ruolo_prec")
    private LocalDate sg123DataRuoloPrec;

    @Column(name = "sg123_descr_pro_nas")
    private String sg123DescrProNas;

    @Column(name = "sg123_descr_com_nas")
    private String sg123DescrComNas;

    @Column(name = "sg123_descr_stato_civile")
    private String sg123DescrStatoCivile;

    @Column(name = "sg123_flag_sesso")
    private String sg123FlagSesso;

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwSg123StgiuridicoDsunific that = (VwSg123StgiuridicoDsunific) o;
        return sg123IdDip != null && Objects.equals(sg123IdDip, that.sg123IdDip);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
