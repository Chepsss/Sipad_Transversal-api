package it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.entity;


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
@Table(name = "VW_DO001_TEMPLATE_ANAGR")
public class VwDo001TemplateAnagr implements Serializable, GenericEntity, Sortable {

    private static final long serialVersionUID = 2429418803254187752L;

    @Id
    @Column(name = "DO001_ID_DIP")
    private Long idDip;

    @Column(name = "DO001_DESCR_COGN")
    private String descrCogn;

    @Column(name = "DO001_DESCR_NOME")
    private String descrNome;

    @Column(name = "DO001_DATA_NASC")
    private LocalDate dataNasc;

    @Column(name = "DO001_COD_FSC")
    private String codFsc;

    @Column(name = "DO001_ID_NASC")
    private Long idNasc;

    @Column(name = "DO001_DESCR_COMUNE_NASC")
    private String descrComuneNasc;

    @Column(name = "D001_SIGLA_PROV")
    private String siglaProv;

    @Column(name = "DO001_COD_CAT_PERS")
    private String codCatPers;

    @Column(name = "DO001_DESCR_CAT_PERS")
    private String descrCatPers;

    @Column(name = "DO001_DESCR_POS_SERV")
    private String descrPosServ;

    @Column(name = "DO001_COD_STATO_GIU")
    private Long codStatoGiu;

    @Column(name = "DO001_DESCR_STATO_GIU")
    private String descrStatoGiu;

    @Column(name = "DO001_DESCR_GRADO")
    private String descrGrado;

    @Column(name = "DO001_DESCR_RUOLO")
    private String descrRuolo;

    @Column(name = "DO001_COD_FFAA")
    private String codFfaa;

    @Column(name = "DO001_COD_ARMA_CORPO")
    private String codArmaCorpo;

    @Column(name = "DO001_DESCR_ARMA_CORPO")
    private String descrArmaCorpo;

    @Column(name = "DO001_COD_MATRICOLA")
    private String codMatricola;

    @Column(name = "DO001_DATA_ARR")
    private LocalDate dataArr;

    @Override
    public Sort getSort() {
        return null;
    }
}
