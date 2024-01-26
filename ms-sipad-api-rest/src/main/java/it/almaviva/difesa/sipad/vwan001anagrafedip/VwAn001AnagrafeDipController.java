package it.almaviva.difesa.sipad.vwan001anagrafedip;

import it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.dto.VwAn001AnagrafeDipDTO;
import it.almaviva.difesa.sipad.vwan001anagrafedip.service.VwAn001AnagrafeDipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("an001AnagrafeDip")
@Slf4j
@Validated
public class VwAn001AnagrafeDipController {

    @Autowired
    VwAn001AnagrafeDipService an001AnagrafeDipService;

    @GetMapping("/{idDip}")
    public ResponseEntity<VwAn001AnagrafeDipDTO> an001AnagrafeDip(@PathVariable @Validated Long idDip) {
        log.debug("an001AnagrafeDip");
        return ResponseEntity.ok().body(an001AnagrafeDipService.getById(idDip));
    }

}
