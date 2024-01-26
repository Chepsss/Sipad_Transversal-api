package it.almaviva.difesa.sipad.stgcecessazione.service.impl;

import it.almaviva.difesa.sipad.shared.dto.response.GenericResponse;
import it.almaviva.difesa.sipad.stgcecessazione.TsStgceCessazioneRequest;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.dto.TsStgceCessazioneDTO;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.entity.TsStgceCessazione;
import it.almaviva.difesa.sipad.stgcecessazione.mapper.TsStgceCessazioneMapper;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.repository.TsStgceCessazioneRepository;
import it.almaviva.difesa.sipad.stgcecessazione.service.TsStgceCessazioneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class TsStgceCessazioneServiceImpl implements TsStgceCessazioneService {

    @Autowired
    TsStgceCessazioneRepository tsStgceCessazioneRepository;

    @Autowired
    TsStgceCessazioneMapper tsStgceCessazioneMapper;

    @Override
    public TsStgceCessazioneDTO insert(TsStgceCessazioneDTO stgceCessazioneRequestDTO) {
        TsStgceCessazione stgceCessazione = tsStgceCessazioneRepository.save(tsStgceCessazioneMapper.toEntity(stgceCessazioneRequestDTO));
        return tsStgceCessazioneMapper.toDto(stgceCessazione);
    }

    @Transactional(readOnly = true)
    @Override
    public TsStgceCessazioneDTO getStgceCessazioneByCodFiscaleAndNumDecreto(TsStgceCessazioneRequest request) {
        TsStgceCessazione tsStgceCessazione = tsStgceCessazioneRepository
                .getTsStgceCessazioneByCFAndNumeroDecreto(request.getCodiceFiscale(), request.getNumeroDecreto())
                .orElseThrow(() -> {
                    String error = "Nessuna Cessazione con CF: %s e NumDecreto: %s trovato";
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(error, request.getCodiceFiscale(), request.getNumeroDecreto()));
                });

        return tsStgceCessazioneMapper.toDto(tsStgceCessazione);
    }

    @Override
    public GenericResponse callStoredProcedureCessazione(TsStgceCessazioneRequest request) {
        log.info(">>>>>>> START Call Stored Procedure Cessazione");
        GenericResponse response = new GenericResponse();
        try {
            tsStgceCessazioneRepository.callStoredProcedureOfCessazione(request.getCodiceFiscale(), request.getNumeroDecreto());
            response.setMessage("Success");
            log.info(">>>>>>> END Call Stored Procedure Cessazione");
        } catch (Exception e) {
            log.error(">>>>> ERROR => {}", e.getMessage());
            log.error("Error call Stored Procedure Cessazione: ", e);
            response.setError(String.format("Errore nel esecuzione della procedura. L'errore è %s", e.getMessage()));
        }
        return response;
    }

}
