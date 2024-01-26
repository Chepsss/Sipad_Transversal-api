package it.almaviva.difesa.sipad.stentente;

import it.almaviva.difesa.sipad.aadba.stentente.dto.TbStentEnteDTO;
import it.almaviva.difesa.sipad.stentente.service.TbStentEnteService;
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
@RequestMapping("stentEnte")
@Slf4j
@Validated
public class TbStentEnteController {

    @Autowired
    TbStentEnteService stentEnteService;

    @GetMapping("/list/{denomEnte}")
    public ResponseEntity<List<TbStentEnteDTO>> stentEnteListByDemon(@PathVariable @Validated String denomEnte) {
        log.debug("stentEnteListByDemon");
        return ResponseEntity.ok().body(stentEnteService.getEnteByDenomEnte(denomEnte));
    }

    @GetMapping("/{idEnte}")
    public ResponseEntity<TbStentEnteDTO> stentEnte(@PathVariable @Validated String idEnte) {
        log.debug("stentEnte");
        return ResponseEntity.ok().body(stentEnteService.getEnteById(idEnte));
    }

}
