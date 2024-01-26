package it.almaviva.difesa.sipad.vwsg123stgiuridicodsunific;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.almaviva.difesa.sipad.shared.util.AppConstants;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.criteria.VwSg123StgiuridicoDsCriteria;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.dto.VwSg123StgiuridicoDsunificDTO;
import it.almaviva.difesa.sipad.vwsg123stgiuridicodsunific.service.VwSg123StgiuridicoDsunificService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(AppConstants.STG_DS_UNIFICATO_URL)
@Slf4j
@Validated
public class VwSg123StgiuridicoDsunificController {

    @Autowired
    VwSg123StgiuridicoDsunificService sg123StgiuridicoDsunificService;

    @PostMapping(value = "/filter", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Page<VwSg123StgiuridicoDsunificDTO>> findAllUsersByCriteria (@RequestBody @Valid VwSg123StgiuridicoDsCriteria vwSg123StgiuridicoDsCriteria, Pageable pageable) {
        return ResponseEntity.ok(sg123StgiuridicoDsunificService.findAllUsersByCriteria(vwSg123StgiuridicoDsCriteria, pageable));
    }

    @GetMapping("/findById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<VwSg123StgiuridicoDsunificDTO> findById (@RequestParam("employeeId") Long employeeId) {
        return ResponseEntity.ok().body(sg123StgiuridicoDsunificService.getById(employeeId));
    }

    @GetMapping(value = "/find", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<VwSg123StgiuridicoDsunificDTO> findByCode (@RequestParam("fiscalCode") String fiscalCode) {
        VwSg123StgiuridicoDsunificDTO dto = sg123StgiuridicoDsunificService.findUserByFiscaleCode(fiscalCode);
        return ResponseEntity.ok( dto );
    }

    @GetMapping(value = "/findUsersById", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<VwSg123StgiuridicoDsunificDTO>> findUsersById (@RequestParam("usersIds")List<Long> usersIds) {
        return ResponseEntity.ok(sg123StgiuridicoDsunificService.findUsersById(usersIds));
    }

    @PostMapping(value = "/usersId", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<Long>> getUsersIdByCriteria (@RequestBody @Valid VwSg123StgiuridicoDsCriteria vwSg123StgiuridicoDsCriteria) {
        return ResponseEntity.ok(sg123StgiuridicoDsunificService.getUsersIdByCriteria(vwSg123StgiuridicoDsCriteria));
    }

}
