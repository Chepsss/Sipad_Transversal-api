package it.almaviva.difesa.sipad.stregregione;

import it.almaviva.difesa.sipad.aadba.stregregione.dto.TpStregRegioneDTO;
import it.almaviva.difesa.sipad.stregregione.service.TpStregRegioneService;
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
@RequestMapping("stregRegione")
@Slf4j
@Validated
public class TpStregRegioneController {

    @Autowired
    TpStregRegioneService stregRegioneService;

    @GetMapping("/{idRegion}")
    public ResponseEntity<TpStregRegioneDTO> stregRegione(@PathVariable @Validated Long idRegion) {
        log.debug("stregRegione");
        return ResponseEntity.ok().body(stregRegioneService.getRegionById(idRegion));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TpStregRegioneDTO>> stregRegioneList() {
        log.debug("stregRegioneList");
        return ResponseEntity.ok().body(stregRegioneService.listRegions());
    }

}
