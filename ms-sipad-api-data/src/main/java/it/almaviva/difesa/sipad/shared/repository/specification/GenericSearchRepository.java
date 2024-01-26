package it.almaviva.difesa.sipad.shared.repository.specification;


import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericSearchRepository<E extends GenericEntity> extends JpaSpecificationExecutor<E> {
}