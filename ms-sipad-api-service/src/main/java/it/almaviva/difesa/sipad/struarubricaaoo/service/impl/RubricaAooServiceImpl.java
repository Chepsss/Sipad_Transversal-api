package it.almaviva.difesa.sipad.struarubricaaoo.service.impl;

import it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response.DestinatarioListReturnValue;
import it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response.DestinatarioOut;
import it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response.DettaglioDestinatarioOut;
import it.almaviva.difesa.sipad.aadba.struarubricaaoo.entity.TbStruaRubricaAoo;
import it.almaviva.difesa.sipad.aadba.struarubricaaoo.repository.RubricaAooRepository;
import it.almaviva.difesa.sipad.struarubricaaoo.service.RubricaAooService;
import it.almaviva.difesa.sipad.aadba.struarubricaaoo.specifications.RubricaAooSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RubricaAooServiceImpl implements RubricaAooService {

    @Autowired
    RubricaAooRepository rubricaAooRepository;


    @Override
    public DestinatarioListReturnValue elenco(String filtro, Integer max) {
        if (max == null) {
            max = 10;
        }
        Page<TbStruaRubricaAoo> destinatariPage = rubricaAooRepository.findAll(RubricaAooSpecifications.listAutocomplete(filtro), PageRequest.of(0, max));
        List<TbStruaRubricaAoo> destinatari = destinatariPage.getContent();
        List<DestinatarioOut> listBean = new ArrayList<>();
        for (TbStruaRubricaAoo destinatario : destinatari) {
            DestinatarioOut  bean = new DestinatarioOut();

            bean.setIdDestinatario(destinatario.getIdPk());
            bean.setCodAooDestinatario(destinatario.getStaooCodPk());
            bean.setNomeDestinatario(destinatario.getDenomNom());
            bean.setViaDestinatario(destinatario.getIndVia());
            bean.setCittaDestinatario(destinatario.getIndCitta());
            bean.setMailDestinatario(destinatario.getMailNom());
            bean.setPecDestinatario(destinatario.getPecNom());
            listBean.add(bean);
        }
        DestinatarioListReturnValue out = new DestinatarioListReturnValue();
        out.setDestinatariEsterni(listBean);
        return out;
    }

    @Override
    public DettaglioDestinatarioOut getById(Long id) {
        TbStruaRubricaAoo destinatarioExt = rubricaAooRepository.findById(id).orElse(null);
        if(destinatarioExt == null){
            throw new EntityNotFoundException("destinatarioExt non trovato");
        }
        DettaglioDestinatarioOut out = new DettaglioDestinatarioOut();
        out.setCodAooDestinatario(destinatarioExt.getStaooCodPk());
        out.setIdDestinatario(destinatarioExt.getIdPk());
        out.setNomeDestinatario(destinatarioExt.getDenomNom());
        out.setViaDestinatario(destinatarioExt.getIndVia());
        out.setCittaDestinatario(destinatarioExt.getIndCitta());
        out.setCapDestinatario(destinatarioExt.getIndCap());
        out.setProvinciaDestinatario(destinatarioExt.getIndPro());
        out.setStatoDestinatario(destinatarioExt.getIndStato());
        out.setTelefonoDestinatario(destinatarioExt.getTelNom());
        out.setFaxDestinatario(destinatarioExt.getFaxNom());
        out.setMailDestinatario(destinatarioExt.getMailNom());
        out.setPecDestinatario(destinatarioExt.getPecNom());
        return out;
    }
}
