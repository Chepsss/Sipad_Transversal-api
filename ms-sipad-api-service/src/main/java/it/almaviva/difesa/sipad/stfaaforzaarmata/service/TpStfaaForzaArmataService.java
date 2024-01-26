package it.almaviva.difesa.sipad.stfaaforzaarmata.service;

import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.dto.TpStfaaForzaArmataDTO;

import java.util.List;

public interface TpStfaaForzaArmataService {

    List<TpStfaaForzaArmataDTO> getForzeArmateCessazione();

    List<TpStfaaForzaArmataDTO> getForzeArmateDecretazione();

    TpStfaaForzaArmataDTO getById(String id);

}
