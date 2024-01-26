package it.almaviva.difesa.sipad.dsctpCatmilit.service.impl;

import it.almaviva.difesa.sipad.dsctpCatmilit.mapper.TpDsctpCatmilitMapper;
import it.almaviva.difesa.sipad.dsctpCatmilit.service.TpDsctpCatmilitService;
import it.almaviva.difesa.sipad.aadba.dsctpcatmilit.dto.TpDsctpCatmilitDTO;
import it.almaviva.difesa.sipad.aadba.dsctpcatmilit.entity.TpDsctpCatmilit;
import it.almaviva.difesa.sipad.aadba.dsctpcatmilit.repository.TpDsctpCatmilitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TpDsctpCatmilitServiceImpl implements TpDsctpCatmilitService {

    @Autowired
    TpDsctpCatmilitRepository tpDsctpCatmilitRepository;

    @Autowired
    TpDsctpCatmilitMapper tpDsctpCatmilitMapper;

    @Override
    public List<TpDsctpCatmilitDTO> listDsctpCatmilit() {
        List<TpDsctpCatmilit> dsctpCatmilits = tpDsctpCatmilitRepository.findAllByOrderByDsctpAcrCatmilitAsc();
        return tpDsctpCatmilitMapper.toDto(dsctpCatmilits);
    }

    @Override
    public TpDsctpCatmilitDTO getDsctpCatmilitById(Long id) {
        Optional<TpDsctpCatmilit> dsctpCatmilit = tpDsctpCatmilitRepository.findById(id);
        return tpDsctpCatmilitMapper.toDto(dsctpCatmilit.orElse(null));
    }

    @Override
    public List<TpDsctpCatmilitDTO> listDsctpCatmilitByIds(Set<Long> ids) {
        List<TpDsctpCatmilit> dsctpCatmilits = tpDsctpCatmilitRepository.findTpDsctpCatmilitByIdIs(ids);
        return tpDsctpCatmilitMapper.toDto(dsctpCatmilits);
    }

}
