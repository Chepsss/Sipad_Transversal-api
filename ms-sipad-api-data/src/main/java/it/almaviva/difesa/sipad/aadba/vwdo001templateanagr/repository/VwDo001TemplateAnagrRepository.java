package it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.repository;

import it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.entity.VwDo001TemplateAnagr;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VwDo001TemplateAnagrRepository extends GenericRepository<VwDo001TemplateAnagr, Long>, GenericSearchRepository<VwDo001TemplateAnagr> {

    VwDo001TemplateAnagr findByIdDip(Long id);

}
