package it.almaviva.difesa.sipad.aadba.employee.specification;

import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiuridicoCriteria;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiuridicoEntity;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSpecification;
import it.almaviva.difesa.sipad.shared.util.DataUtilsMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class VwSg155StgiuridicoSpecification implements GenericSpecification<VwSg155StgiuridicoEntity, VwSg155StgiuridicoCriteria> {

    public static final String SG_155_ID_DIP = "sg155IdDip";
    private final EntityManager manager;

    /***
     * Method to filter the result based on criteria
     * @param vwSg155StgiuridicoCriteria all the criteria
     * @return specific entity from db
     */
    @Override
    public Specification<VwSg155StgiuridicoEntity> getSpecification(VwSg155StgiuridicoCriteria vwSg155StgiuridicoCriteria) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = filterLastNameFirstNameAndFiscalCode(vwSg155StgiuridicoCriteria, criteriaBuilder, root);

            if (Objects.nonNull(vwSg155StgiuridicoCriteria.getSg155CodFfaa())) {
                DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, Arrays.asList(vwSg155StgiuridicoCriteria.getSg155CodFfaa().split(",")), "sg155CodFfaa")
                        .ifPresent(predicates::add);
            }

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodGrado(), "sg155CodGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodUidRuolo(), "sg155CodUidRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155Sesso(), "sg155Sesso")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155Matricola(), "sg155Matricola")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155MailUfficio(), "sg155MailUfficio")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodCatpers(), "sg155CodCatpers")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodSpecCat(), "sg155CodSpecCat")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodUidCatmil(), "sg155CodUidCatmil")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155ValGerarchia(), "sg155ValGerarchia")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DataAnzSp(), "sg155DataAnzSp")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrPosser(), "sg155DescrPosser")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DataQualifica(), "sg155DataQualifica")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155IdDip(), SG_155_ID_DIP)
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155NumeroPosRuolo(), "sg155NumeroPosRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DataDecGiuGrado(), "sg155DataDecGiuGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155UidPosSer(), "sg155UidPosSer")
                    .ifPresent(predicates::add);

            if(vwSg155StgiuridicoCriteria.isFromArq()) {
                predicates.add(criteriaBuilder.and(
                                criteriaBuilder.equal(root.get("sg155IdCatmil"), 1),
                                criteriaBuilder.or(criteriaBuilder.like(criteriaBuilder.upper(root.get("sg155AcrPosSer")),  "SPE%"), criteriaBuilder.like(criteriaBuilder.upper(root.get("sg155AcrPosSer")), "SPAD%"))
                        ));
            }
            if (!CollectionUtils.isEmpty(vwSg155StgiuridicoCriteria.getAlreadyPresentEmployeesIds())) {
                predicates.add(criteriaBuilder.not(root.get(SG_155_ID_DIP).in(vwSg155StgiuridicoCriteria.getAlreadyPresentEmployeesIds())));
            }

            if (!CollectionUtils.isEmpty(vwSg155StgiuridicoCriteria.getAuthorityUserImmuneOrSupernumerary())) {
                predicates.add(root.get(SG_155_ID_DIP).in(vwSg155StgiuridicoCriteria.getAlreadyPresentEmployeesIds()));
            }
            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DataDecEcoGrado(), "sg155DataDecEcoGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DataDecGiuCatpers(), "sg155DataDecGiuCatpers")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DataDecGiuRuolo(), "sg155DataDecGiuRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodRuolo(), "sg155CodRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodUidCatpers(), "sg155CodUidCatpers")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodUidFfaa(), "sg155CodUidFfaa")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodUidGrado(), "sg155CodUidGrado")
                    .ifPresent(predicates::add);

            if (Objects.nonNull(vwSg155StgiuridicoCriteria.getSg155DescrCatmil())) {
                DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, Arrays.asList(vwSg155StgiuridicoCriteria.getSg155DescrCatmil().split(",")), "sg155DescrCatmil")
                        .ifPresent(predicates::add);
            }

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrCatpers(), "sg155DescrCatpers")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrSpecInc(), "sg155DescrSpecInc")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrRuolo(), "sg155DescrRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrFfaa(), "sg155DescrFfaa")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155CodUidSpecCat(), "sg155CodUidSpecCat")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrSpecCat(), "sg155DescrSpecCat")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155IdPosser(), "sg155IdPosser")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155IdCatmil(), "sg155IdCatmil")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DescrGrado(), "sg155DescrGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg155StgiuridicoCriteria.getSg155DataNascita(), "sg155DataNascita")
                    .ifPresent(predicates::add);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public List<Long> lastNameFistNameAndCodeFiscalSpecification(VwSg155StgiuridicoCriteria vwSg155StgiuridicoCriteria) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<VwSg155StgiuridicoEntity> root = query.from(VwSg155StgiuridicoEntity.class);

        List<Predicate> predicates = filterLastNameFirstNameAndFiscalCode(vwSg155StgiuridicoCriteria, cb, root);

        Predicate condition = cb.and(predicates.toArray(new Predicate[0]));
        CriteriaQuery<Long> cq = query.select(root.get(SG_155_ID_DIP)).where(condition);
        return manager.createQuery(cq).getResultList();
    }

    private List<Predicate> filterLastNameFirstNameAndFiscalCode(VwSg155StgiuridicoCriteria vwSg155StgiuridicoCriteria, CriteriaBuilder cb, Root<VwSg155StgiuridicoEntity> root) {
        List<Predicate> predicates = new ArrayList<>();
        DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, cb, vwSg155StgiuridicoCriteria.getSg155Nome(), "sg155Nome")
                .ifPresent(predicates::add);

        DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, cb, vwSg155StgiuridicoCriteria.getSg155Cognome(), "sg155Cognome")
                .ifPresent(predicates::add);

        DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, cb, vwSg155StgiuridicoCriteria.getSg155CodiceFiscale(), "sg155CodiceFiscale")
                .ifPresent(predicates::add);
        return predicates;
    }

}
