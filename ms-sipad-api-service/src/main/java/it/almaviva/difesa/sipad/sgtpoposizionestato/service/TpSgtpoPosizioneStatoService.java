package it.almaviva.difesa.sipad.sgtpoposizionestato.service;

import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.EmployeeCategoryDTO;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.RequestDTO;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.TpSgtpoPosizioneStatoDTO;

import java.util.List;

public interface TpSgtpoPosizioneStatoService {

    List<TpSgtpoPosizioneStatoDTO> findAll();

    EmployeeCategoryDTO getCategories();

    List<TpSgtpoPosizioneStatoDTO> getCategoriesOfLeaveNonAdmissibility(RequestDTO requestDTO);

    List<TpSgtpoPosizioneStatoDTO> getCategoriesOfLeave(RequestDTO requestDTO);

    TpSgtpoPosizioneStatoDTO getCategoryById(String id);

    List<TpSgtpoPosizioneStatoDTO> getCategoriesByAcr(String acrPosizione);

}
