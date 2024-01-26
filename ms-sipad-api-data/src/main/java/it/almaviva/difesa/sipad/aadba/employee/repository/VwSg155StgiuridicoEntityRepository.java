package it.almaviva.difesa.sipad.aadba.employee.repository;

import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiuridicoEntity;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VwSg155StgiuridicoEntityRepository extends GenericRepository<VwSg155StgiuridicoEntity, Long>, GenericSearchRepository<VwSg155StgiuridicoEntity> {


    Optional<VwSg155StgiuridicoEntity> findBySg155CodiceFiscaleEqualsIgnoreCase(String sg155CodiceFiscale);

    @Query("from VwSg155StgiuridicoEntity v where v.sg155IdDip = :employeeId")
    Optional<VwSg155StgiuridicoEntity> findBySg155IdDip(Long employeeId);

    @Query( "from VwSg155StgiuridicoEntity o where o.sg155IdDip in :usersIds" )
    List<VwSg155StgiuridicoEntity> findByIds(@Param("usersIds") List<Long> usersIds);

    @Query("from VwSg155StgiuridicoEntity v where upper(v.sg155DescrGrado) =:sg155DescrGrado")
    List<VwSg155StgiuridicoEntity> findBySg155DescrGradoIgnoreCase(String sg155DescrGrado);

    @Query("select v from VwSg155StgiuridicoEntity v where v.sg155IdCatmil=1 " +
            "and v.sg155CodFfaa =:sg155CodFfaa and v.sg155ValGerarchia =:sg155ValGerarchia " +
            "and upper(v.sg155DescrPosser) = upper(:sg155DescrPosser)" +
            "and upper(v.sg155DescrRuolo) = upper(:sg155DescrRuolo) order by v.sg155DataNascita desc")
    Page<VwSg155StgiuridicoEntity> findBySg155CodFfaaAndSg155ValGerarchiaAndSg155DescrPosserAndSg155DescrRuolo (String sg155CodFfaa, Short sg155ValGerarchia, String sg155DescrPosser, String sg155DescrRuolo, Pageable pageable);


    @Query("select v from VwSg155StgiuridicoEntity v where v.sg155IdCatmil=1 " +
            "and v.sg155CodFfaa =:sg155CodFfaa and v.sg155ValGerarchia =:sg155ValGerarchia " +
            "and upper(v.sg155DescrPosser) = upper(:sg155DescrPosser)" +
            "and upper(v.sg155DescrRuolo) = upper(:sg155DescrRuolo) and v.sg155IdDip not in :usersIds order by v.sg155DataNascita desc")
    Page<VwSg155StgiuridicoEntity> findBySg155CodFfaaAndSg155ValGerarchiaAndSg155DescrPosserAndSg155DescrRuoloAndNotIn (String sg155CodFfaa, Short sg155ValGerarchia, String sg155DescrPosser, String sg155DescrRuolo, List<Long> usersIds, Pageable pageable);


    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END " +
            "FROM VwSg155StgiuridicoEntity v " +
            "WHERE v.sg155IdDip = :employeeId " +
            "AND v.sg155UidPosSer NOT IN ('AF2','AF3','AF52')")
    boolean isNotCompatibleWithCessation(Long employeeId);

}