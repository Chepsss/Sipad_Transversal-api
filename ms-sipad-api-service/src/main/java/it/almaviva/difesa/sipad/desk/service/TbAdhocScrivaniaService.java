package it.almaviva.difesa.sipad.desk.service;

import it.almaviva.difesa.sipad.aadba.desk.dto.response.TbAdhocScrivaniaDto;

import java.util.List;

public interface TbAdhocScrivaniaService {

    List<TbAdhocScrivaniaDto> list(String codApp);

    List<TbAdhocScrivaniaDto> listByCodeAppAndCatPers(String codApp, Long catPers);
    TbAdhocScrivaniaDto getTbAdhocScrivania(String codPk, String codApp) ;

}
