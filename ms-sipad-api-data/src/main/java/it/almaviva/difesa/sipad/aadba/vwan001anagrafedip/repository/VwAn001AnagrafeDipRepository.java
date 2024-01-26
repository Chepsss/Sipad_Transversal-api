package it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.entity.VwAn001AnagrafeDip;
import org.springframework.stereotype.Repository;

@Repository
public interface VwAn001AnagrafeDipRepository extends GenericRepository<VwAn001AnagrafeDip, Long>, GenericSearchRepository<VwAn001AnagrafeDip> {

    VwAn001AnagrafeDip findByIdDip(Long id);

}
