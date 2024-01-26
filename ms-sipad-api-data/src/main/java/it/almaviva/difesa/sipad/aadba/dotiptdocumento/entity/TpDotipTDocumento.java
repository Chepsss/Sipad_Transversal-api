package it.almaviva.difesa.sipad.aadba.dotiptdocumento.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "tp_dotip_tdocumento")
public class TpDotipTDocumento implements Serializable, GenericEntity {

    private static final long serialVersionUID = 5797466398966267915L;

    //            dotip_cod_pk varchar(4) not null,
    @Id
    @Column(name = "dotip_cod_pk")
    private String cod;
    //            dotip_descr_tip character varying(100) not null,
    @Column(name = "dotip_descr_tip")
    private String descrTip;

    //    dotip_acr_tip  character varying(30) not null,
    @Column(name = "dotip_acr_tip")
    private String acrTip;

    //    dotip_prtpa_id bigint not null,
    @Column(name = "dotip_prtpa_id")
    private String prtpaId;

    //    dotip_data_iniz date not null,
    @Column(name = "dotip_data_iniz")
    private Date dataIniz;

    //    dotip_data_fine date not null,
    @Column(name = "dotip_data_fine")
    private Date dataFine;

    //    dotip_flag_tipo char(1),
    @Column(name = "dotip_flag_tipo")
    private String flagTipo;
    //    dotip_flag_firma char(1) default ‘N’ not null,
    @Column(name = "dotip_flag_firma")
    private String flagFirma;

    //    dotip_flag_archivio char(1) default ‘N’
    @Column(name = "dotip_flag_archivio")
    private String flagArchivio;

    //    dotip_flag_invio char(1) default ‘N’ not null,
    @Column(name = "dotip_flag_invio")
    private String flagInvio;

    //    dotip_docat_id bigint not null,
    @Column(name = "dotip_docat_id")
    private long docatId;

    //    dotip_flag_esp char(1) default ‘S’ not null,
    @Column(name = "dotip_flag_esp")
    private String flagEsp;

    //    dotip_flag_can char(1) default ‘S’ not null,
    @Column(name = "dotip_flag_can")
    private String flagCan;

    //    dotip_flag_mod char(1) default ‘S’ not null,
    @Column(name = "dotip_flag_mod")
    private String flagMod;

    //    dotip_data_ins timestamp without time zone NOT NULL,
    @Column(name = "dotip_data_ins")
    private Timestamp dataIns;

    //    dotip_cod_ult_agg character varying(20) COLLATE pg_catalog."defadotiplt" NOT NULL,
    @Column(name = "dotip_cod_ult_agg")
    private String codUltAgg;
//    dotip_data_ult_agg timestamp without time zone NOT NULL,

    @Column(name = "dotip_data_ult_agg")
    private Timestamp dataUltAgg;


}
