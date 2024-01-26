package it.almaviva.difesa.sipad.aadba.stproprovincia.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.stproprovincia.entity.TpStproProvincia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpStproProvinciaRepository extends GenericRepository<TpStproProvincia, Long>, GenericSearchRepository<TpStproProvincia> {

    List<TpStproProvincia> findAllByOrderByStproCDescrProvinciaAsc();
}