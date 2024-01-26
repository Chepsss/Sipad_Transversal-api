package it.almaviva.difesa.sipad.aadba.proceeding.repository;

import it.almaviva.difesa.sipad.aadba.proceeding.entity.VwDo007ProcedimentiEntity;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VwDo007ProcedimentiEntityRepository extends GenericRepository<VwDo007ProcedimentiEntity, Long>, GenericSearchRepository<VwDo007ProcedimentiEntity> {

}
