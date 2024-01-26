package it.almaviva.difesa.sipad.aadba.struarubricaaoo.specifications;

import it.almaviva.difesa.sipad.aadba.struarubricaaoo.entity.TbStruaRubricaAoo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RubricaAooSpecifications {


    public static Specification<TbStruaRubricaAoo> listAutocomplete(String filtro) {

        Date now = new Date(new java.util.Date().getTime());

        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filtro != null) {
                String pattern = "%" + filtro.toUpperCase() + "%";
                Predicate nomeMatch = cb.like(cb.upper(root.get("denomNom")), pattern);
                predicates.add(nomeMatch);
            }
            predicates.add(cb.greaterThan(root.get("dataFine"), now));
            predicates.add(cb.lessThan(root.get("dataIniz"), now));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }


}
