package it.almaviva.difesa.sipad.employee;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiuridicoCriteria;
import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiuridicoFastCriteria;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.TbAndipDipendenteDTO;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiuridicoDTO;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiuridicoFastDTO;
import it.almaviva.difesa.sipad.employee.service.TbAndipDipendenteService;
import it.almaviva.difesa.sipad.employee.service.VwSg155StgiuridicoService;
import it.almaviva.difesa.sipad.shared.dto.response.OutputGenericListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static it.almaviva.difesa.sipad.shared.util.AppConstants.USER_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping( USER_URL )
@Tag(name = "User API")
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final VwSg155StgiuridicoService vwSg155StgiuridicoService;
    private final TbAndipDipendenteService tbAndipDipendenteService;
    
    @GetMapping("/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })//http://localhost:8080/ms-sipad-api/user/?size=2&page=1&sort=sg155Matricola
    public ResponseEntity< OutputGenericListResponse > find(@PageableDefault( sort = { "sg155Cognome", "sg155Nome" } ) Pageable pageable ) {
        return ResponseEntity.ok( vwSg155StgiuridicoService.findUsers( pageable ) );
    }

    
    @GetMapping(value = "/find", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<VwSg155StgiuridicoDTO> findByCode (@RequestParam("fiscalCode") String fiscalCode) {
        VwSg155StgiuridicoDTO dto = vwSg155StgiuridicoService.findUserByFiscaleCode(fiscalCode);
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

    @GetMapping(value = "/userById", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<TbAndipDipendenteDTO> findUserById (@RequestParam("employerId") Long employerId) {
        TbAndipDipendenteDTO dto = tbAndipDipendenteService.findUserByEmployerId(employerId);
        return ResponseEntity.ok( dto );
    }


    @PostMapping(value = "/filter", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Page<VwSg155StgiuridicoDTO>> findAllUsersByCriteria (@RequestBody @Valid VwSg155StgiuridicoCriteria vwSg155StgiuridicoCriteria, Pageable pageable) {
        return ResponseEntity.ok(vwSg155StgiuridicoService.findAllUsersByCriteria(vwSg155StgiuridicoCriteria, pageable));
    }


    @PostMapping(value = "/getUsersPartialInfo", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Page<VwSg155StgiuridicoFastDTO>> getUsersPartialInfo (@RequestBody @Valid VwSg155StgiuridicoFastCriteria vwSg155StgiuridicoFastCriteria, Pageable pageable) {
        return ResponseEntity.ok(vwSg155StgiuridicoService.getUsersPartialInfo(vwSg155StgiuridicoFastCriteria, pageable));
    }


    @GetMapping(value = "/findById", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<VwSg155StgiuridicoDTO> findById (@RequestParam("employeeId") Long employeeId) {
        VwSg155StgiuridicoDTO dto = vwSg155StgiuridicoService.findUserById(employeeId);
        return ResponseEntity.ok( dto );
    }

    @GetMapping(value = "/findUsersFastByIds", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<VwSg155StgiuridicoFastDTO>> findUsersFastByIds (@RequestParam("usersIds")List<Long> usersIds) {
        return ResponseEntity.ok(vwSg155StgiuridicoService.findUsersFastById(usersIds));
    }

    @GetMapping(value = "/findUsersById", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<VwSg155StgiuridicoDTO>> findUsersById (@RequestParam("usersIds")List<Long> usersIds) {
        return ResponseEntity.ok(vwSg155StgiuridicoService.findUsersById(usersIds));
    }

    @GetMapping(value = "/findHierarchicalValue", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Short> findHierarchicalValueByGradeDescription (@RequestParam("gradeDescription") String gradeDescription) {
        return ResponseEntity.ok(vwSg155StgiuridicoService.findHierarchicalValueByGradeDescription(gradeDescription));

    }

    @GetMapping(value = "/checkNotCompatibleWithCessation", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Boolean> checkNotCompatibleWithCessation(@RequestParam("employeeId") Long employeeId) {
        return ResponseEntity.ok(vwSg155StgiuridicoService.checkNotCompatibleWithCessation(employeeId));

    }

    @PostMapping(value = "/usersId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<Long>> getUsersIdByCriteria (@RequestBody @Valid VwSg155StgiuridicoCriteria vwSg155StgiuridicoCriteria) {
        return ResponseEntity.ok(vwSg155StgiuridicoService.getUsersIdByCriteria(vwSg155StgiuridicoCriteria));
    }

}
