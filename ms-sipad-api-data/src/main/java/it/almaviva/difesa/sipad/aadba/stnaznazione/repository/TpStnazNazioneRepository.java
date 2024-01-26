package it.almaviva.difesa.sipad.aadba.stnaznazione.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.stnaznazione.entity.TpStnazNazione;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpStnazNazioneRepository extends GenericRepository<TpStnazNazione, Long>, GenericSearchRepository<TpStnazNazione> {

    List<TpStnazNazione> findAllByOrderByStnazDescrNazioneAsc();

}