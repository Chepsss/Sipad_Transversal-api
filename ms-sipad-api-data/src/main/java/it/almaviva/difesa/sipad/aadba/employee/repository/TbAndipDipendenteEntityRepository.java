package it.almaviva.difesa.sipad.aadba.employee.repository;

import it.almaviva.difesa.sipad.aadba.employee.entity.TbAndipDipendenteEntity;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TbAndipDipendenteEntityRepository  extends GenericRepository<TbAndipDipendenteEntity, Long>, GenericSearchRepository<TbAndipDipendenteEntity> {

    @Query("from TbAndipDipendenteEntity t where t.andipCodFsc =:andipCodFsc")
    Optional<TbAndipDipendenteEntity> findByAndipCodFsc(String andipCodFsc);


    TbAndipDipendenteEntity findByandipIdPk(Long id);

}
