package it.almaviva.difesa.sipad.struarubricaaoo;


import it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response.DestinatarioListReturnValue;
import it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response.DettaglioDestinatarioOut;
import it.almaviva.difesa.sipad.struarubricaaoo.service.RubricaAooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("destinatariext")
@Slf4j
@Validated
public class DestinatariController {

    @Autowired
    RubricaAooService rubricaAooService;


    @GetMapping("/elenco")
    public ResponseEntity<DestinatarioListReturnValue> elenco(@RequestParam(name = "filtro", required = false) String filtro, @RequestParam(name = "max" , required = false) Integer max) {
        log.info("chiamato destinatariext/elenco");

        return  ResponseEntity.ok().body(rubricaAooService.elenco(filtro, max));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DettaglioDestinatarioOut> dettaglio(@PathVariable @Validated Long id) {
        log.info("chiamato destinatariext dettaglio");

        return  ResponseEntity.ok().body(rubricaAooService.getById(id));
    }



}
