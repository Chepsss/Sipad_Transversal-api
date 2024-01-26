package it.almaviva.difesa.sipad.aadba.hierarchy.repository;


import it.almaviva.difesa.sipad.aadba.hierarchy.entity.VwSg003SggraGradoEntity;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VwSg003SggraGradoEntityRepository  extends GenericRepository<VwSg003SggraGradoEntity, Long>, GenericSearchRepository<VwSg003SggraGradoEntity> {


    @Query("from VwSg003SggraGradoEntity v where upper(v.sg003DescrGrado) =:sg003DescrGrado")
    List<VwSg003SggraGradoEntity> findBySg003DescrGradoIgnoreCase(String sg003DescrGrado);
}
