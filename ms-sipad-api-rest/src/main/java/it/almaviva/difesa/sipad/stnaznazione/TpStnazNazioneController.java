package it.almaviva.difesa.sipad.stnaznazione;

import it.almaviva.difesa.sipad.aadba.stnaznazione.dto.TpStnazNazioneDTO;
import it.almaviva.difesa.sipad.stnaznazione.service.TpStnazNazioneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("stnazNazione")
@Slf4j
@Validated
public class TpStnazNazioneController {

    @Autowired
    TpStnazNazioneService stnazNazioneService;

    @GetMapping("/{idNation}")
    public ResponseEntity<TpStnazNazioneDTO> stnazNazione(@PathVariable @Validated Long idNation) {
        log.debug("stnazNazione");
        return ResponseEntity.ok().body(stnazNazioneService.getNationById(idNation));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TpStnazNazioneDTO>> stnazNazioneList() {
        log.debug("stnazNazioneList");
        return ResponseEntity.ok().body(stnazNazioneService.listNations());
    }

}
