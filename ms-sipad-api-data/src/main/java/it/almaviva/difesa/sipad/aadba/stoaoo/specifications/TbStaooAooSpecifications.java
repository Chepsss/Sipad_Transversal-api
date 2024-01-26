package it.almaviva.difesa.sipad.aadba.stoaoo.specifications;

import it.almaviva.difesa.sipad.aadba.stoaoo.entity.TbStaooAoo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TbStaooAooSpecifications {


    public static Specification<TbStaooAoo> listAutocomplete(String filtro) {

        Date now = new Date(new java.util.Date().getTime());

        String pattern = "%" + filtro.toUpperCase() + "%";
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            Predicate codMatch = cb.like(cb.upper(root.get("cod")), pattern);
            Predicate descrizioneMatch = cb.like(cb.upper(root.get("descrAoo")), pattern);
            predicates.add(cb.or(codMatch, descrizioneMatch));
            predicates.add(cb.greaterThan(root.get("dataFine"), now));
            predicates.add(cb.lessThan(root.get("dataIniz"), now));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
