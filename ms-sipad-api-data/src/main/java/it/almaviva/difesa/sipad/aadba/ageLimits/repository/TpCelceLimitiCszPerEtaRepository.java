package it.almaviva.difesa.sipad.aadba.ageLimits.repository;

import it.almaviva.difesa.sipad.aadba.ageLimits.entity.TpCelceLimitiCszPerEtaEntity;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TpCelceLimitiCszPerEtaRepository extends GenericRepository<TpCelceLimitiCszPerEtaEntity, Long>, GenericSearchRepository<TpCelceLimitiCszPerEtaEntity> {


    @Query("from TpCelceLimitiCszPerEtaEntity t where t.celceSggraSeqPk = :celceSggraSeqPk and t.celceSgruoSeqPk = :celceSgruoSeqPk")
    Optional<TpCelceLimitiCszPerEtaEntity> getLimiteEtaByCelceSggraSeqPkAndCelceSgruoSeqPk(String celceSggraSeqPk, String celceSgruoSeqPk);

    @Query(value = "select ce.celceLimitaEta " +
            "from TpCelceLimitiCszPerEtaEntity ce " +
            "where " +
            "ce.celceSggraSeqPk = :rankId " +
            "and ce.celceSgruoSeqPk = :roleId " +
            "and ce.celceSgffaSeqPk = :armedForceId")
    Integer getLimite(String rankId, String roleId, String armedForceId);

}
