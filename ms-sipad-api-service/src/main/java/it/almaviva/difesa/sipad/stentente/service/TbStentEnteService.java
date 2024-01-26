package it.almaviva.difesa.sipad.stentente.service;

import it.almaviva.difesa.sipad.aadba.stentente.dto.TbStentEnteDTO;

import java.util.List;

public interface TbStentEnteService {

    List<TbStentEnteDTO> getEnteByDenomEnte(String demonEnte);

    TbStentEnteDTO getEnteById(String idEnte);

}
