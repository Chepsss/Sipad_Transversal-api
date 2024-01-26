package it.almaviva.difesa.sipad.dostastato.service.impl;

import it.almaviva.difesa.sipad.aadba.dosta.dto.TpDostaStatoDTO;
import it.almaviva.difesa.sipad.aadba.dosta.entity.TpDostaStato;
import it.almaviva.difesa.sipad.aadba.dosta.repository.TpDostaStatoRepository;
import it.almaviva.difesa.sipad.dostastato.mapper.TpDostaStatoMapper;
import it.almaviva.difesa.sipad.dostastato.service.TpDostaStatoService;
import it.almaviva.difesa.sipad.shared.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TpDostaStatoServiceImpl implements TpDostaStatoService {

    @Autowired
    TpDostaStatoRepository tpDostaStatoRepository;

    @Autowired
    TpDostaStatoMapper tpDostaStatoMapper;

    @Override
    public TpDostaStatoDTO getDostaStatoByDescr(String descr) {
        String replaced = descr.replace("_", " ");
        TpDostaStato dostaStato = tpDostaStatoRepository.findByDescrSta(replaced);
        updateArchiviatoToProtocollato(dostaStato);
        return tpDostaStatoMapper.toDto(dostaStato);
    }

    @Override
    public TpDostaStatoDTO getDostaStatoByAcr(String acr) {
        TpDostaStato dostaStato = tpDostaStatoRepository.findByAcrSta(acr);
        updateArchiviatoToProtocollato(dostaStato);
        return tpDostaStatoMapper.toDto(dostaStato);
    }

    @Override
    public TpDostaStatoDTO getDostaStatoById(Long id) {
        Optional<TpDostaStato> dostaStato = tpDostaStatoRepository.findById(id);
        dostaStato.ifPresent(this::updateArchiviatoToProtocollato);
        return tpDostaStatoMapper.toDto(dostaStato.orElse(null));
    }

    @Override
    public TpDostaStato getDostaStatoEntityByAcr(String acrSta) {
        TpDostaStato tpDostaStato = tpDostaStatoRepository.findByAcrSta(acrSta);
        updateArchiviatoToProtocollato(tpDostaStato);
        return tpDostaStato;
    }

    private void updateArchiviatoToProtocollato(TpDostaStato tpDostaStato) {
        if (tpDostaStato.getDescrSta().equalsIgnoreCase(AppConstants.STATO_DOC_DESCR_ARCHIVIATO)) {
            tpDostaStato.setDescrSta(AppConstants.STATO_DOC_DESCR_PROTOCOLLATO);
        }
    }

}
