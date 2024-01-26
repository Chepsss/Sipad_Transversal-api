package it.almaviva.difesa.sipad.tipodoc;


import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.ListaCategoriaOutput;
import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.TpDocatCdocumentoDTO;
import it.almaviva.difesa.sipad.docattdocumento.service.TipodocumentoService;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response.ListaTipiDocumentiOutput;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response.TpDotipTDocumentoDto;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.entity.TpDotipTDocumento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tipodocumento")
@Slf4j
@Validated
public class TipoDocController {


    @Autowired
    TipodocumentoService tipodocumentoService;


    /**
     * Lista delle catedorie documento (DocatCDocumento) in validità.
     * @return un DTO con list di CategoriaDto (tupla codice/descrizione) utile per elencarle in menu a tendina
     */
    @GetMapping("/category")
    public ResponseEntity<ListaCategoriaOutput> listCategorie() {
        log.debug("Lista categorie");
        return ResponseEntity.ok().body(tipodocumentoService.listCategorie());
    }

    /**
     * Lista delle catedorie documento (DocatCDocumento) in validità, aventi l'id contenuto nella lista
     * @return un DTO con list di CategoriaDto (tupla codice/descrizione) utile per elencarle in menu a tendina
     */
    @GetMapping("/onlySpecificCategories")
    public ResponseEntity<ListaCategoriaOutput> listSpecificheCategorie(@RequestParam("idCategories") List<Long> idCategories) {
        log.debug("Lista specifiche categorie");
        return ResponseEntity.ok().body(tipodocumentoService.listSpecificCategorie(idCategories));
    }

    /**
     * Lista delle catedorie documento (DocatCDocumento)
     * @return una lista di tutti i tipi di TpDocatCdocumentoDTO in validità
     */
    @GetMapping("/docat/list")
    public ResponseEntity<List<TpDocatCdocumentoDTO>> listDocatCDocumentoDTO() {
        log.debug("Lista categorie");
        return ResponseEntity.ok().body(tipodocumentoService.listDocatCDocumentoDTO());
    }

    @GetMapping("/docat/{id}")
    public ResponseEntity<TpDocatCdocumentoDTO> getDocatCDocumentoDTOById(@PathVariable Long id) {
        log.debug("recupero categoria da id");
        return ResponseEntity.ok().body(tipodocumentoService.getDocatCCategoryById(id));
    }





    @GetMapping("/tipidocumenti/{applicationId}/{docatId}")
    public ResponseEntity<ListaTipiDocumentiOutput> listTipoDocumento(@PathVariable @Validated long applicationId, @PathVariable @Validated long docatId) {
        log.debug("Lista documenti");
        return ResponseEntity.ok().body(tipodocumentoService.listTipiDocumenti(applicationId, docatId));
    }

    /**
     * Restituisce il dotipTDocumento dato il codice
     * @param code codice identificativo del tipo documento
     * @return
     */
    @GetMapping("/tipidocumenti/codice/{code}")
    public ResponseEntity<TpDotipTDocumentoDto> getByCode(@PathVariable @Validated String code) {
        log.debug("tipo documento ber codice");
        return ResponseEntity.ok().body(tipodocumentoService.getByCode(code));
    }

    /**
     * Restituisce il dotipTDocumento dato il codice
     * @param code codice identificativo del tipo documento
     * @return
     */
    @GetMapping("/tipo/{code}")
    public ResponseEntity<TpDotipTDocumento> getEntityByCode(@PathVariable @Validated String code) {
        log.debug("tipo documento ber codice");
        return ResponseEntity.ok(tipodocumentoService.getEntityByCode(code));
    }

}
