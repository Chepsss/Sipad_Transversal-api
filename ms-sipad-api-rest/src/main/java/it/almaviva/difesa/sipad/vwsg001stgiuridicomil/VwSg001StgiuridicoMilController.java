package it.almaviva.difesa.sipad.vwsg001stgiuridicomil;

import it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.dto.VwSg001StgiuridicoMilDTO;
import it.almaviva.difesa.sipad.vwsg001stgiuridicomil.service.VwSg001StgiuridicoMilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sg001StGiuridico")
@Slf4j
@Validated
public class VwSg001StgiuridicoMilController {

    @Autowired
    VwSg001StgiuridicoMilService sg001StgiuridicoMilService;

    @GetMapping("/{idDip}")
    public ResponseEntity<VwSg001StgiuridicoMilDTO> sg001StGiuridicoMil(@PathVariable @Validated Long idDip) {
        log.debug("sg001StGiuridicoMil");
        return ResponseEntity.ok().body(sg001StgiuridicoMilService.getById(idDip));
    }

}
