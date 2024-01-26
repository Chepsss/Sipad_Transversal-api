package it.almaviva.difesa.sipad.stproprovincia;

import it.almaviva.difesa.sipad.aadba.stproprovincia.dto.TpStproProvinciaDTO;
import it.almaviva.difesa.sipad.stproprovincia.service.TpStproProvinciaService;
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
@RequestMapping("stproProvincia")
@Slf4j
@Validated
public class TpStproProvinciaController {

    @Autowired
    TpStproProvinciaService stproProvinciaService;

    @GetMapping("/{idProvince}")
    public ResponseEntity<TpStproProvinciaDTO> stproProvincia(@PathVariable @Validated Long idProvince) {
        log.debug("stproProvincia");
        return ResponseEntity.ok().body(stproProvinciaService.getProvinceById(idProvince));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TpStproProvinciaDTO>> stproProvinciaList() {
        log.debug("stproProvinciaList");
        return ResponseEntity.ok().body(stproProvinciaService.listProvinces());
    }

}
