package it.almaviva.difesa.sipad.aadba.struarubricaaoo.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.struarubricaaoo.entity.TbStruaRubricaAoo;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricaAooRepository extends GenericRepository<TbStruaRubricaAoo, Long>, GenericSearchRepository<TbStruaRubricaAoo> {


}
