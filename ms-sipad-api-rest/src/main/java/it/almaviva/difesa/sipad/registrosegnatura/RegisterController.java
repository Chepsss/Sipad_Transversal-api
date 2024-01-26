package it.almaviva.difesa.sipad.registrosegnatura;

import it.almaviva.difesa.sipad.aadba.registrosegnatura.dto.response.TpRegistroSegnaturaDTO;
import it.almaviva.difesa.sipad.registrosegnatura.service.RegistriService;
import it.almaviva.difesa.sipad.shared.util.AppConstants;
import lombok.NoArgsConstructor;
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
@RequestMapping(AppConstants.REGISTER_INDEX_URL)
@NoArgsConstructor
@Slf4j 
public class RegisterController {

    @Autowired
    RegistriService registriService;

    @GetMapping("/registers")
    public ResponseEntity<List<TpRegistroSegnaturaDTO>> registers() {
        log.debug("get the list of protocol registers");
        return ResponseEntity.ok().body(registriService.list());

    }

    @GetMapping("/{tipoRegistro}")
    public ResponseEntity<TpRegistroSegnaturaDTO> getByTipoRegistro(@PathVariable @Validated String tipoRegistro){
        log.debug("get the  protocol register by tipo Registro");
        return ResponseEntity.ok().body(registriService.findByTipoRegistro(tipoRegistro));
    }

}
