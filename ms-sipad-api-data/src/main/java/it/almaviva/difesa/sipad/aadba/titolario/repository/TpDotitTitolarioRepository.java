package it.almaviva.difesa.sipad.aadba.titolario.repository;

import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.titolario.entity.TitolarioPk;
import it.almaviva.difesa.sipad.aadba.titolario.entity.TpDotitTitolario;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TpDotitTitolarioRepository extends GenericRepository<TpDotitTitolario, TitolarioPk>, GenericSearchRepository<TpDotitTitolario> {

}
