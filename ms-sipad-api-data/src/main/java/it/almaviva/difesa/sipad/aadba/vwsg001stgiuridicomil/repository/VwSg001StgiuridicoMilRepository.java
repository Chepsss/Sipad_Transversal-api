package it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.entity.VwSg001StgiuridicoMil;
import org.springframework.stereotype.Repository;

@Repository
public interface VwSg001StgiuridicoMilRepository extends GenericRepository<VwSg001StgiuridicoMil, Long>, GenericSearchRepository<VwSg001StgiuridicoMil> {

    VwSg001StgiuridicoMil findByIdDip(Long id);

}
