package it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.specification;

import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.criteria.VwSg123StgiuridicoDsCriteria;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.dto.RoleCatpersForzaarmataDTO;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.entity.VwSg123StgiuridicoDsunific;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSpecification;
import it.almaviva.difesa.sipad.shared.util.DataUtilsMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class VwSg123StgiuridicoDsSpecification implements GenericSpecification<VwSg123StgiuridicoDsunific, VwSg123StgiuridicoDsCriteria> {

    private final EntityManager manager;

    /***
     * Method to filter the result based on criteria
     * @param vwSg123StgiuridicoDsCriteria all the criteria
     * @return specific entity from db
     */
    @Override
    public Specification<VwSg123StgiuridicoDsunific> getSpecification(VwSg123StgiuridicoDsCriteria vwSg123StgiuridicoDsCriteria) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = filterLastNameFirstNameAndFiscalCode(vwSg123StgiuridicoDsCriteria, criteriaBuilder, root);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123IdDip(), "sg123IdDip")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataNascita(), "sg123DataNascita")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123Matricola(), "sg123Matricola")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataArruolamento(), "sg123DataArruolamento")
                    .ifPresent(predicates::add);

            if (Objects.nonNull(vwSg123StgiuridicoDsCriteria.getSg123IdForzaArmata())) {
                DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, Arrays.asList(vwSg123StgiuridicoDsCriteria.getSg123IdForzaArmata().split(",")), "sg123IdForzaArmata")
                        .ifPresent(predicates::add);
            }

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrForzaArmata(), "sg123DescrForzaArmata")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123CodGrado(), "sg123CodGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrGrado(), "sg123DescrGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataDecGiuGrado(), "sg123DataDecGiuGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrStatoGrado(), "sg123DescrStatoGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrCategoria(), "sg123DescrCategoria")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123CodRuolo(), "sg123CodRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrRuolo(), "sg123DescrRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataDecGiuRuolo(), "sg123DataDecGiuRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrStatoRuolo(), "sg123DescrStatoRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123CodPosizione(), "sg123CodPosizione")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataDecGiuPosizione(), "sg123DataDecGiuPosizione")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrPosizione(), "sg123DescrPosizione")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrStatoPosizione(), "sg123DescrStatoPosizione")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123CodTipArmaCorpo(), "sg123CodTipArmaCorpo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrTipoArmaCorpo(), "sg123DescrTipoArmaCorpo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataDecGiuImm(), "sg123DataDecGiuImm")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataImm(), "sg123DataImm")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123IdCatPersonale(), "sg123IdCatPersonale")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123IdCatPosStato(), "sg123IdCatPosStato")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrCatoPosStato(), "sg123DescrCatoPosStato")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataIniTipPosStato(), "sg123DataIniTipPosStato")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DecorEconRuolo(), "sg123DecorEconRuolo")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DecorEconGrado(), "sg123DecorEconGrado")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataDescrPosser(), "sg123DataDescrPosser")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123IdPosser(), "sg123IdPosser")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrPosser(), "sg123DescrPosser")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123IdCtpCatPersonale(), "sg123IdCtpCatPersonale")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DecgiuCatoPosStato(), "sg123DecgiuCatoPosStato")
                    .ifPresent(predicates::add);

            Set<RoleCatpersForzaarmataDTO> roleCatpersForzaarmataDTOSet = vwSg123StgiuridicoDsCriteria.getRoleCatpersForzaarmata();
            if (roleCatpersForzaarmataDTOSet != null && !roleCatpersForzaarmataDTOSet.isEmpty()) {
                predicates.add(addIdForzaArmataAndDsctpIdPkToPredicate(root, criteriaBuilder, roleCatpersForzaarmataDTOSet));
            } else {
                DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123IdForzaArmataPrec(), "sg123IdForzaArmataPrec")
                        .ifPresent(predicates::add);

                DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DsctpIdPk(), "sg123DsctpIdPk")
                        .ifPresent(predicates::add);
            }

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrForzaArmataPrec(), "sg123DescrForzaArmataPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123CodGradoPrec(), "sg123CodGradoPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrGradoPrec(), "sg123DescrGradoPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123IdCatPersPrec(), "sg123IdCatPersPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrCatPersPrec(), "sg123DescrCatPersPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DsctpDescrCatmilit(), "sg123DsctpDescrCatmilit")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123SgctsIdCatSgPrec(), "sg123SgctsIdCatSgPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123SgctsDescrCatSgPrec(), "sg123SgctsDescrCatSgPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123SgtpoCodCatPerPrec(), "sg123SgtpoCodCatPerPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123SgtpoDescrCatPerPrec(), "sg123SgtpoDescrCatPerPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123SgtpsIdPosStaPrec(), "sg123SgtpsIdPosStaPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123SgtpsDescrPosStaPrec(), "sg123SgtpsDescrPosStaPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123GtpsDataPosStaPrec(), "sg123GtpsDataPosStaPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataDecGiuGradoPrec(), "sg123DataDecGiuGradoPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123CodRuoloPrec(), "sg123CodRuoloPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrRuoloPrec(), "sg123DescrRuoloPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DataRuoloPrec(), "sg123DataRuoloPrec")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrProNas(), "sg123DescrProNas")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrComNas(), "sg123DescrComNas")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123DescrStatoCivile(), "sg123DescrStatoCivile")
                    .ifPresent(predicates::add);

            DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, vwSg123StgiuridicoDsCriteria.getSg123FlagSesso(), "sg123FlagSesso")
                    .ifPresent(predicates::add);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private Predicate addIdForzaArmataAndDsctpIdPkToPredicate(Root<VwSg123StgiuridicoDsunific> root, CriteriaBuilder cb, Set<RoleCatpersForzaarmataDTO> dtos) {
        List<Predicate> predicates = new ArrayList<>();
        dtos.forEach(dto -> {
            Predicate forzaArmataPredicate = cb.equal(root.get("sg123IdForzaArmataPrec"), dto.getIdForzaArmata());
            Predicate dsctpIdPkPredicate = cb.equal(root.get("sg123DsctpIdPk"), dto.getIdCatPersAbilitato());
            predicates.add(cb.and(forzaArmataPredicate, dsctpIdPkPredicate));
        });
        return cb.or(predicates.toArray(new Predicate[0]));
    }

    public List<Long> lastNameFistNameAndCodeFiscalSpecification(VwSg123StgiuridicoDsCriteria vwSg123StgiuridicoDsCriteria) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<VwSg123StgiuridicoDsunific> root = query.from(VwSg123StgiuridicoDsunific.class);

        List<Predicate> predicates = filterLastNameFirstNameAndFiscalCode(vwSg123StgiuridicoDsCriteria, cb, root);

        Predicate condition = cb.and(predicates.toArray(new Predicate[0]));
        CriteriaQuery<Long> cq = query.select(root.get("sg123IdDip")).where(condition);
        return manager.createQuery(cq).getResultList();
    }

    private static List<Predicate> filterLastNameFirstNameAndFiscalCode(VwSg123StgiuridicoDsCriteria vwSg123StgiuridicoDsCriteria, CriteriaBuilder cb, Root<VwSg123StgiuridicoDsunific> root) {
        List<Predicate> predicates = new ArrayList<>();
        DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, cb, vwSg123StgiuridicoDsCriteria.getSg123Cognome(), "sg123Cognome")
                .ifPresent(predicates::add);

        DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, cb, vwSg123StgiuridicoDsCriteria.getSg123Nome(), "sg123Nome")
                .ifPresent(predicates::add);

        DataUtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, cb, vwSg123StgiuridicoDsCriteria.getSg123CodiceFiscale(), "sg123CodiceFiscale")
                .ifPresent(predicates::add);
        return predicates;
    }

}
