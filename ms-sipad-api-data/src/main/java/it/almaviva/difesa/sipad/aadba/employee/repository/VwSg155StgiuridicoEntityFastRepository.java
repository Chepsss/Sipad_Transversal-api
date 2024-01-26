package it.almaviva.difesa.sipad.aadba.employee.repository;


import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiuridicoFastEntity;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VwSg155StgiuridicoEntityFastRepository  extends GenericRepository<VwSg155StgiuridicoFastEntity, Long>, GenericSearchRepository<VwSg155StgiuridicoFastEntity> {

    @Query( "from VwSg155StgiuridicoFastEntity o where o.sg155IdDip in :usersIds" )
    List<VwSg155StgiuridicoFastEntity> findByIds(@Param("usersIds") List<Long> usersIds);
}
