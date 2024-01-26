package it.almaviva.difesa.sipad.ageLimits;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.almaviva.difesa.sipad.aadba.ageLimits.dto.request.LimiteEtaRequestDTO;
import it.almaviva.difesa.sipad.aadba.ageLimits.dto.request.TpCelceLimitiCszPerEtaRequestDTO;
import it.almaviva.difesa.sipad.ageLimits.service.TpCelceLimitiCszPerEtaEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static it.almaviva.difesa.sipad.shared.util.AppConstants.AGE_LIMITS_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(AGE_LIMITS_URL)
@Tag(name = "Age Limits API")
@RequiredArgsConstructor
@Validated
public class AgeLimitsController {


    private final TpCelceLimitiCszPerEtaEntityService tpCelceLimitiCszPerEtaEntityService;


    @PostMapping(value = "/calculate", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Calculation done"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Long> checkAgeLimits(@RequestBody @Valid TpCelceLimitiCszPerEtaRequestDTO dto) {
        return ResponseEntity.ok(tpCelceLimitiCszPerEtaEntityService.calculateAgeLimits(dto));
    }

    @PostMapping("/limit")
    public ResponseEntity<Integer> getLimiteEta(@RequestBody @Valid LimiteEtaRequestDTO limiteEtaRequestDTO) {
        return ResponseEntity.ok().body(tpCelceLimitiCszPerEtaEntityService.getLimite(limiteEtaRequestDTO));
    }
}
