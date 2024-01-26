package it.almaviva.difesa.sipad.aadba.docatcdocumento.repository;

import it.almaviva.difesa.sipad.aadba.docatcdocumento.entity.TpDocatCDocumento;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TpDocatCDocumentoRepository extends GenericRepository<TpDocatCDocumento, Long>, GenericSearchRepository<TpDocatCDocumento> {



    List<TpDocatCDocumento> findAllByDataFineAfterAndDataInizBeforeOrderByAcrCat(Date now, Date now2);

    @Query("from TpDocatCDocumento t where t.dataFine >:dataFine and t.dataIniz < :dataIniz " +
            "and t.id in :idCategories order by t.acrCat")
    List<TpDocatCDocumento> findByDataAfterAndDataInizBeforeAndInListIdsOrderByAcrCat(Date dataFine, Date dataIniz, List<Long> idCategories);



}
