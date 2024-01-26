package it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class OrganigrammaPk implements Serializable {

    private String staooCodPk;
    private String codLoginPk;
}
