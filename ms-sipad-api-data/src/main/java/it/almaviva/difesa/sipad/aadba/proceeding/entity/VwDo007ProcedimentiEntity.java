package it.almaviva.difesa.sipad.aadba.proceeding.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "VW_DO007_PROCEDIMENTI")
public class VwDo007ProcedimentiEntity implements GenericEntity {

    @Basic
    @Column(name = "DO007_COD_FISC", length = 16)
    private String do007CodFisc;
    @Id
    @Basic
    @Column(name = "DO007_PRPRO_ID", length = 12)
    private String do007PrproId;
    @Basic
    @Column(name = "DO007_PRPRO_COD_PRO", length = 100)
    private String do007PrproCodPro;
    @Basic
    @Column(name = "DO007_DATA_AVVIO")
    private LocalDate do007DataAvvio;
    @Basic
    @Column(name = "DO007_DATA_FINE")
    private LocalDate do007DataFine;
    @Basic
    @Column(name = "DO007_FASE", length = 100)
    private String do007Fase;
    @Basic
    @Column(name = "DO007_STATO", length = 100)
    private String do007Stato;
    @Basic
    @Column(name = "DO007_TIPO_PROC", length = 100)
    private String do007TipoProc;
    @Basic
    @Column(name = "DO007_AUTORE", length = 101)
    private String do007Autore;
}
