package it.almaviva.difesa.sipad.stnaznazione.service;

import it.almaviva.difesa.sipad.aadba.stnaznazione.dto.TpStnazNazioneDTO;

import java.util.List;

public interface TpStnazNazioneService {

    List<TpStnazNazioneDTO> listNations();

    TpStnazNazioneDTO getNationById(Long idNation);

}
