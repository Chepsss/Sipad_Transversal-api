package it.almaviva.difesa.sipad.aadba.prattattivazione.repository;

import it.almaviva.difesa.sipad.aadba.prattattivazione.entity.TpPrattAttivazione;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface TpPrattAttivazioneRepository extends GenericRepository<TpPrattAttivazione, Long>, GenericSearchRepository<TpPrattAttivazione> {




}