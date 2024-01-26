package it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.specifications;

import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.entity.TbStoraOrganigrammaAoo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StoraOrganigrammaSpecifivcations {


    public static Specification<TbStoraOrganigrammaAoo> listAooLevel1() {
        Date now = new Date(new java.util.Date().getTime());

        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("numLivello"), 1));
            predicates.add(cb.greaterThan(root.get("dataFine"), now));
            predicates.add(cb.lessThan(root.get("dataIniz"), now));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }


    public static Specification<TbStoraOrganigrammaAoo> listAooLevel2(String liv2) {
        Date now = new Date(new java.util.Date().getTime());
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("numLivello"), 2));
            predicates.add(cb.equal(root.get("denomLiv2"), liv2));
            predicates.add(cb.greaterThan(root.get("dataFine"), now));
            predicates.add(cb.lessThan(root.get("dataIniz"), now));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<TbStoraOrganigrammaAoo> listAooLevel3(String liv2, String liv3) {
        Date now = new Date(new java.util.Date().getTime());
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("numLivello"), 3));
            predicates.add(cb.equal(root.get("denomLiv2"), liv2));
            predicates.add(cb.equal(root.get("denomLiv3"), liv3));
            predicates.add(cb.greaterThan(root.get("dataFine"), now));
            predicates.add(cb.lessThan(root.get("dataIniz"), now));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<TbStoraOrganigrammaAoo> listAooLevel4(String liv2, String liv3, String liv4) {
        Date now = new Date(new java.util.Date().getTime());
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("numLivello"), 4));
            predicates.add(cb.equal(root.get("denomLiv2"), liv2));
            predicates.add(cb.equal(root.get("denomLiv3"), liv3));
            predicates.add(cb.equal(root.get("denomLiv4"), liv4));
            predicates.add(cb.greaterThan(root.get("dataFine"), now));
            predicates.add(cb.lessThan(root.get("dataIniz"), now));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<TbStoraOrganigrammaAoo> listAooLevel5(String liv2, String liv3, String liv4, String liv5) {
        Date now = new Date(new java.util.Date().getTime());
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("numLivello"), 5));
            predicates.add(cb.equal(root.get("denomLiv2"), liv2));
            predicates.add(cb.equal(root.get("denomLiv3"), liv3));
            predicates.add(cb.equal(root.get("denomLiv4"), liv4));
            predicates.add(cb.equal(root.get("denomLiv5"), liv5));
            predicates.add(cb.greaterThan(root.get("dataFine"), now));
            predicates.add(cb.lessThan(root.get("dataIniz"), now));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<TbStoraOrganigrammaAoo> dettaglio(String liv1, String liv2, String liv3, String liv4, String liv5) {
        Date now = new Date(new java.util.Date().getTime());
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            addNullPredicate(predicates, cb, root, liv1, "denomLiv1");
            addNullPredicate(predicates, cb, root, liv2, "denomLiv2");
            addNullPredicate(predicates, cb, root, liv3, "denomLiv3");
            addNullPredicate(predicates, cb, root, liv4, "denomLiv4");
            addNullPredicate(predicates, cb, root, liv5, "denomLiv5");

            predicates.add(cb.greaterThan(root.get("dataFine"), now));
            predicates.add(cb.lessThan(root.get("dataIniz"), now));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private static void addNullPredicate(List<Predicate> predicates, CriteriaBuilder cb, Root<TbStoraOrganigrammaAoo> root, String liv, String denomLiv) {
        if(liv == null) {
            predicates.add(cb.isNull(root.get(denomLiv)));
        }else {
            predicates.add(cb.equal(root.get(denomLiv), liv));
        }
    }

}
