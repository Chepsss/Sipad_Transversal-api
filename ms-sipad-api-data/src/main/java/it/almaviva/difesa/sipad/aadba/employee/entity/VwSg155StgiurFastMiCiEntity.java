package it.almaviva.difesa.sipad.aadba.employee.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "VW_SG155_STGIUR_FAST_MI_CI")
public class VwSg155StgiurFastMiCiEntity implements Serializable, GenericEntity {
    private static final long serialVersionUID = -4610120750585863599L;
    @Id
    @Column(name = "SG155_ID_DIP")
    private Long sg155IdDip;

    @Column(name = "SG155_COGNOME", length = 50)
    private String sg155Cognome;

    @Column(name = "SG155_NOME", length = 50)
    private String sg155Nome;

    @Column(name = "SG155_CODICE_FISCALE", length = 16)
    private String sg155CodiceFiscale;

    @Column(name = "SG155_DATA_NASCITA")
    private LocalDate sg155DataNascita;

    @Column(name = "SG155_SESSO", length = 1)
    private String sg155Sesso;

    @Column(name = "SG155_MAIL", length = 100)
    private String sg155Mail;

    @Column(name = "SG155_COD_GRADO", length = 12)
    private String sg155CodGrado;

    @Column(name = "SG155_DESCR_GRADO", length = 100)
    private String sg155DescrGrado;

    @Column(name = "SG155_COD_FFAA", length = 12)
    private String sg155CodFfaa;

    @Column(name = "SG155_DESCR_FFAA")
    private String sg155DescrFfaa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwSg155StgiurFastMiCiEntity that = (VwSg155StgiurFastMiCiEntity) o;
        return getSg155IdDip() != null && Objects.equals(getSg155IdDip(), that.getSg155IdDip());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}