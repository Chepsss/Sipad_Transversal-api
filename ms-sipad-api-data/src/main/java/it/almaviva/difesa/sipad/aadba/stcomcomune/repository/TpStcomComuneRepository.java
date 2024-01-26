package it.almaviva.difesa.sipad.aadba.stcomcomune.repository;

import it.almaviva.difesa.sipad.aadba.stcomcomune.entity.TpStcomComune;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpStcomComuneRepository extends GenericRepository<TpStcomComune, Long>, GenericSearchRepository<TpStcomComune> {

    List<TpStcomComune> findAllByOrderByStcomDescrComuneAsc();
    List<TpStcomComune> findAllByStcomStpro_IdOrderByStcomDescrComuneAsc(Long provinceId);

}