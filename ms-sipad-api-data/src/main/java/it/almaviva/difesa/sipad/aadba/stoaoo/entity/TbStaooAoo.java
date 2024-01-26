package it.almaviva.difesa.sipad.aadba.stoaoo.entity;


import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "tb_staoo_aoo")
public class TbStaooAoo implements GenericEntity {


    //
//                    staoo_cod_pk character varying(20) NOT NULL,
    @Id
    @Column(name = "staoo_cod_pk")
    private String cod;

    //    staoo_acr_aoo character varying(20) NOT NULL,
    @Column(name = "staoo_acr_aoo")
    private String acrAoo;


    //    staoo_descr_aoo character varying(100),
    @Column(name = "staoo_descr_aoo")
    private String descrAoo;

    //    staoo_mail_aoo character varying(100),
    @Column(name = "staoo_mail_aoo")
    private String mailAoo;
    //    staoo_data_iniz date DEFAULT to_date('0001-01-01'::text, 'YYYY-MM-DD'::text),
    @Column(name = "staoo_data_iniz")
    private Date dataIniz;


//    staoo_data_fine date DEFAULT to_date('9999-12-31'::text, 'YYYY-MM-DD'::text),

    @Column(name = "staoo_data_fine")
    private Date dataFine;
//    staoo_stopr_id_ord integer,


    @Column(name = "staoo_stopr_id_ord")
    private Long stoprIdOrd;


    //    staoo_data_ins timestamp(6) without time zone NOT NULL DEFAULT now(),
    @Column(name = "staoo_data_ins")
    private LocalDateTime dataIns;

    //    staoo_cod_ult_agg character varying(50) NOT NULL,
    @Column(name = "staoo_cod_ult_agg")
    private String codUltAgg;
    //    staoo_data_ult_agg timestamp(6) without time zone NOT NULL DEFAULT now(),
    @Column(name = "staoo_data_ult_agg")
    private LocalDateTime dataUltAgg;


}
