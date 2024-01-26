package it.almaviva.difesa.sipad.rubricacompleta.service.impl;

import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.RubricaCompletaDTO;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DestinatarioRubricaCompletaListReturnValue;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DestinatarioRuricaCompletaOut;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DettaglioRubricaCompletaOut;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.entity.RubricaCompleta;
import it.almaviva.difesa.sipad.rubricacompleta.mapper.RubricaCompletaMapper;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.repository.RubricaCompletaRepository;
import it.almaviva.difesa.sipad.rubricacompleta.mapper.RubricaCompletaMapper_Ente;
import it.almaviva.difesa.sipad.rubricacompleta.service.RubricaCompletaService;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.specifications.RubricaCompletaSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RubricaCompletaServiceImpl implements RubricaCompletaService {

    private final RubricaCompletaRepository rubricaAooRepository;
    private final RubricaCompletaMapper rubricaCompletaMapper;

    @Autowired
    RubricaCompletaMapper_Ente rubricaCompletaMapper_ente;

    @Override
    public DestinatarioRubricaCompletaListReturnValue elenco(String filtro, Integer max) {
        if (max == null) {
            max = 10;
        }
        Page<RubricaCompleta> destinatariPage = rubricaAooRepository.findAll(RubricaCompletaSpecifications.listAutocomplete(filtro), PageRequest.of(0, max));
        List<RubricaCompleta> destinatari = destinatariPage.getContent();
        List<DestinatarioRuricaCompletaOut> listBean = new ArrayList<>();
        for (RubricaCompleta destinatario : destinatari) {
            if(destinatario != null) {
                DestinatarioRuricaCompletaOut bean = rubricaCompletaMapper.copyPropertiesDestinatarioRurica(destinatario);
                listBean.add(bean);
            }
        }
        DestinatarioRubricaCompletaListReturnValue out = new DestinatarioRubricaCompletaListReturnValue();
        out.setDestinatariEsterni(listBean);
        return out;
    }

    @Override
    public Page<DestinatarioRuricaCompletaOut> elencoPaginate(String filtro, Pageable pageable) {
        Page<RubricaCompleta> destinatariPage = rubricaAooRepository.findAll(RubricaCompletaSpecifications.listAutocomplete(filtro), pageable);
        return destinatariPage.map(rubricaCompletaMapper::copyPropertiesDestinatarioRurica);
    }


    @Override
    public DettaglioRubricaCompletaOut getByKey(String key) {

        RubricaCompleta destinatarioExt = getDestinatario(key);
        if(destinatarioExt == null){
            throw new EntityNotFoundException("destinatarioExt non trovato");
        }
        DettaglioRubricaCompletaOut out = rubricaCompletaMapper.copyPropertiesDettaglioRubrica(destinatarioExt);

        // campi per caso PF
        if("PF".equalsIgnoreCase(destinatarioExt.getTipoContatto())) {
            out.setTitolo(destinatarioExt.getTitolo());
            out.setNome(destinatarioExt.getNome());
            out.setCognome(destinatarioExt.getCognome());
            out.setCf(destinatarioExt.getCfPiva());
        }

        // campi caso IPA
        if("IPA".equalsIgnoreCase(destinatarioExt.getTipoContatto())) {
            out.setDenominazioneAoo(destinatarioExt.getDenomNom());
            out.setCodiceIpa(destinatarioExt.getCodIpa());
            out.setCodiceUnivocoAoo(destinatarioExt.getCodUnivAoo());
            out.setCodiceAoo(destinatarioExt.getCodAoo());
        }

        //campi caso PG
        if("PG".equalsIgnoreCase(destinatarioExt.getTipoContatto())) {
            out.setPartitaIva(destinatarioExt.getCfPiva());
        }
        //campi caso PAE
        if("PAE".equalsIgnoreCase(destinatarioExt.getTipoContatto())) {
            out.setDenominazioneUfficio(destinatarioExt.getDenomUfficio());
        }

        return out;
    }

    private RubricaCompleta getDestinatario(String key) {
        List<RubricaCompleta> all = rubricaAooRepository.findAll(RubricaCompletaSpecifications.findByKey(key));
        if(!CollectionUtils.isEmpty(all)){
            return all.get(0);
        }
        return null;
    }


    //cr16
    @Override
    public List<RubricaCompletaDTO> getRubricaCompletaDenomEnteCC(String denomEnteCC) {
        List<RubricaCompleta> rubricaCompletaList = rubricaAooRepository.getRubricaByDenomEnte(denomEnteCC);
        return rubricaCompletaMapper_ente.toDto(rubricaCompletaList);
    }

    @Override
    public RubricaCompletaDTO getEnteByIdEnte(String idEnte) {
        Optional<RubricaCompleta> optRubrica = rubricaAooRepository.findById(idEnte);
        return optRubrica.map(
                rubricaCompleta -> rubricaCompletaMapper_ente.toDto(rubricaCompleta)).orElse(null);
    }
    //fine cr16


}
