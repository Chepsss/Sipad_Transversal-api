package it.almaviva.difesa.sipad.aastg.stgcecessazione.entity.composite;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Embeddable
public class CFNumDecretoCompositeKey implements Serializable {

    @Column(name = "STGCE_CODICE_FISCALE", nullable = false, length = 20)
    private String stgceCodiceFiscale;

    @Column(name = "STGCE_NUMERO_DECRETO", nullable = false, length = 50)
    private String stgceNumeroDecreto;

}
