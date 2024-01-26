package it.almaviva.difesa.sipad.vwsg122stgiuridicods;


import it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.dto.VwSg122StgiuridicoDsDTO;
import it.almaviva.difesa.sipad.vwsg122stgiuridicods.service.VwSg122StgiuridicoDsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("sg122StGiuridico")
@Slf4j
@Validated
public class VwSg122StgiuridicoDsController {


    @Autowired
    VwSg122StgiuridicoDsService sg122StgiuridicoDsService;

    @GetMapping("/{idDip}")
    public ResponseEntity<VwSg122StgiuridicoDsDTO> sg122StGiuridicoDs(@PathVariable @Validated Long idDip) {
        log.debug("sg122StGiuridicoDs");
        return ResponseEntity.ok().body(sg122StgiuridicoDsService.getById(idDip));
    }

}
