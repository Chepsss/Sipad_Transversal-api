package it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.repository;

import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.entity.TpSgctpCatpersonale;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpSgctpCatpersonaleRepository extends GenericRepository<TpSgctpCatpersonale, Long>, GenericSearchRepository<TpSgctpCatpersonale> {

    @Query("select c.sgctpDescrCatpers from TpSgctpCatpersonale c " +
            "where c.sgctpAcrCatpers in ('U.','SU.','Gr.')")
    List<String> getStaffCategories();

}