package it.almaviva.difesa.sipad.aadba.stfaaforzarmata.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.entity.TpStfaaForzaArmata;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpStfaaForzaArmataRepository extends GenericRepository<TpStfaaForzaArmata, String>, GenericSearchRepository<TpStfaaForzaArmata> {

    @Query(value = "select fa " +
            "from TpStfaaForzaArmata fa " +
            "where fa.id in ('EI','MM','AM','CC')")
    List<TpStfaaForzaArmata> getForzeArmateCessazione();

    @Query(value = "select fa " +
            "from TpStfaaForzaArmata fa " +
            "where fa.id in ('EI','MM','AM','CI')")
    List<TpStfaaForzaArmata> getForzeArmateDecretazione();

}