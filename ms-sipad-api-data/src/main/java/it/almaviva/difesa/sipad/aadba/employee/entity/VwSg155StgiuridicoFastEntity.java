package it.almaviva.difesa.sipad.aadba.employee.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "VW_SG155_STGIUR_FAST")
public class VwSg155StgiuridicoFastEntity implements GenericEntity {

    @Id
    @Basic
    @Column(name = "SG155_ID_DIP", nullable = false, precision = 0)
    private Long sg155IdDip;
    @Basic
    @Column(name = "SG155_COGNOME", nullable = false, length = 50)
    private String sg155Cognome;
    @Basic
    @Column(name = "SG155_NOME", nullable = false, length = 50)
    private String sg155Nome;
    @Basic
    @Column(name = "SG155_CODICE_FISCALE", nullable = false, length = 16)
    private String sg155CodiceFiscale;
    @Basic
    @Column(name = "SG155_DATA_NASCITA", nullable = false)
    private Date sg155DataNascita;
    @Basic
    @Column(name = "SG155_DESCR_GRADO", length = 100)
    private String sg155DescrGrado;
    @Basic
    @Column(name = "SG155_DESCR_RUOLO", length = 255)
    private String sg155DescrRuolo;
    @Basic
    @Column(name = "SG155_DESCR_POSSER", length = 100)
    private String sg155DescrPosser;
    @Basic
    @Column(name = "SG155_VAL_GERARCHIA", precision = 0)
    private Short sg155ValGerarchia;
    @Basic
    @Column(name = "SG155_COD_FFAA", length = 12)
    private String sg155CodFfaa;

}
