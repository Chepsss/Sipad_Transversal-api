package it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.repository;

import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.entity.TpSgtpoPosizioneStato;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TpSgtpoPosizioneStatoRepository extends GenericRepository<TpSgtpoPosizioneStato, String>, GenericSearchRepository<TpSgtpoPosizioneStato> {

    @Query(value = "select cp " +
            "from TpSgtpoPosizioneStato cp " +
            "where cp.sgtpoCodConf in :idList")
    List<TpSgtpoPosizioneStato> getCategoryOfLeaveNonAdmissibility(List<String> idList);

    @Query("select distinct t.sgtpoDescrPosizione from TpSgtpoPosizioneStato t where t.sgtpoSgctp.id in ?1 order by t.sgtpoDescrPosizione")
    List<String> getDistinctByIdInOrderBySgtpoDescrPosizione(Collection<Long> id);

    @Query(value = "select cp " +
            "from TpSgtpoPosizioneStato cp " +
            "where cp.id in :ids")
    List<TpSgtpoPosizioneStato> getCategoryOfLeave(List<String> ids);

    @Query(value = "select cp from TpSgtpoPosizioneStato cp where cp.sgtpoAcrPosizione = :acrPosizione")
    List<TpSgtpoPosizioneStato> getCategoriesByAcr(String acrPosizione);

}
