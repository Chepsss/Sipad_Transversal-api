package it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter

public class TbStoraOrganigrammaAooDto implements Serializable {


    private String staooCodPk;
    private String codLoginPk;
    private String denomLiv1;
    private String denomLiv2;
    private String denomLiv3;
    private String denomLiv4;
    private String denomLiv5;
    private String flagRif;
    private String flagEsp;
    private Integer numLivello;
    private Long idUo;
    private Long storaIdRuolo;

}
