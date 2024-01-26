package it.almaviva.difesa.sipad.dsctpCatmilit.service;

import it.almaviva.difesa.sipad.aadba.dsctpcatmilit.dto.TpDsctpCatmilitDTO;

import java.util.List;
import java.util.Set;

public interface TpDsctpCatmilitService {

    List<TpDsctpCatmilitDTO> listDsctpCatmilit();

    TpDsctpCatmilitDTO getDsctpCatmilitById(Long id);

    List<TpDsctpCatmilitDTO> listDsctpCatmilitByIds(Set<Long> ids);

}
