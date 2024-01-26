package it.almaviva.difesa.sipad.employee;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiurFastMiCiCriteria;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.TbAndipDipendenteDTO;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiurFastMiCiDTO;
import it.almaviva.difesa.sipad.employee.service.TbAndipDipendenteService;
import it.almaviva.difesa.sipad.employee.service.VwSg155StgiurFastMiCiService;
import it.almaviva.difesa.sipad.shared.dto.response.OutputGenericListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static it.almaviva.difesa.sipad.shared.util.AppConstants.USER_FAST_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping( USER_FAST_URL )
@Tag(name = "User Fast API")
@RequiredArgsConstructor
@Validated
public class EmployeeFastMiCiController {

    private final VwSg155StgiurFastMiCiService vwSg155StgiurFastMiCiService;
    private final TbAndipDipendenteService tbAndipDipendenteService;
    
    @GetMapping("/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })//http://localhost:8080/ms-sipad-api/user/?size=2&page=1&sort=sg155Matricola
    public ResponseEntity< OutputGenericListResponse > find(@PageableDefault( sort = { "sg155Cognome", "sg155Nome" } ) Pageable pageable ) {
        return ResponseEntity.ok( vwSg155StgiurFastMiCiService.findUsers( pageable ) );
    }

    
    @GetMapping(value = "/find", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<VwSg155StgiurFastMiCiDTO> findByCode (@RequestParam("fiscalCode") String fiscalCode) {
        VwSg155StgiurFastMiCiDTO dto = vwSg155StgiurFastMiCiService.findUserByFiscaleCode(fiscalCode);
        return ResponseEntity.ok( dto );
    }


    @GetMapping(value = "/findByFiscalCode", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<TbAndipDipendenteDTO> findByFiscalCode (@RequestParam("fiscalCode") String fiscalCode) {
        TbAndipDipendenteDTO dto = tbAndipDipendenteService.findUserByFiscaleCode(fiscalCode);
        return ResponseEntity.ok( dto );
    }


    @PostMapping(value = "/filter", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Page<VwSg155StgiurFastMiCiDTO>> findAllUsersByCriteria (@RequestBody @Valid VwSg155StgiurFastMiCiCriteria vwSg155StgiurFastMiCiCriteria, Pageable pageable) {
        return ResponseEntity.ok(vwSg155StgiurFastMiCiService.findAllUsersByCriteria(vwSg155StgiurFastMiCiCriteria, pageable));
    }

    @GetMapping(value = "/findById", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<VwSg155StgiurFastMiCiDTO> findById (@RequestParam("employeeId") Long employeeId) {
        VwSg155StgiurFastMiCiDTO dto = vwSg155StgiurFastMiCiService.findUserById(employeeId);
        return ResponseEntity.ok( dto );
    }

    @GetMapping(value = "/findUsersById", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<VwSg155StgiurFastMiCiDTO>> findUsersById (@RequestParam("usersIds")List<Long> usersIds) {
        return ResponseEntity.ok(vwSg155StgiurFastMiCiService.findUsersById(usersIds));
    }
}
