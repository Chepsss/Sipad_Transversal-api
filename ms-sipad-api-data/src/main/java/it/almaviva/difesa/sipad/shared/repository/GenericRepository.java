package it.almaviva.difesa.sipad.shared.repository;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericRepository<E extends GenericEntity, I extends Serializable> extends JpaRepository<E, I> {
}
