package it.almaviva.difesa.sipad.aadba.ageLimits.dto.request;

import it.almaviva.difesa.sipad.shared.dto.GenericRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LimiteEtaRequestDTO implements GenericRequestDTO {

    private String rankId;
    private String roleId;
    private String armedForceId;

}
