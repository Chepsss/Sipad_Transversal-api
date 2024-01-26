package it.almaviva.difesa.sipad.employee.service;

import it.almaviva.difesa.sipad.aadba.employee.dto.response.TbAndipDipendenteDTO;

import javax.persistence.EntityNotFoundException;

public interface TbAndipDipendenteService {


    TbAndipDipendenteDTO findUserByFiscaleCode (String fiscaleCode ) throws EntityNotFoundException;

    TbAndipDipendenteDTO findUserByEmployerId(Long employerId);
}
