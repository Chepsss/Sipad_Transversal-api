package it.almaviva.difesa.sipad.aadba.employee.specification;

import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiurFastMiCiCriteria;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiurFastMiCiEntity;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSpecification;
import it.almaviva.difesa.sipad.shared.util.DataUtilsMethod;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class VwSg155StgiuridicoFastMiCiSpecification implements GenericSpecification<VwSg155StgiurFastMiCiEntity, VwSg155StgiurFastMiCiCriteria> {

    /***
     * Method to filter the result based on criteria
     * @param vwSg155StgiurFastMiCiCriteria all the criteria
     * @return specific entity from db
     */
    @Override
    public Specification<VwSg155StgiurFastMiCiEntity> getSpecification(VwSg155StgiurFastMiCiCriteria vwSg155StgiurFastMiCiCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155IdDip(), "sg155IdDip")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155Nome(), "sg155Nome")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155Cognome(), "sg155Cognome")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155CodiceFiscale(), "sg155CodiceFiscale")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155DataNascita(), "sg155DataNascita")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155Sesso(), "sg155Sesso")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155Mail(), "sg155Mail")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155DescrGrado(), "sg155DescrGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiurFastMiCiCriteria.getSg155CodFfaa(), "sg155CodFfaa")
                    .ifPresent(predicates::add);

            if (!CollectionUtils.isEmpty(vwSg155StgiurFastMiCiCriteria.getAlreadyPresentEmployeesIds())) {
                predicates.add(criteriaBuilder.not(root.get("sg155IdDip").in(vwSg155StgiurFastMiCiCriteria.getAlreadyPresentEmployeesIds())));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
