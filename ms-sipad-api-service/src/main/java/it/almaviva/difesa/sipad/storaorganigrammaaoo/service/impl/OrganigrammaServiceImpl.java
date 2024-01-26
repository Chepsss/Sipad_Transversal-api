package it.almaviva.difesa.sipad.storaorganigrammaaoo.service.impl;

import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response.OrganigrammaLevel;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response.OrganigrammaLevelList;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response.TbStoraOrganigrammaAooDto;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.entity.TbStoraOrganigrammaAoo;
import it.almaviva.difesa.sipad.storaorganigrammaaoo.mapper.TbStoraOrganigrammaAooMapper;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.repository.OrganigrammaAooRepository;
import it.almaviva.difesa.sipad.storaorganigrammaaoo.service.OrganigrammaService;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.specifications.StoraOrganigrammaSpecifivcations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganigrammaServiceImpl implements OrganigrammaService {



    @Autowired
    OrganigrammaAooRepository organigrammaAooRepository;

    @Autowired
    TbStoraOrganigrammaAooMapper storaOrganigrammaAooMapper;

    @Override
    public OrganigrammaLevelList level(){
        List<String> denomLiv = organigrammaAooRepository.denomLiv1();
        List<OrganigrammaLevel> result = new ArrayList<>();
        for(String each : denomLiv) {
            if(each != null && !"".equals(each)) {
                List<TbStoraOrganigrammaAoo> all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.dettaglio(each, null, null, null, null));
                if (!all.isEmpty()) {
                    OrganigrammaLevel level = new OrganigrammaLevel();
                    level.setIdUo(all.get(0).getIdUo());
                    level.setDenomLiv(each);

                    result.add(level);
                }
            }
        }

        OrganigrammaLevelList out = new OrganigrammaLevelList();
        out.setList(denomLiv);
        out.setLivelli(result);
        return out;
    }

    @Override
    public OrganigrammaLevelList level(String liv1){
        List<String> denomLiv = organigrammaAooRepository.denomLiv2(liv1);
        List<OrganigrammaLevel> result = new ArrayList<>();
        for(String each : denomLiv) {
            if(each != null && !"".equals(each)) {
                List<TbStoraOrganigrammaAoo> all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.dettaglio(liv1, each, null, null, null));
                if (!all.isEmpty()) {
                    OrganigrammaLevel level = new OrganigrammaLevel();
                    level.setIdUo(all.get(0).getIdUo());
                    level.setDenomLiv(each);

                    result.add(level);
                }
            }
        }

        OrganigrammaLevelList out = new OrganigrammaLevelList();
        out.setList(denomLiv);
        out.setLivelli(result);
        return out;
    }

    @Override
    public OrganigrammaLevelList level(String liv1, String liv2){
        List<String> denomLiv = organigrammaAooRepository.denomLiv3(liv1, liv2);
        List<OrganigrammaLevel> result = new ArrayList<>();
        for(String each : denomLiv) {
            if(each != null && !"".equals(each)) {
                List<TbStoraOrganigrammaAoo> all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.dettaglio(liv1, liv2, each, null, null));
                if (!all.isEmpty()) {
                    OrganigrammaLevel level = new OrganigrammaLevel();
                    level.setIdUo(all.get(0).getIdUo());
                    level.setDenomLiv(each);

                    result.add(level);
                }
            }
        }

        OrganigrammaLevelList out = new OrganigrammaLevelList();
        out.setList(denomLiv);
        out.setLivelli(result);
        return out;
    }

    @Override
    public OrganigrammaLevelList level(String liv1, String liv2, String liv3){
        List<String> denomLiv = organigrammaAooRepository.denomLiv4(liv1, liv2, liv3);
        List<OrganigrammaLevel> result = new ArrayList<>();
        for(String each : denomLiv) {
            if (each != null && !"".equals(each)) {
                List<TbStoraOrganigrammaAoo> all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.dettaglio(liv1, liv2, liv3, each, null));
                if (!all.isEmpty()) {
                    OrganigrammaLevel level = new OrganigrammaLevel();
                    level.setIdUo(all.get(0).getIdUo());
                    level.setDenomLiv(each);

                    result.add(level);
                }
            }
        }

        OrganigrammaLevelList out = new OrganigrammaLevelList();
        out.setList(denomLiv);
        out.setLivelli(result);
        return out;
    }

    @Override
    public OrganigrammaLevelList level(String liv1, String liv2, String liv3, String liv4){
        List<String> denomLiv = organigrammaAooRepository.denomLiv5(liv1, liv2, liv3, liv4);
        List<OrganigrammaLevel> result = new ArrayList<>();
        for(String each : denomLiv) {
            if ( each != null && !"".equals(each)) {
                List<TbStoraOrganigrammaAoo> all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.dettaglio(liv1, liv2, liv3, liv4, each));
                if (!all.isEmpty()) {
                    OrganigrammaLevel level = new OrganigrammaLevel();
                    level.setIdUo(all.get(0).getIdUo());
                    level.setDenomLiv(each);

                    result.add(level);
                }
            }
        }
        OrganigrammaLevelList out = new OrganigrammaLevelList();
        out.setList(denomLiv);
        out.setLivelli(result);
        return out;
    }

    @Override
    public List<TbStoraOrganigrammaAooDto> aooOfLevel(String liv2, String liv3, String liv4, String liv5){
        List<TbStoraOrganigrammaAoo> all;
        if(liv2 == null){
             all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.listAooLevel1());

        }else if( liv3 == null){
            all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.listAooLevel2(liv2));
        }else if( liv4 == null){
            all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.listAooLevel3(liv2, liv3));
        }else if(liv5 == null){
            all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.listAooLevel4(liv2, liv3, liv4));
        }else{
            all = organigrammaAooRepository.findAll(StoraOrganigrammaSpecifivcations.listAooLevel5(liv2, liv3, liv4, liv5));
        }
        return storaOrganigrammaAooMapper.toDto(all);

    }

    @Override
    public TbStoraOrganigrammaAooDto getByLogin(String loginPk){
        return storaOrganigrammaAooMapper.toDto(organigrammaAooRepository.findByCodLoginPk(loginPk));
    }

    @Override
    public TbStoraOrganigrammaAooDto getByIdUo(Long idUo) {
        return storaOrganigrammaAooMapper.toDto(organigrammaAooRepository.findFirstByIdUo(idUo));
    }
}
