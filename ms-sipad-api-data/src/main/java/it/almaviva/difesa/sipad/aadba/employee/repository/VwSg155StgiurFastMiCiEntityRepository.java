package it.almaviva.difesa.sipad.aadba.employee.repository;

import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiurFastMiCiEntity;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VwSg155StgiurFastMiCiEntityRepository extends GenericRepository<VwSg155StgiurFastMiCiEntity, Long>, GenericSearchRepository<VwSg155StgiurFastMiCiEntity> {

    @Query( "from VwSg155StgiurFastMiCiEntity o where o.sg155IdDip in :usersIds" )
    List<VwSg155StgiurFastMiCiEntity> findByIds(@Param("usersIds") List<Long> usersIds);

    Optional<VwSg155StgiurFastMiCiEntity> findBySg155CodiceFiscaleEqualsIgnoreCase(String sg155CodiceFiscale);

    @Query("from VwSg155StgiurFastMiCiEntity v where v.sg155IdDip = :employeeId")
    Optional<VwSg155StgiurFastMiCiEntity> findBySg155IdDip(Long employeeId);
}