package it.almaviva.difesa.sipad.aadba.rubricacompleta.repository;

import it.almaviva.difesa.sipad.aadba.rubricacompleta.entity.RubricaCompleta;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubricaCompletaRepository extends GenericRepository<RubricaCompleta, String>, GenericSearchRepository<RubricaCompleta> {


    @Query("SELECT r FROM RubricaCompleta r WHERE upper(r.denomNom) like upper(concat('%',:denomEnte, '%')) ORDER BY r.denomNom asc")
    List<RubricaCompleta> getRubricaByDenomEnte(@Param("denomEnte")String denomEnteCC);
}
