package it.almaviva.difesa.sipad.stgcecessazione.service;

import it.almaviva.difesa.sipad.shared.dto.response.GenericResponse;
import it.almaviva.difesa.sipad.stgcecessazione.TsStgceCessazioneRequest;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.dto.TsStgceCessazioneDTO;

public interface TsStgceCessazioneService {

    TsStgceCessazioneDTO insert(TsStgceCessazioneDTO stgceCessazioneRequestDTO);

    TsStgceCessazioneDTO getStgceCessazioneByCodFiscaleAndNumDecreto (TsStgceCessazioneRequest request);

    GenericResponse callStoredProcedureCessazione(TsStgceCessazioneRequest request);

}
