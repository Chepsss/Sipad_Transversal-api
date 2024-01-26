package it.almaviva.difesa.sipad.aadba.stentente.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.stentente.entity.TbStentEnte;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbStentEnteRepository extends GenericRepository<TbStentEnte, String>, GenericSearchRepository<TbStentEnte> {

    List<TbStentEnte> getTbStentEnteByStentDenomEnteContainingIgnoreCaseOrderById(String denomEnte);

}