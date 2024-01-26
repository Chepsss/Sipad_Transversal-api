package it.almaviva.difesa.sipad.stcomcomune;

import it.almaviva.difesa.sipad.aadba.stcomcomune.dto.TpStcomComuneDTO;
import it.almaviva.difesa.sipad.stcomcomune.service.TpStcomComuneService;
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
@RequestMapping("stcomComune")
@Slf4j
@Validated
public class TpStcomComuneController {

    @Autowired
    TpStcomComuneService stcomComuneService;

    @GetMapping("/{idCity}")
    public ResponseEntity<TpStcomComuneDTO> stcomComune(@PathVariable @Validated Long idCity) {
        log.debug("stcomComune");
        return ResponseEntity.ok().body(stcomComuneService.getCityById(idCity));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TpStcomComuneDTO>> stcomComuneList() {
        log.debug("stcomComuneList");
        return ResponseEntity.ok().body(stcomComuneService.listCities());
    }

    @GetMapping("/list/{idProvince}")
    public ResponseEntity<List<TpStcomComuneDTO>> stcomComuneListByProvince(@PathVariable @Validated Long idProvince) {
        log.debug("stcomComuneListByProvince");
        return ResponseEntity.ok().body(stcomComuneService.listCitiesByProvince(idProvince));
    }

}
