package it.almaviva.difesa.sipad.hierarchy;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.almaviva.difesa.sipad.hierarchy.service.VwSg003SggraGradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static it.almaviva.difesa.sipad.shared.util.AppConstants.HIERARCHY_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping( HIERARCHY_URL )
@Tag(name = "Hierarchy API")
@RequiredArgsConstructor
@Validated
public class HierarchyController {


    private final VwSg003SggraGradoService vwSg003SggraGradoService;


    @GetMapping(value = "/findHierarchicalValue", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hierarchical value found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Short> findHierarchicalValueByGradeDescription (@RequestParam("gradeDescription") String gradeDescription) {
        return ResponseEntity.ok(vwSg003SggraGradoService.findHierarchicalValueByGradeDescription(gradeDescription));

    }
}
