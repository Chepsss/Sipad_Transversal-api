package it.almaviva.difesa.sipad.stcomcomune.service;

import it.almaviva.difesa.sipad.aadba.stcomcomune.dto.TpStcomComuneDTO;

import java.util.List;

public interface TpStcomComuneService {

    List<TpStcomComuneDTO> listCities();

    TpStcomComuneDTO getCityById(Long idCity);

    List<TpStcomComuneDTO> listCitiesByProvince(Long idProvince);

}
