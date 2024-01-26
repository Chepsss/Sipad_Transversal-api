package it.almaviva.difesa.sipad.aastg.stgcecessazione.repository;

import it.almaviva.difesa.sipad.aastg.stgcecessazione.entity.TsStgceCessazione;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.entity.composite.CFNumDecretoCompositeKey;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TsStgceCessazioneRepository extends GenericRepository<TsStgceCessazione, CFNumDecretoCompositeKey>, GenericSearchRepository<TsStgceCessazione> {

    @Query("SELECT c from TsStgceCessazione c WHERE c.id.stgceCodiceFiscale = :codiceFiscale and c.id.stgceNumeroDecreto = :numeroDecreto")
    Optional<TsStgceCessazione> getTsStgceCessazioneByCFAndNumeroDecreto(String codiceFiscale, String numeroDecreto);

    @Procedure(procedureName = "pkg_sg_verticali_sipad2.p_main_cessazione")
    void callStoredProcedureOfCessazione(@Param("in_codice_fiscale") String fiscalCode, @Param("in_numero_decreto") String numeroDecreto);

}
