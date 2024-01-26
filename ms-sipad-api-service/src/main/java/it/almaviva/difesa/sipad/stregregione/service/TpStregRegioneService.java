package it.almaviva.difesa.sipad.stregregione.service;

import it.almaviva.difesa.sipad.aadba.stregregione.dto.TpStregRegioneDTO;

import java.util.List;

public interface TpStregRegioneService {

    List<TpStregRegioneDTO> listRegions();

    TpStregRegioneDTO getRegionById(Long idRegion);

}
