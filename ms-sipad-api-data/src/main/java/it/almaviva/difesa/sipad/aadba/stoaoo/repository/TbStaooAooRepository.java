package it.almaviva.difesa.sipad.aadba.stoaoo.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.stoaoo.entity.TbStaooAoo;
import org.springframework.stereotype.Repository;

@Repository
public interface TbStaooAooRepository extends GenericRepository<TbStaooAoo, Long>, GenericSearchRepository<TbStaooAoo> {

    TbStaooAoo findByCod(String cod);
}
