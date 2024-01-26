package it.almaviva.difesa.sipad.aadba.pratpprocatt.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class TpPratpProcAttId implements Serializable {

    private static final long serialVersionUID = -4002411721077356273L;

    @Column(name = "PRATP_PRATT_ID_PK", nullable = false)
    private Long pratpPrattIdPk;

    @Column(name = "PRATP_PRTPO_ID_PK", nullable = false)
    private Long pratpPrtpoIdPk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TpPratpProcAttId entity = (TpPratpProcAttId) o;
        return Objects.equals(this.pratpPrtpoIdPk, entity.pratpPrtpoIdPk) &&
                Objects.equals(this.pratpPrattIdPk, entity.pratpPrattIdPk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pratpPrtpoIdPk, pratpPrattIdPk);
    }

}