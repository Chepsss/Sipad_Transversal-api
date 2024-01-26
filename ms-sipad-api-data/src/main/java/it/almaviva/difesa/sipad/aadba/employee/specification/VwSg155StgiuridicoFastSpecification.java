package it.almaviva.difesa.sipad.aadba.employee.specification;

import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiuridicoFastCriteria;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiuridicoFastEntity;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSpecification;
import it.almaviva.difesa.sipad.shared.util.DataUtilsMethod;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class VwSg155StgiuridicoFastSpecification  implements GenericSpecification<VwSg155StgiuridicoFastEntity, VwSg155StgiuridicoFastCriteria> {

    /***
     * Method to filter the result based on criteria
     * @param vwSg155StgiuridicoCriteria all the criteria
     * @return specific entity from db
     */
    @Override
    public Specification<VwSg155StgiuridicoFastEntity> getSpecification(VwSg155StgiuridicoFastCriteria vwSg155StgiuridicoCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();


            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155IdDip(), "sg155IdDip")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155Nome(), "sg155Nome")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155Cognome(), "sg155Cognome")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodiceFiscale(), "sg155CodiceFiscale")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DataNascita(), "sg155DataNascita")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrGrado(), "sg155DescrGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrRuolo(), "sg155DescrRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrPosser(), "sg155DescrPosser")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155ValGerarchia(), "sg155ValGerarchia")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodFfaa(), "sg155CodFfaa")
                    .ifPresent(predicates::add);

            if (!CollectionUtils.isEmpty(vwSg155StgiuridicoCriteria.getAlreadyPresentEmployeesIds())) {
                predicates.add(criteriaBuilder.not(root.get("sg155IdDip").in(vwSg155StgiuridicoCriteria.getAlreadyPresentEmployeesIds())));
            }
            if (!CollectionUtils.isEmpty(vwSg155StgiuridicoCriteria.getAuthorityUserImmuneOrSupernumerary())) {
                predicates.add(root.get("sg155IdDip").in(vwSg155StgiuridicoCriteria.getAlreadyPresentEmployeesIds()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
