package it.almaviva.difesa.sipad.rubricacompleta;


import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.RubricaCompletaDTO;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.request.InputDettaglioRubricaDto;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DestinatarioRubricaCompletaListReturnValue;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DestinatarioRuricaCompletaOut;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DettaglioRubricaCompletaOut;
import it.almaviva.difesa.sipad.rubricacompleta.service.RubricaCompletaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rubrica")
@Slf4j
@Validated
@RequiredArgsConstructor
public class RubricaCompletaController {
    @Autowired
    private final RubricaCompletaService rubricaAooService;


    @GetMapping("/elenco")
    public ResponseEntity<DestinatarioRubricaCompletaListReturnValue> elenco(@RequestParam(name = "filtro", required = false) String filtro, @RequestParam(name = "max" , required = false) Integer max) {
        log.info("chiamato rubrica/elenco");

        return  ResponseEntity.ok().body(rubricaAooService.elenco(filtro, max));
    }

    @GetMapping("/elencopaginate")
    public ResponseEntity<Page<DestinatarioRuricaCompletaOut>> elencoPaginate(@RequestParam(name = "filtro", required = false) String filtro, Pageable pageable) {
        log.info("chiamato rubrica/elencopaginate");

        return  ResponseEntity.ok().body(rubricaAooService.elencoPaginate(filtro, pageable));
    }


    @PostMapping("/")
    public ResponseEntity<DettaglioRubricaCompletaOut> dettaglio(@RequestBody InputDettaglioRubricaDto key) {
        log.info("chiamato rubrica dettaglio");

        return  ResponseEntity.ok().body(rubricaAooService.getByKey(key.getKey()));
    }

    @GetMapping("/listRubrica/{denomEnteCC}")
    public ResponseEntity<List<RubricaCompletaDTO>> getRubricaCompletaByDenomCC(@PathVariable @Validated String denomEnteCC) {
        log.debug("getRubricaCompletaDenomEnteCC");
        return  ResponseEntity.ok().body(rubricaAooService.getRubricaCompletaDenomEnteCC(denomEnteCC));
    }

    @GetMapping("/listRubrica/ente/{idEnte}")
    public ResponseEntity<RubricaCompletaDTO> getEnteByIdEnte(@PathVariable @Validated String idEnte) {
        log.debug("getEnteByIdEnte");
        RubricaCompletaDTO out = rubricaAooService.getEnteByIdEnte(idEnte);
        if(out == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rubricaAooService.getEnteByIdEnte(idEnte));
    }
}
