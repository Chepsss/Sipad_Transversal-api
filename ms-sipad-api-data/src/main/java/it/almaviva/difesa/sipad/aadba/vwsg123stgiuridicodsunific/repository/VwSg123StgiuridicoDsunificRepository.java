package it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.entity.VwSg123StgiuridicoDsunific;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VwSg123StgiuridicoDsunificRepository extends GenericRepository<VwSg123StgiuridicoDsunific, Long>, GenericSearchRepository<VwSg123StgiuridicoDsunific> {

    Optional<VwSg123StgiuridicoDsunific> findBySg123IdDip(Long id);

    Optional<VwSg123StgiuridicoDsunific> findBySg123CodiceFiscaleEqualsIgnoreCase(String fiscalCode);
    @Query( "from VwSg123StgiuridicoDsunific o where o.sg123IdDip in :usersIds" )
    List<VwSg123StgiuridicoDsunific> findByIds(@Param("usersIds") List<Long> usersIds);

}
