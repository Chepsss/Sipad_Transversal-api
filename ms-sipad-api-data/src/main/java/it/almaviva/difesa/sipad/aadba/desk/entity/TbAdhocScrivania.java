package it.almaviva.difesa.sipad.aadba.desk.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter(AccessLevel.NONE)
@Entity
@ToString
@Table(name = "tb_adhoc_scrivania")
public class TbAdhocScrivania implements Serializable, GenericEntity {

    private static final long serialVersionUID = 2415275489105522586L;

    @Id
    @Column(name = "ADHOC_COD_PK")
    private String adhocCodPk;

    @Column(name = "ADHOC_COD_APP")
    private String adhocCodApp;

    @Column(name = "ADHOC_COD_PK_DES")
    private String adhocCodPkDes;

    @Column(name = "ADHOC_COD_ULT_AGG")
    private String adhocCodUltAgg;

    @Column(name = "ADHOC_DATA_ULT_AGG")
    private String adhocDataUltAgg;

    @Column(name = "ADHOC_SGCTP_CATPERS")
    private Long adhocSgctpCatpers;

}
