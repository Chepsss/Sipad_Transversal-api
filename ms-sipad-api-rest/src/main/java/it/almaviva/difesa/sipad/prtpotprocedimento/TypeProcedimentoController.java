package it.almaviva.difesa.sipad.prtpotprocedimento;

import io.swagger.v3.oas.annotations.Operation;
import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.dto.response.TpPrtpoTprocedimentoDTO;
import it.almaviva.difesa.sipad.prtpotprocedimento.mapper.service.TpPrtpoTprocedimentoService;
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
@RequestMapping("tipoProcedimento")
@Slf4j
@Validated
public class TypeProcedimentoController {


    @Autowired
    TpPrtpoTprocedimentoService tpPrtpoTprocedimentoService;

    /**
     * {@code GET  /} : get Type.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of TpPrtpoTprocedimentoDTO.
     */
    @Operation(summary = "Get Type of access")
    @GetMapping("/{type}/{acrProc}")
    public ResponseEntity<List<TpPrtpoTprocedimentoDTO>> getType(@PathVariable @Validated String type, @PathVariable @Validated String acrProc) {
        log.debug("REST request to get type ");
        return ResponseEntity.ok(tpPrtpoTprocedimentoService.getType(type, acrProc));
    }

    /**
     * {@code GET  /} : get not expired list.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of TpPrtpoTprocedimentoDTO.
     */
    @Operation(summary = "Get not expired list")
    @GetMapping("/notExpiredList/{type}/{acrProc}")
    public ResponseEntity<List<TpPrtpoTprocedimentoDTO>> notExpiredList(@PathVariable @Validated String type, @PathVariable @Validated String acrProc) {
        log.debug("REST request to get not expired list");
        return ResponseEntity.ok(tpPrtpoTprocedimentoService.notExpiredList(type, acrProc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TpPrtpoTprocedimentoDTO> getType(@PathVariable @Validated Long id) {
        log.debug("REST request to get type ");
        return ResponseEntity.ok(tpPrtpoTprocedimentoService.getTypeById(id));
    }


    @GetMapping("listIds/{type}/{acrProc}/{prtpoAcrProc}")
    public ResponseEntity<List<Long>> getTypeIds(@PathVariable @Validated String type,
                                                 @PathVariable @Validated String acrProc,
                                                 @PathVariable @Validated String prtpoAcrProc) {
        log.debug("REST request to get type cessation");
        return ResponseEntity.ok(tpPrtpoTprocedimentoService.getTypesId(type, acrProc, prtpoAcrProc));
    }

}
