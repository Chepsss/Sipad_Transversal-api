package it.almaviva.difesa.sipad.aadba.registrosegnatura.repository;

import it.almaviva.difesa.sipad.aadba.registrosegnatura.entity.TpRegistroSegnatura;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TpRegistroSegnaturaRepository extends GenericRepository<TpRegistroSegnatura, Long>, GenericSearchRepository<TpRegistroSegnatura> {

    TpRegistroSegnatura findByTipoRegistro(String tipoRegistro);

}
