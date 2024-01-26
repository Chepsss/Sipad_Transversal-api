package it.almaviva.difesa.sipad.ageLimits.service.impl;

import it.almaviva.difesa.sipad.aadba.ageLimits.dto.request.LimiteEtaRequestDTO;
import it.almaviva.difesa.sipad.aadba.ageLimits.dto.request.TpCelceLimitiCszPerEtaRequestDTO;
import it.almaviva.difesa.sipad.aadba.ageLimits.repository.TpCelceLimitiCszPerEtaRepository;
import it.almaviva.difesa.sipad.ageLimits.service.TpCelceLimitiCszPerEtaEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@Slf4j
public class TpCelceLimitiCszPerEtaEntityServiceImpl implements TpCelceLimitiCszPerEtaEntityService {

    private static final Long AGE_LIMIT_DEFAULT = 60L;

    @Autowired
    private TpCelceLimitiCszPerEtaRepository tpCelceLimitiCszPerEtaRepository;

    @Override
    public Long calculateAgeLimits(TpCelceLimitiCszPerEtaRequestDTO dto) {
        var entitySaved = tpCelceLimitiCszPerEtaRepository.getLimiteEtaByCelceSggraSeqPkAndCelceSgruoSeqPk(dto.getCelceSggraSeqPk(), dto.getCelceSgruoSeqPk());
        return entitySaved.map(tpCelceLimitiCszPerEtaEntity -> tpCelceLimitiCszPerEtaEntity.getCelceLimitaEta().longValue()).orElse(AGE_LIMIT_DEFAULT);
    }

    @Override
    public Integer getLimite(LimiteEtaRequestDTO dto) {
        return tpCelceLimitiCszPerEtaRepository.getLimite(dto.getRankId(), dto.getRoleId(), dto.getArmedForceId());
    }
}
