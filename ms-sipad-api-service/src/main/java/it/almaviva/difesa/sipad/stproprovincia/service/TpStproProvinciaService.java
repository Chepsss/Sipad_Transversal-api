package it.almaviva.difesa.sipad.stproprovincia.service;

import it.almaviva.difesa.sipad.aadba.stproprovincia.dto.TpStproProvinciaDTO;

import java.util.List;

public interface TpStproProvinciaService {

    List<TpStproProvinciaDTO> listProvinces();

    TpStproProvinciaDTO getProvinceById(Long idProvince);

}
