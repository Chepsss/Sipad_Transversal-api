package it.almaviva.difesa.sipad.aadba.stregregione.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.stregregione.entity.TpStregRegione;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpStregRegioneRepository extends GenericRepository<TpStregRegione, Long>, GenericSearchRepository<TpStregRegione> {

    List<TpStregRegione> findAllByOrderByStregDescrRegioneAsc();

}