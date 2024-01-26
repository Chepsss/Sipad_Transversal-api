package it.almaviva.difesa.sipad.prattattivazione.service;

import it.almaviva.difesa.sipad.aadba.prattattivazione.dto.response.TpPrattAttivazioneDTO;

import java.util.List;

public interface TpPrattAttivazioneService {

    List<TpPrattAttivazioneDTO> list(String acrProc, Boolean onlyNotExpired);

    TpPrattAttivazioneDTO getById(Long id);
}
