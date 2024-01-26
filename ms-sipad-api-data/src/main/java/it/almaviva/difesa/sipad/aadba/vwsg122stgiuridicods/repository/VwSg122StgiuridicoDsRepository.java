package it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.entity.VwSg122StgiuridicoDs;
import org.springframework.stereotype.Repository;

@Repository
public interface VwSg122StgiuridicoDsRepository extends GenericRepository<VwSg122StgiuridicoDs, Long>, GenericSearchRepository<VwSg122StgiuridicoDs> {

    VwSg122StgiuridicoDs findByIdDip (Long id);

}
