package it.almaviva.difesa.sipad.dostastato;


import it.almaviva.difesa.sipad.aadba.dosta.dto.TpDostaStatoDTO;
import it.almaviva.difesa.sipad.aadba.dosta.entity.TpDostaStato;
import it.almaviva.difesa.sipad.dostastato.service.TpDostaStatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dostastato")
@Slf4j
@Validated
public class TpDostaStatoController {


    @Autowired
    TpDostaStatoService dostaStatoService;


    @GetMapping("/descr/{descrSta}")
    public ResponseEntity<TpDostaStatoDTO> dostaStatoByDescr(@PathVariable String descrSta) {
        log.debug("Dosta stato by description");
        return ResponseEntity.ok().body(dostaStatoService.getDostaStatoByDescr(descrSta));
    }

    @GetMapping("/acr/{acrSta}")
    public ResponseEntity<TpDostaStatoDTO> dostaStatoByAcr(@PathVariable String acrSta) {
        log.debug("Dosta stato by acronym");
        return ResponseEntity.ok().body(dostaStatoService.getDostaStatoByAcr(acrSta));
    }

    @GetMapping("/acrEntity/{acrSta}")
    public ResponseEntity<TpDostaStato> dostaStatoEntityByAcr(@PathVariable String acrSta) {
        log.debug("Dosta stato entity by acronym");
        return ResponseEntity.ok().body(dostaStatoService.getDostaStatoEntityByAcr(acrSta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TpDostaStatoDTO> dostaStatoById(@PathVariable Long id) {
        log.debug("Dosta stato by id");
        return ResponseEntity.ok().body(dostaStatoService.getDostaStatoById(id));
    }

}
