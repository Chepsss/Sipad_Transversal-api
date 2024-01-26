package it.almaviva.difesa.sipad.storaorganigrammaaoo;

import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response.OrganigrammaLevelList;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response.TbStoraOrganigrammaAooDto;
import it.almaviva.difesa.sipad.storaorganigrammaaoo.service.OrganigrammaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizationChart")
@Slf4j
public class OrganizationChartController {

    @Autowired
    OrganigrammaService organigrammaService;

    @GetMapping("/")
    public ResponseEntity<OrganigrammaLevelList> organizationChartLevels(@RequestParam(required = false) String level1,
                                                                         @RequestParam(required = false) String level2,
                                                                         @RequestParam(required = false) String level3,
                                                                         @RequestParam(required = false) String level4) {
        log.debug("get the organization chart");
        if (level4 != null) {
            return ResponseEntity.ok().body(organigrammaService.level(level1, level2, level3, level4));
        }
        if (level3 != null) {
            return ResponseEntity.ok().body(organigrammaService.level(level1, level2, level3));
        }
        if (level2 != null) {
            return ResponseEntity.ok().body(organigrammaService.level(level1, level2));
        }
        if (level1 != null) {
            return ResponseEntity.ok().body(organigrammaService.level(level1));
        }
         return ResponseEntity.ok().body(organigrammaService.level());
    }


    @GetMapping("/assegnatari")
    public ResponseEntity<List<TbStoraOrganigrammaAooDto>> organizationChart(@RequestParam(required = false) String level2,
                                                                             @RequestParam(required = false) String level3,
                                                                             @RequestParam(required = false) String level4,
                                                                             @RequestParam(required = false) String level5) {
        return ResponseEntity.ok().body(organigrammaService.aooOfLevel(level2, level3, level4, level5));
    }


    @GetMapping("/assegnatario/{loginPk}")
    public ResponseEntity<TbStoraOrganigrammaAooDto> getByLogin(@PathVariable @Validated String loginPk){
        return ResponseEntity.ok().body(organigrammaService.getByLogin(loginPk));
    }

    @GetMapping("/{idUo}")
    public ResponseEntity<TbStoraOrganigrammaAooDto> getByidUo(@PathVariable @Validated Long idUo){
        return ResponseEntity.ok().body(organigrammaService.getByIdUo(idUo));
    }

}
