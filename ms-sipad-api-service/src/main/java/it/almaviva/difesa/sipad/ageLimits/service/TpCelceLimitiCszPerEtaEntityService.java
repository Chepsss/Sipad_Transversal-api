package it.almaviva.difesa.sipad.ageLimits.service;

import it.almaviva.difesa.sipad.aadba.ageLimits.dto.request.LimiteEtaRequestDTO;
import it.almaviva.difesa.sipad.aadba.ageLimits.dto.request.TpCelceLimitiCszPerEtaRequestDTO;

public interface TpCelceLimitiCszPerEtaEntityService {

    Long calculateAgeLimits(TpCelceLimitiCszPerEtaRequestDTO dto);

    Integer getLimite(LimiteEtaRequestDTO dto);
}
