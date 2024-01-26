package it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.entity;


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
@Table(name = "VW_SG122_STGIURIDICO_DS")
public class VwSg122StgiuridicoDs implements Serializable, GenericEntity, Sortable {

    private static final long serialVersionUID = 1929418803254197752L;

    @Id
    @Column(name = "SG122_ID_DIP")
    private Long idDip;

    @Column(name = "SG122_DATA_ARRUOLAMENTO")
    private LocalDate dataArruolamento;

    @Column(name = "SG122_ID_FORZA_ARMATA")
    private String idForzaArmata;

    @Column(name = "SG122_DESCR_FORZA_ARMATA")
    private String descrForzaArmata;

    @Column(name = "SG122_COD_GRADO")
    private String codGrado;

    @Column(name = "SG122_DESCR_GRADO")
    private String descrGrado;

    @Column(name = "SG122_DATA_DEC_GIU_GRADO")
    private LocalDate dataDecGiuGrado;

    @Column(name = "SG122_DESCR_STATO_GRADO")
    private String descrStatoGrado;

    @Column(name = "SG122_DESCR_CATEGORIA")
    private String descrCategoria;

    @Column(name = "SG122_COD_RUOLO")
    private String codRuolo;

    @Column(name = "SG122_DESCR_RUOLO")
    private String descrRuolo;

    @Column(name = "SG122_DATA_DEC_GIU_RUOLO")
    private LocalDate dataDecGiuRuolo;

    @Column(name = "SG122_DESCR_STATO_RUOLO")
    private String descrStatoRuolo;

    @Column(name = "SG122_COD_POSIZIONE")
    private String codPosizione;

    @Column(name = "SG122_DATA_DEC_GIU_POSIZIONE")
    private LocalDate dataDecGiuPosizione;

    @Column(name = "SG122_DESCR_POSIZIONE")
    private String descrPosizione;

    @Column(name = "SG122_DESCR_STATO_POSIZIONE")
    private String descrStatoPosizione;

    @Column(name = "SG122_COD_TIP_ARMA_CORPO")
    private String codTipArmaCorpo;

    @Column(name = "SG122_DESCR_TIPO_ARMA_CORPO")
    private String descrTipoArmaCorpo;

    @Column(name = "SG122_DATA_DEC_GIU_IMM")
    private LocalDate dataDecGiuImm;

    @Column(name = "SG122_DATA_IMM")
    private LocalDate dataImm;

    @Column(name = "SG122_ID_CAT_PERSONALE")
    private Long idCatPersonale;

    @Column(name = "SG122_ID_CAT_POS_STATO")
    private Long idCatPosStato;

    @Column(name = "SG122_DESCR_CATO_POS_STATO")
    private String descrCatoPosStato;

    @Column(name = "SG122_DATA_INI_TIP_POS_STATO")
    private LocalDate dataIniTipPosStato;

    @Column(name = "SG122_DECOR_ECON_RUOLO")
    private LocalDate decorEconRuolo;

    @Column(name = "SG122_DECOR_ECON_GRADO")
    private LocalDate decorEconGrado;

    @Column(name = "SG122_DATA_DESCR_POSSER")
    private LocalDate dataDescrPosser;

    @Column(name = "SG122_ID_POSSER")
    private String idPosser;

    @Column(name = "SG122_DESCR_POSSER")
    private String descrPosser;

    @Column(name = "SG122_ID_CTP_CAT_PERSONALE")
    private Long idCtpCatPersonale;

    @Column(name = "SG122_DECGIU_CATO_POS_STATO")
    private LocalDate decgiuCatoPosStato;

    @Override
    public Sort getSort() {
        return null;
    }
}
