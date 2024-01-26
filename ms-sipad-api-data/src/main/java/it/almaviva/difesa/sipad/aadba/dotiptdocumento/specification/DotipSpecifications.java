package it.almaviva.difesa.sipad.aadba.dotiptdocumento.specification;

import it.almaviva.difesa.sipad.aadba.dotiptdocumento.entity.TpDotipTDocumento;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DotipSpecifications {

    public static Specification<TpDotipTDocumento> getTipoDocumentoByCategoria(long prtpaId, long docatId) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("prtpaId"), prtpaId));
            predicates.add(criteriaBuilder.equal(root.get("docatId"), docatId));
            Date currentDate = new Date();
            predicates.add(criteriaBuilder.between(criteriaBuilder.literal(currentDate), root.get("dataIniz"), root.get("dataFine")));
            criteriaQuery.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
