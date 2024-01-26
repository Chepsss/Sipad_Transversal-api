package it.almaviva.difesa.sipad.aadba.proceeding.specification;

import it.almaviva.difesa.sipad.aadba.proceeding.criteria.VwDo007ProcedimentiCriteria;
import it.almaviva.difesa.sipad.aadba.proceeding.entity.VwDo007ProcedimentiEntity;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSpecification;
import it.almaviva.difesa.sipad.shared.util.DataUtilsMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class VwDo007ProcedimentiSpecification  implements GenericSpecification<VwDo007ProcedimentiEntity, VwDo007ProcedimentiCriteria> {

    /***
     * Method to filter the result based on criteria
     * @param vwDo007ProcedimentiCriteria all the criteria
     * @return specific entity from db
     */
    @Override
    public Specification<VwDo007ProcedimentiEntity> getSpecification(VwDo007ProcedimentiCriteria vwDo007ProcedimentiCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007CodFisc(), "do007CodFisc")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007PrproCodPro(), "do007PrproCodPro")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007PrproId(), "do007PrproId")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007DataAvvio(), "do007DataAvvio")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007DataFine(), "do007DataFine")
                        .ifPresent(predicates::add);

            if (vwDo007ProcedimentiCriteria.getIsClosed() == null) {
                DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007Stato(), "do007Stato")
                        .ifPresent(predicates::add);

            } else {
                if (Boolean.TRUE.equals(vwDo007ProcedimentiCriteria.getIsClosed())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("do007Stato")), "CHIUSO"));
                } else {
                    predicates.add(criteriaBuilder.notEqual(criteriaBuilder.upper(root.get("do007Stato")), "CHIUSO"));
                }
            }

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007Fase(), "dO007Fase")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007TipoProc(), "do007TipoProc")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwDo007ProcedimentiCriteria.getDo007Autore(), "do007Autore")
                    .ifPresent(predicates::add);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}