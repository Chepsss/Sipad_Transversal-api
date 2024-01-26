package it.almaviva.difesa.sipad.aadba.dosta.repository;

import it.almaviva.difesa.sipad.aadba.dosta.entity.TpDostaStato;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TpDostaStatoRepository extends GenericRepository<TpDostaStato, Long>, GenericSearchRepository<TpDostaStato> {

    TpDostaStato findByDescrSta(String descrizione);

    TpDostaStato findByAcrSta(String acronimo);
}
