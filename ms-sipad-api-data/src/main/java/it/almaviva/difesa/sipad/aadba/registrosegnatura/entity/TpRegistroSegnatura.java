package it.almaviva.difesa.sipad.aadba.registrosegnatura.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter(AccessLevel.NONE)
@Entity
@ToString
@Table(name = "TP_REGISTRO_SEGNATURA")
public class TpRegistroSegnatura implements GenericEntity {
    @Id
    @Column(name = "PK_ID" )
    private Long pkId;

    @Column(name = "NOME_REGISTRO" )
    private String nomeRegistro;

    @Column(name = "TIPO_REGISTRO" )
    private String tipoRegistro;

    @Column(name = "reg_cod_adhoc")
    private String regCodAdhoc;

    @Column(name = "reg_cod_adhoc_ingresso")
    private String regCodAdhocIngresso;
}
