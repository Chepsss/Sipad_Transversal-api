package it.almaviva.difesa.sipad.sgtpoposizionestato.service.impl;

import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.EmployeeCategoryDTO;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.RequestDTO;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.TpSgtpoPosizioneStatoDTO;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.entity.TpSgtpoPosizioneStato;
import it.almaviva.difesa.sipad.sgtpoposizionestato.mapper.TpSgtpoPosizioneStatoMapper;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.repository.TpSgtpoPosizioneStatoRepository;
import it.almaviva.difesa.sipad.sgtpoposizionestato.service.TpSgtpoPosizioneStatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TpSgtpoPosizioneStatoServiceImpl implements TpSgtpoPosizioneStatoService {

    @Autowired
    TpSgtpoPosizioneStatoRepository tpSgtpoPosizioneStatoRepository;

    @Autowired
    TpSgtpoPosizioneStatoMapper tpSgtpoPosizioneStatoMapper;

    @Override
    public List<TpSgtpoPosizioneStatoDTO> findAll() {
        List<TpSgtpoPosizioneStato> tpSgtpoPosizioneStatoes = tpSgtpoPosizioneStatoRepository.findAll();
        return tpSgtpoPosizioneStatoMapper.toDto(tpSgtpoPosizioneStatoes);
    }

    @Override
    public List<TpSgtpoPosizioneStatoDTO> getCategoriesOfLeaveNonAdmissibility(RequestDTO requestDTO) {
        List<TpSgtpoPosizioneStato> tpSgtpoPosizioneStatoes = tpSgtpoPosizioneStatoRepository.getCategoryOfLeaveNonAdmissibility(requestDTO.getIds());
        return tpSgtpoPosizioneStatoMapper.toDto(tpSgtpoPosizioneStatoes);
    }

    @Override
    public EmployeeCategoryDTO getCategories() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        EmployeeCategoryDTO employeeCategoryDTO = new EmployeeCategoryDTO();
        employeeCategoryDTO.setCategories(tpSgtpoPosizioneStatoRepository.getDistinctByIdInOrderBySgtpoDescrPosizione(ids));
        return employeeCategoryDTO;
    }

    @Override
    public List<TpSgtpoPosizioneStatoDTO> getCategoriesOfLeave(RequestDTO requestDTO) {
        List<TpSgtpoPosizioneStato> tpSgtpoPosizioneStatoes = tpSgtpoPosizioneStatoRepository.getCategoryOfLeave(requestDTO.getIds());
        return tpSgtpoPosizioneStatoMapper.toDto(tpSgtpoPosizioneStatoes);
    }

    @Override
    public TpSgtpoPosizioneStatoDTO getCategoryById(String id) {
        TpSgtpoPosizioneStato category = tpSgtpoPosizioneStatoRepository.getById(id);
        return tpSgtpoPosizioneStatoMapper.toDto(category);
    }

    @Override
    public List<TpSgtpoPosizioneStatoDTO> getCategoriesByAcr(String acrPosizione) {
        List<TpSgtpoPosizioneStato> sgtpoPosizioneStatoes = tpSgtpoPosizioneStatoRepository.getCategoriesByAcr(acrPosizione);
        return tpSgtpoPosizioneStatoMapper.toDto(sgtpoPosizioneStatoes);
    }

}
