package it.almaviva.difesa.sipad.stfaaforzaarmata;

import it.almaviva.difesa.sipad.stfaaforzaarmata.service.TpStfaaForzaArmataService;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.dto.TpStfaaForzaArmataDTO;
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
@RequestMapping("stfaaForzaArmata")
@Slf4j
@Validated
public class TpStfaaForzaArmataController {

    @Autowired
    TpStfaaForzaArmataService stfaaForzaArmataService;

    @GetMapping("/list")
    public ResponseEntity<List<TpStfaaForzaArmataDTO>> stfaaForzaArmataList() {
        log.debug("stfaaForzaArmataList");
        return ResponseEntity.ok().body(stfaaForzaArmataService.getForzeArmateCessazione());
    }

    @GetMapping("/listDecretazione")
    public ResponseEntity<List<TpStfaaForzaArmataDTO>> stfaaForzaArmataListDecretazione() {
        log.debug("stfaaForzaArmataList Decretazione");
        return ResponseEntity.ok().body(stfaaForzaArmataService.getForzeArmateDecretazione());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TpStfaaForzaArmataDTO> stentEnte(@PathVariable @Validated String id) {
        log.debug("stfaaForzaArmata");
        return ResponseEntity.ok().body(stfaaForzaArmataService.getById(id));
    }

}
