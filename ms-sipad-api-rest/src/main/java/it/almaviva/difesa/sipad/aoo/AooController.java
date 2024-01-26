package it.almaviva.difesa.sipad.aoo;


import it.almaviva.difesa.sipad.aadba.stoaoo.dto.response.AooAutocompleteOut;
import it.almaviva.difesa.sipad.aadba.stoaoo.entity.TbStaooAoo;
import it.almaviva.difesa.sipad.stoaoo.service.AooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aoo")
@Slf4j
@Validated
public class AooController {

    @Autowired
    private AooService aooService;

    /**
     * Ricerca degli Aoo per autocompleter sul codice e sulla descrizione
     *
     * @param filtro
     * @param num    opzionale: il numero max di risultati restituiti (default 10)
     * @return
     */
    @GetMapping("/elencoaoo")
    public ResponseEntity<AooAutocompleteOut> elenco(@RequestParam(name = "filtro") String filtro, @RequestParam(name = "num", required = false, defaultValue = "10") Integer num) {
        log.debug("elenco aoo");
        return ResponseEntity.ok().body(aooService.list(filtro, num));
    }

    /**
     * Recupera il dettaglio di una Aoo (Area Organizzativa Omogenea)
     *
     * @param cod codice identivicativa dell'Aoo
     * @return
     */
    @GetMapping("/{cod}")
    public ResponseEntity<TbStaooAoo> dettaglio(@PathVariable @Validated String cod) {
        log.debug("aooUtente dettaglio");
        return ResponseEntity.ok().body(aooService.dettaglio(cod));
    }

}
