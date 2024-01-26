package it.almaviva.difesa.sipad.sgimm.immissione.service;

import it.almaviva.difesa.sipad.aadba.immissione.dto.response.ImmissioneDto;
import org.springframework.transaction.annotation.Transactional;

import javax.management.ServiceNotFoundException;

public interface ImmissioneService
{
    @Transactional
    ImmissioneDto findById(Long id) throws ServiceNotFoundException;
}
