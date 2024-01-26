package it.almaviva.difesa.sipad.sgctpcatpersonale;

import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.StaffCategoriesDTO;
import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.TpSgctpCatpersonaleDTO;
import it.almaviva.difesa.sipad.sgctpcatpersonale.service.TpSgctpCatpersonaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sgctpCatpersonale")
@Slf4j
@Validated
public class TpSgctpCatpersonaleController {

    @Autowired
    TpSgctpCatpersonaleService sgctpCatpersonaleService;

    @GetMapping("/staffCategories")
    public ResponseEntity<StaffCategoriesDTO> staffCategories() {
        log.debug("staffCategories");
        return ResponseEntity.ok().body(sgctpCatpersonaleService.getStaffCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TpSgctpCatpersonaleDTO> getCatMilitareById(@PathVariable @Validated Long id) {
        log.debug("catMilitareById");
        return ResponseEntity.ok().body(sgctpCatpersonaleService.getCatMilitareById(id));
    }

}
