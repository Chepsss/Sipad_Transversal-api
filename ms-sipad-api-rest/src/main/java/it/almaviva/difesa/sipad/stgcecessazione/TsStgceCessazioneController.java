package it.almaviva.difesa.sipad.stgcecessazione;

import it.almaviva.difesa.sipad.shared.dto.response.GenericResponse;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.dto.TsStgceCessazioneDTO;
import it.almaviva.difesa.sipad.stgcecessazione.service.TsStgceCessazioneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stgceCessazione")
@Slf4j
@Validated
public class TsStgceCessazioneController {

    @Autowired
    TsStgceCessazioneService stgceCessazioneService;

    @PostMapping("/insert")
    public ResponseEntity<TsStgceCessazioneDTO> insert(@RequestBody TsStgceCessazioneDTO stgceCessazioneRequestDTO) {
        log.debug("insert stg");
        return ResponseEntity.ok().body(stgceCessazioneService.insert(stgceCessazioneRequestDTO));
    }

    @PostMapping("/stgceCessazioneByCFAndNumDecreto")
    public ResponseEntity<TsStgceCessazioneDTO> getStgceCessazioneByCodFiscaleAndNumDecreto(@RequestBody TsStgceCessazioneRequest request) {
        log.debug("get stgce cessazione");
        return ResponseEntity.ok().body(stgceCessazioneService.getStgceCessazioneByCodFiscaleAndNumDecreto(request));
    }

    @PostMapping("/callStoredProcedureCessazione")
    public ResponseEntity<GenericResponse> callStoredProcedureCessazione(@RequestBody TsStgceCessazioneRequest request) {
        log.debug(">>> INIT callStoredProcedureCessazione");
        return ResponseEntity.ok().body(stgceCessazioneService.callStoredProcedureCessazione(request));
    }

}
