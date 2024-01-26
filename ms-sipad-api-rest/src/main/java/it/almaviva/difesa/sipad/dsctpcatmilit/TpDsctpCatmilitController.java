package it.almaviva.difesa.sipad.dsctpcatmilit;

import it.almaviva.difesa.sipad.dsctpCatmilit.service.TpDsctpCatmilitService;
import it.almaviva.difesa.sipad.aadba.dsctpcatmilit.dto.TpDsctpCatmilitDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("dsctpCatmilit")
@Slf4j
@Validated
public class TpDsctpCatmilitController {

    @Autowired
    TpDsctpCatmilitService dsctpCatmilitService;

    @GetMapping("/{id}")
    public ResponseEntity<TpDsctpCatmilitDTO> dsctpCatmilit(@PathVariable @Validated Long id) {
        log.debug("dsctpCatmilit");
        return ResponseEntity.ok().body(dsctpCatmilitService.getDsctpCatmilitById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TpDsctpCatmilitDTO>> dsctpCatmilitList() {
        log.debug("dsctpCatmilitList");
        return ResponseEntity.ok().body(dsctpCatmilitService.listDsctpCatmilit());
    }

    @PostMapping("/listByIds")
    public ResponseEntity<List<TpDsctpCatmilitDTO>> listDsctpCatmilitByIds(@RequestBody Set<Long> ids) {
        log.debug("dsctpCatmilitList By list of id");
        return ResponseEntity.ok().body(dsctpCatmilitService.listDsctpCatmilitByIds(ids));
    }

}
