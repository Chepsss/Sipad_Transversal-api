package it.almaviva.difesa.sipad.aadba.dotiptdocumento.repository;

import it.almaviva.difesa.sipad.aadba.dotiptdocumento.entity.TpDotipTDocumento;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TpDotipTDocumentoRepository extends GenericRepository<TpDotipTDocumento, Long>, GenericSearchRepository<TpDotipTDocumento> {


    TpDotipTDocumento findByCod(String codiceTipo);



}
