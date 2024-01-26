package it.almaviva.difesa.sipad.aadba.prtpotprocedimento.repository;

import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.entity.TpPrtpoTprocedimento;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TpPrtpoTprocedimentoRepository extends GenericRepository<TpPrtpoTprocedimento, Long>, GenericSearchRepository<TpPrtpoTprocedimento> {

    @Query(value = "select tp " +
            "from TpPrattAttivazione at " +
            "inner join TpPratpProcAtt ac on ac.pratpPrattIdPk.id = at.id " +
            "inner join TpPrtpoTprocedimento tp on tp.id = ac.pratpPrtpoIdPk.id " +
            "inner join TpPrtpaTprocedura pr on pr.id = tp.prtpoPrtpa.id " +
            "where " +
            "  pr.prtpaAcrProc = :acrProc" +
            "  and at.prattAcrAtt = :type " +
            "order by tp.id")
    List<TpPrtpoTprocedimento> getType(String acrProc, String type);

    @Query(value = "select tp " +
            "from TpPrattAttivazione at " +
            "inner join TpPratpProcAtt ac on ac.pratpPrattIdPk.id = at.id " +
            "inner join TpPrtpoTprocedimento tp on tp.id = ac.pratpPrtpoIdPk.id " +
            "inner join TpPrtpaTprocedura pr on pr.id = tp.prtpoPrtpa.id " +
            "where " +
            "  pr.prtpaAcrProc = :acrProc" +
            "  and at.prattAcrAtt = :tipoAttivazione " +
            "  and tp.prtpoDataIniz <= :currentDate " +
            "  and tp.prtpoDataFine >= :currentDate " +
            "order by tp.id")
    List<TpPrtpoTprocedimento> notExpiredList(String acrProc, String tipoAttivazione, LocalDate currentDate);

    @Query(value = "select tp.id  " +
            "  from TpPrattAttivazione at " +
            "  inner join TpPratpProcAtt  ac on ac.pratpPrattIdPk.id  = at.id " +
            "  inner join TpPrtpoTprocedimento  tp  on tp.id = ac.pratpPrtpoIdPk.id  " +
            "inner join TpPrtpaTprocedura pr on pr.id = tp.prtpoPrtpa.id " +

            "  where " +
            "    pr.prtpaAcrProc = :acrProc" +
            "  and at.prattAcrAtt = :prattAcrAtt " +
            "  and tp.prtpoAcrProc = :prtpoAcrProc " )

     List<Long> getTpPrtpoTprocedimentoListId(String acrProc,
                                                    String prattAcrAtt,
                                                    String prtpoAcrProc );

}