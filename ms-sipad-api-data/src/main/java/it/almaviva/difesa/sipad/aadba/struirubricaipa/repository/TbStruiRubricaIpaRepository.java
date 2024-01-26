package it.almaviva.difesa.sipad.aadba.struirubricaipa.repository;

import it.almaviva.difesa.sipad.aadba.struirubricaipa.entity.TbStruiRubricaIpa;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbStruiRubricaIpaRepository extends GenericRepository<TbStruiRubricaIpa, Long>, GenericSearchRepository<TbStruiRubricaIpa> {

}
