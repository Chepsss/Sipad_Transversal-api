package it.almaviva.difesa.sipad.sgtpoposizionestato;

import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.EmployeeCategoryDTO;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.RequestDTO;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.TpSgtpoPosizioneStatoDTO;
import it.almaviva.difesa.sipad.sgtpoposizionestato.service.TpSgtpoPosizioneStatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sgtpoPosizioneStato")
@Slf4j
@Validated
public class TpSgtpoPosizioneStatoController {

    @Autowired
    TpSgtpoPosizioneStatoService sgtpoPosizioneStatoService;

    @GetMapping("/all")
    public ResponseEntity<List<TpSgtpoPosizioneStatoDTO>> findAll() {
        log.debug("Categories");
        return ResponseEntity.ok().body(sgtpoPosizioneStatoService.findAll());
    }

    @GetMapping("/categories")
    public ResponseEntity<EmployeeCategoryDTO> getCategories() {
        log.debug("Categories");
        return ResponseEntity.ok().body(sgtpoPosizioneStatoService.getCategories());
    }

    @PostMapping("/categoriesOfLeave")
    public ResponseEntity<List<TpSgtpoPosizioneStatoDTO>> getCategoriesOfLeave(@RequestBody @Valid RequestDTO requestDTO) {
        log.debug("categories of leave");
        return ResponseEntity.ok().body(sgtpoPosizioneStatoService.getCategoriesOfLeave(requestDTO));
    }

    @PostMapping("/categoriesOfLeaveNonAdmissibility")
    public ResponseEntity<List<TpSgtpoPosizioneStatoDTO>> getCategoriesOfLeaveNonAdmissibility(@RequestBody @Valid RequestDTO requestDTO) {
        log.debug("categories of leave non-admissibility");
        return ResponseEntity.ok().body(sgtpoPosizioneStatoService.getCategoriesOfLeaveNonAdmissibility(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TpSgtpoPosizioneStatoDTO> getCategoryById(@PathVariable @Validated String id) {
        log.debug("categoryById");
        return ResponseEntity.ok().body(sgtpoPosizioneStatoService.getCategoryById(id));
    }

    @GetMapping("/categoriesByAcr")
    public ResponseEntity<List<TpSgtpoPosizioneStatoDTO>> getCategoriesByAcr(@RequestParam("acrPosizione") String acrPosizione) {
        log.debug("getCategoryByAcr");
        return ResponseEntity.ok().body(sgtpoPosizioneStatoService.getCategoriesByAcr(acrPosizione));
    }

}
