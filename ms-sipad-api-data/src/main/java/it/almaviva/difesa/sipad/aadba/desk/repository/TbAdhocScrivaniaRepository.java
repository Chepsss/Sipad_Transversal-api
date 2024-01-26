package it.almaviva.difesa.sipad.aadba.desk.repository;

import it.almaviva.difesa.sipad.aadba.desk.entity.TbAdhocScrivania;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbAdhocScrivaniaRepository extends GenericRepository<TbAdhocScrivania, String>, GenericSearchRepository<TbAdhocScrivania> {


    @Query("select d from TbAdhocScrivania d where trim(d.adhocCodApp) = trim(:codApp)")
    List<TbAdhocScrivania> findAllByAdhocCodApp(String codApp);

    @Query("select d from TbAdhocScrivania d " +
            "where trim(d.adhocCodApp) = trim(:codApp) and d.adhocSgctpCatpers = :catPers " +
            "order by d.adhocCodPkDes")
    List<TbAdhocScrivania> getByAdhocCodAppAndAdhocSgctpCatpers(String codApp, Long catPers);

    @Query("select d " +
            "from TbAdhocScrivania d " +
            "where d.adhocCodPk = :codPk " +
            "and trim(d.adhocCodApp) = trim(:codApp) ")
    TbAdhocScrivania getTbAdhocScrivaniaByCodPkAndCodApp(String codPk, String codApp);

}
