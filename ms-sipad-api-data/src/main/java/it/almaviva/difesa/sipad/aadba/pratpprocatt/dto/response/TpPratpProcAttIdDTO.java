package it.almaviva.difesa.sipad.aadba.pratpprocatt.dto.response;

import lombok.Data;

import java.io.Serializable;


@Data
public class TpPratpProcAttIdDTO implements Serializable {

    private static final long serialVersionUID = -4874123670336435725L;

    private final Long pratpPrattIdPk;
    private final Long pratpPrtpoIdPk;
}
