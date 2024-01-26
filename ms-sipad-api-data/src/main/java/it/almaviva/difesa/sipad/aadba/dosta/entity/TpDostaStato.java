package it.almaviva.difesa.sipad.aadba.dosta.entity;

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

@Table(name = "tp_dosta_stato")
public class TpDostaStato implements Serializable, GenericEntity {

    private static final long serialVersionUID = -4733579767074328561L;


    //    dosta_id_pk bigint not null,
    @Id
    @Column(name = "dosta_id_pk")
    private long id;

    //    dosta_descr_sta character varying(100) not null,
    @Column(name = "dosta_descr_sta")
    private String descrSta;


    //    dosta_acr_sta character varying(30) not null,
    @Column(name = "dosta_acr_sta")
    private String acrSta;

    //    dosta_data_iniz date not null,
    @Column(name = "dosta_data_iniz")
    private Date dataIniz;
    //    dosta_data_fine date not null,
    @Column(name = "dosta_data_fine")
    private Date dataFine;
    //    data_ins timestamp without time zone NOT NULL,
    @Column(name = "dosta_data_ins")
    private Timestamp dataIns;

    //    cod_ult_agg character varying(20) COLLATE pg_catalog."default" NOT NULL,
    @Column(name = "dosta_cod_ult_agg")
    private String codUltAgg;

    //    data_ult_agg timestamp without time zone NOT NULL,
    @Column(name = "dosta_data_ult_agg")
    private Timestamp dataUltAgg;

}
