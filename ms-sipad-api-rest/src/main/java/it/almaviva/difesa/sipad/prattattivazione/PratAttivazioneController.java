package it.almaviva.difesa.sipad.prattattivazione;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.almaviva.difesa.sipad.aadba.prattattivazione.dto.response.TpPrattAttivazioneDTO;
import it.almaviva.difesa.sipad.prattattivazione.service.TpPrattAttivazioneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static it.almaviva.difesa.sipad.shared.util.AppConstants.PRAT_ATTIVAZIONE_URL;

@RestController
@RequestMapping(PRAT_ATTIVAZIONE_URL)
@Tag(name = "Prat attivazione  API")
@RequiredArgsConstructor
@Validated
@Slf4j
public class PratAttivazioneController {

    @Autowired
    TpPrattAttivazioneService tpPrattAttivazioneService;

    /**
     * {@code GET  /} : get opening cessation.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of TpPrattAttivazioneDTO.
     */
    @Operation(summary = "Get Procedures list by acr_proc")
    @GetMapping("/list/{acrProc}")
    public ResponseEntity<List<TpPrattAttivazioneDTO>> list(@PathVariable @Validated String acrProc) {
        log.debug("REST request to get opening cessation");
        return ResponseEntity.ok(tpPrattAttivazioneService.list(acrProc, false));
    }

    /**
     * {@code GET  /} : get not expired list.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of TpPrattAttivazioneDTO.
     */
    @Operation(summary = "Get not expired list")
    @GetMapping("/notExpiredList/{acrProc}")
    public ResponseEntity<List<TpPrattAttivazioneDTO>> notExpiredList(@PathVariable @Validated String acrProc) {
        log.debug("REST request to get not expired list");
        return ResponseEntity.ok(tpPrattAttivazioneService.list(acrProc, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TpPrattAttivazioneDTO> getById(@PathVariable @Validated Long id) {
        log.debug("REST request to get TpPrattAttivazione by id");
        return ResponseEntity.ok(tpPrattAttivazioneService.getById(id));
    }

}
