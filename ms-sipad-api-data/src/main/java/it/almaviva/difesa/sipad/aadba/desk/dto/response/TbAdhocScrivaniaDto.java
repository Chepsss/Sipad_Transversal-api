package it.almaviva.difesa.sipad.aadba.desk.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TbAdhocScrivaniaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String adhocCodPk;
    private String adhocCodApp;
    private String adhocCodPkDes;
    private String adhocCodUltAgg;
    private String adhocDataUltAgg;
    private Long adhocSgctpCatpers;

}
