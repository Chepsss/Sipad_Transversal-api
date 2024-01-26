package it.almaviva.difesa.sipad.sgimmimmissione;

import it.almaviva.difesa.sipad.aadba.immissione.dto.response.ImmissioneDto;
import it.almaviva.difesa.sipad.sgimm.immissione.service.ImmissioneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ServiceNotFoundException;

@RestController
@RequestMapping("immissione")
@Slf4j
@Validated
public class ImmissioneController {
    @Autowired
    ImmissioneService immissioneService;

    @GetMapping("/")
    public ResponseEntity<ImmissioneDto> get(@RequestParam("id") Long id) throws ServiceNotFoundException {
        log.debug("get immissione");
        return ResponseEntity.ok().body(immissioneService.findById(id));
    }
}
