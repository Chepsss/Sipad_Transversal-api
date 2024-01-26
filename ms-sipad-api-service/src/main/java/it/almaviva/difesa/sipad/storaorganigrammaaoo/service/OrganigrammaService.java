package it.almaviva.difesa.sipad.storaorganigrammaaoo.service;

import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response.OrganigrammaLevelList;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response.TbStoraOrganigrammaAooDto;

import java.util.List;

public interface OrganigrammaService {


    OrganigrammaLevelList level();

    OrganigrammaLevelList level(String liv1);

    OrganigrammaLevelList level(String liv1, String liv2);

    OrganigrammaLevelList level(String liv1, String liv2, String liv3);

    OrganigrammaLevelList level(String liv1, String liv2, String liv3, String liv4);

    List<TbStoraOrganigrammaAooDto> aooOfLevel(String liv2, String liv3, String liv4, String liv5);

    TbStoraOrganigrammaAooDto getByLogin(String loginPk);

    TbStoraOrganigrammaAooDto getByIdUo(Long idUo);
}
