package it.almaviva.difesa.sipad.proceeding;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.almaviva.difesa.sipad.aadba.proceeding.criteria.VwDo007ProcedimentiCriteria;
import it.almaviva.difesa.sipad.aadba.proceeding.dto.response.VwDo007ProcedimentiDTO;
import it.almaviva.difesa.sipad.proceeding.service.VwDo007ProcedimentiEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static it.almaviva.difesa.sipad.shared.util.AppConstants.PROCEEDING_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping( PROCEEDING_URL )
@Tag(name = "Proceeding API")
@RequiredArgsConstructor
@Validated
public class ProceedingController {

    @Autowired
    private VwDo007ProcedimentiEntityService vwDo007ProcedimentiEntityService;


    @PostMapping(value = "/filter", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Parameters found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Page<VwDo007ProcedimentiDTO>> findAllProceedingsByCriteria (@RequestBody @Valid VwDo007ProcedimentiCriteria vwSg155StgiuridicoCriteria, Pageable pageable) {
        return ResponseEntity.ok(vwDo007ProcedimentiEntityService.findAllProceedingsByCriteria(vwSg155StgiuridicoCriteria, pageable));
    }
}
