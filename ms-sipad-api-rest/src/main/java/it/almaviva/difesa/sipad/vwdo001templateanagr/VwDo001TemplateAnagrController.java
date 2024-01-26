package it.almaviva.difesa.sipad.vwdo001templateanagr;


import it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.dto.VwDo001TemplateAnagrDTO;
import it.almaviva.difesa.sipad.vwdo001templateanagr.service.VwDo001TemplateAnagrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("do001TemplateAnagr")
@Slf4j
@Validated
public class VwDo001TemplateAnagrController {


    @Autowired
    VwDo001TemplateAnagrService do001TemplateAnagrService;

    @GetMapping("/{idDip}")
    public ResponseEntity<VwDo001TemplateAnagrDTO> do001TemplateAnagr(@PathVariable @Validated Long idDip) {
        log.debug("do001TemplateAnagr");
        return ResponseEntity.ok().body(do001TemplateAnagrService.getById(idDip));
    }

}
