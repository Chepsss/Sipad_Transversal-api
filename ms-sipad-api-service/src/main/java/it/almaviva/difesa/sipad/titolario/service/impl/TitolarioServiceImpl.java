package it.almaviva.difesa.sipad.titolario.service.impl;

import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaClassi;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaFascicoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaSottoclassi;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaSottofascicoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaTitoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.TitolarioDto;
import it.almaviva.difesa.sipad.aadba.titolario.entity.TpDotitTitolario;
import it.almaviva.difesa.sipad.titolario.mapper.TitolarioMapper;
import it.almaviva.difesa.sipad.titolario.service.TitolarioService;
import it.almaviva.difesa.sipad.aadba.titolario.specifications.TpDotitSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TitolarioServiceImpl implements TitolarioService {

    private final TitolarioMapper titolarioMapper;
    private final TpDotitSpecifications dotitSpecifications;


    @Override
    @Transactional(readOnly = true)
    public ListaTitoli titolarioCompleto() {
        ListaTitoli out = new ListaTitoli();
        out.setTitoli(dotitSpecifications.getTitoli());
        return out;
    }

    @Override
    @Transactional(readOnly = true)
    public ListaClassi titolario(String codiceTitolo) {
        ListaClassi out = new ListaClassi();
        out.setClassi(dotitSpecifications.titolarioByTitolo(codiceTitolo));
        return out;
    }

    @Override
    @Transactional(readOnly = true)
    public ListaSottoclassi titolario(String codiceTitolo, String codiceClasse) {
        ListaSottoclassi out = new ListaSottoclassi();
        out.setSottoclassi(dotitSpecifications.titolarioByTitoloAndClasse(codiceTitolo, codiceClasse));
        return out;
    }

    @Override
    @Transactional(readOnly = true)
    public ListaFascicoli titolario(String codiceTitolo, String codiceClasse, String codiceSottoclasse, String filtro, Integer max) {
        ListaFascicoli out = new ListaFascicoli();
        if (max == null) {
            max = 10;
        }
        out.setFascicoli(dotitSpecifications.titolarioByTitoloAndClasseAndSottoclasse(codiceTitolo, codiceClasse, codiceSottoclasse, filtro, max));
        return out;
    }

    @Override
    @Transactional(readOnly = true)
    public ListaSottofascicoli titolario(String codiceTitolo, String codiceClasse, String codiceSottoclasse, String codiceFascicolo, String filtro, Integer max) {
        ListaSottofascicoli out = new ListaSottofascicoli();
        if (max == null || max == 0) {
            max = 10;
        }
        out.setSottofascicoli(dotitSpecifications.titolarioByTitoloAndClasseAndSottoclasseAndFascicolo(codiceTitolo, codiceClasse, codiceSottoclasse, codiceFascicolo, filtro, max));
        return out;
    }

    @Override
    @Transactional(readOnly = true)
    public TitolarioDto dettaglio(String codiceTitolo, String codiceClasse, String codiceSottoclasse, String codiceFascicolo, String codiceSottofascicolo) {
        List<TpDotitTitolario> titolarioList = getListaTitolario(codiceTitolo, codiceClasse, codiceSottoclasse, codiceFascicolo, codiceSottofascicolo);
        TitolarioDto dto = new TitolarioDto();
        if (!titolarioList.isEmpty()) {
            TpDotitTitolario titolario = titolarioList.get(0);
            dto = titolarioMapper.toDto(titolario);
            dto.setCodTit(codiceTitolo);
            dto.setCodCla(codiceClasse);
            dto.setCodSotcla(codiceSottoclasse);
            dto.setCodFas(codiceFascicolo);
            dto.setCodSotfas(codiceSottofascicolo);
        }
        return dto;
    }

    private List<TpDotitTitolario> getListaTitolario(String codiceTitolo, String codiceClasse, String codiceSottoclasse, String codiceFascicolo, String codiceSottofascicolo) {
        List<TpDotitTitolario> titolarioList = dotitSpecifications.findByCodes(codiceTitolo, codiceClasse, codiceSottoclasse, codiceFascicolo, codiceSottofascicolo);
        return titolarioList.parallelStream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}
