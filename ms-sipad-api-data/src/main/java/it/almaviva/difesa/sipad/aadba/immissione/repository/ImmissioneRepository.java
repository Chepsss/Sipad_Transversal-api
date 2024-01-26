package it.almaviva.difesa.sipad.aadba.immissione.repository;

import it.almaviva.difesa.sipad.aadba.immissione.entity.Immissione;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmissioneRepository extends GenericRepository<Immissione, Long>, GenericSearchRepository<Immissione> {

   Immissione findFirstByIdAndSgstaCodOrderByDataImmDesc(Long id, String cod);


}
