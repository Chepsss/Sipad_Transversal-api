package it.almaviva.difesa.sipad.shared.repository.specification;



import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.repository.criteria.GenericCriteriaModel;
import org.springframework.data.jpa.domain.Specification;


public interface GenericSpecification<E extends GenericEntity, C extends GenericCriteriaModel> {

    Specification<E> getSpecification(C c);
}