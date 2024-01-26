package it.almaviva.difesa.sipad.titolario;


import it.almaviva.difesa.sipad.aadba.titolario.dto.request.InputTitolarioDTO;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaClassi;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaFascicoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaSottoclassi;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaSottofascicoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaTitoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.TitolarioDto;
import it.almaviva.difesa.sipad.titolario.service.TitolarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("titolario")
@Slf4j
@Validated
public class TitolarioController {


    @Autowired
    TitolarioService titolarioService;

    @GetMapping("/")
    public ResponseEntity<ListaTitoli> titolario() {
        log.debug("TitolarioCompleto");
        return ResponseEntity.ok().body(titolarioService.titolarioCompleto());
    }

    @GetMapping("/{codiceTitolo}")
    public ResponseEntity<ListaClassi> titolario(@PathVariable @Validated String codiceTitolo) {
        log.debug("Titolario per Titolo");
        return ResponseEntity.ok().body(titolarioService.titolario(codiceTitolo));
    }


    @GetMapping("/{codiceTitolo}/{codiceClasse}")
    public ResponseEntity<ListaSottoclassi> titolario(@PathVariable @Validated String codiceTitolo, @PathVariable @Validated String codiceClasse) {
        log.debug("Titolario per classe");
        return ResponseEntity.ok().body(titolarioService.titolario(codiceTitolo, codiceClasse));
    }


    @GetMapping("/{codiceTitolo}/{codiceClasse}/{codiceSottoclasse}")
    public ResponseEntity<ListaFascicoli> titolario(@PathVariable @Validated String codiceTitolo,
                                                    @PathVariable @Validated String codiceClasse,
                                                    @PathVariable @Validated String codiceSottoclasse,
                                                    @RequestParam(name = "filtro", required = false) String filtro,
                                                    @RequestParam(name = "max", required = false, defaultValue = "10") Integer max) {
        log.debug("Titolario per sottoclasse");
        return ResponseEntity.ok().body(titolarioService.titolario(codiceTitolo, codiceClasse, codiceSottoclasse, filtro, max));
    }


    @GetMapping("/{codiceTitolo}/{codiceClasse}/{codiceSottoclasse}/{codiceFascicolo}")
    public ResponseEntity<ListaSottofascicoli> titolario(@PathVariable @Validated String codiceTitolo,
                                                         @PathVariable @Validated String codiceClasse,
                                                         @PathVariable @Validated String codiceSottoclasse,
                                                         @PathVariable @Validated String codiceFascicolo,
                                                         @RequestParam(name = "filtro") String filtro,
                                                         @RequestParam(name = "max", required = false, defaultValue = "10") Integer max) {
        log.debug("Titolario per fascicolo");
        return ResponseEntity.ok().body(titolarioService.titolario(codiceTitolo, codiceClasse, codiceSottoclasse, codiceFascicolo, filtro, max));
    }

    @PostMapping("/fascicoli")
    public ResponseEntity<ListaFascicoli> fascicoli(@Valid @RequestBody InputTitolarioDTO input) {
        log.debug("Titolario per fascicolo");
        return ResponseEntity.ok().body(titolarioService.titolario(input.getCodiceTitolo(), input.getCodiceClasse(),
                input.getCodiceSottoclasse(), input.getFiltro(), input.getMax()));
    }


    @PostMapping("/sottofascicoli")
    public ResponseEntity<ListaSottofascicoli> sottofascicoli(@Valid @RequestBody InputTitolarioDTO input) {
        log.debug("Titolario per fascicolo");
        return ResponseEntity.ok().body(titolarioService.titolario(input.getCodiceTitolo(), input.getCodiceClasse(),
                input.getCodiceSottoclasse(), input.getCodiceFascicolo(), input.getFiltro(), input.getMax()));
    }

    @PostMapping("/dettaglio")
    public ResponseEntity<TitolarioDto> dettaglio(@Valid @RequestBody InputTitolarioDTO input) {
        log.debug("Dettaglio Titolario");
        return ResponseEntity.ok().body(titolarioService.dettaglio(input.getCodiceTitolo(), input.getCodiceClasse(),
                input.getCodiceSottoclasse(), input.getCodiceFascicolo(), input.getCodiceSottofascicolo()));
    }

}
