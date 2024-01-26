package it.almaviva.difesa.sipad.dostastato.service;

import it.almaviva.difesa.sipad.aadba.dosta.dto.TpDostaStatoDTO;
import it.almaviva.difesa.sipad.aadba.dosta.entity.TpDostaStato;

public interface TpDostaStatoService {

    TpDostaStatoDTO getDostaStatoByDescr(String descr);

    TpDostaStatoDTO getDostaStatoByAcr(String acr);

    TpDostaStatoDTO getDostaStatoById(Long id);

    TpDostaStato getDostaStatoEntityByAcr(String acrSta);

}
