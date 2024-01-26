package it.almaviva.difesa.sipad.desk;

import it.almaviva.difesa.sipad.aadba.desk.dto.response.TbAdhocScrivaniaDto;
import it.almaviva.difesa.sipad.desk.service.TbAdhocScrivaniaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("scrivania")
@Slf4j
@Validated
public class ScrivaniaController {

    @Autowired
    TbAdhocScrivaniaService scrivaniaService;

    @GetMapping("/list/{codApp}")
    public ResponseEntity<List<TbAdhocScrivaniaDto>> list(@PathVariable @Validated String codApp) {
        log.debug("scrivaniaService list");
        return ResponseEntity.ok().body(scrivaniaService.list(codApp));
    }

    @GetMapping("/listByCodAppAndCatPers")
    public ResponseEntity<List<TbAdhocScrivaniaDto>> listByCodAppAndCatPers(@RequestParam("codApp") String codApp, @RequestParam("catPers") Long catPers) {
        log.debug("scrivaniaService listByCodAppAndCatPers");
        return ResponseEntity.ok().body(scrivaniaService.listByCodeAppAndCatPers(codApp, catPers));
    }

    @GetMapping("/getTbAdhocScrivania")
    public ResponseEntity<TbAdhocScrivaniaDto> getTbAdhocScrivania(@RequestParam("codPk") String codPk, @RequestParam("codApp") String codApp) {
        log.debug("scrivaniaService getTbAdhocScrivania");
        return ResponseEntity.ok().body(scrivaniaService.getTbAdhocScrivania(codPk, codApp));
    }

}
