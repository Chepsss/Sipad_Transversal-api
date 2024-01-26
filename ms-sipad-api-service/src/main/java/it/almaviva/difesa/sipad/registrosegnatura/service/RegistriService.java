package it.almaviva.difesa.sipad.registrosegnatura.service;

import it.almaviva.difesa.sipad.aadba.registrosegnatura.dto.response.TpRegistroSegnaturaDTO;

import java.util.List;


public interface RegistriService {
    List<TpRegistroSegnaturaDTO> list();

    TpRegistroSegnaturaDTO findByTipoRegistro(String id);
}
