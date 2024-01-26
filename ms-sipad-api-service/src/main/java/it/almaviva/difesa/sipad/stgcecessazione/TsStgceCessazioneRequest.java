package it.almaviva.difesa.sipad.stgcecessazione;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TsStgceCessazioneRequest {

    @NotNull
    private String codiceFiscale;
    @NotNull
    private String numeroDecreto;
}
