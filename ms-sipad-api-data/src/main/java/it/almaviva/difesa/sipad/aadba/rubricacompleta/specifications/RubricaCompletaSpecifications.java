package it.almaviva.difesa.sipad.aadba.rubricacompleta.specifications;

import it.almaviva.difesa.sipad.aadba.rubricacompleta.entity.RubricaCompleta;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RubricaCompletaSpecifications {


    public static Specification<RubricaCompleta> listAutocomplete(String filtro) {
        if(filtro == null || filtro.equalsIgnoreCase("null")){
            filtro = "";
        }
        String finalFiltro = filtro;
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.isNotNull(root.get("denomNom")));

                String pattern = "%" + finalFiltro.toUpperCase() + "%";
                Predicate nomeMatch = cb.like(cb.upper(root.get("denomNom")), pattern);
                predicates.add(nomeMatch);

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }


    public static Specification<RubricaCompleta> findByKey(String key){
        key = key + "|||| "; //evita indexOutOfBoundExceptions
        String[] split = key.split("[|]");
        String tipoContatto = split[0];
        String denomNom = split[1];
        String mailNom = split[2];
        String pecNom = split[3];
        String indCitta = split[4];

        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(equalOrNullPredicate(cb, root, tipoContatto, "tipoContatto"));
            predicates.add(equalOrNullPredicate(cb, root, denomNom, "denomNom"));
            predicates.add(equalOrNullPredicate(cb, root, mailNom, "mailNom"));
            predicates.add(equalOrNullPredicate(cb, root, pecNom, "pecNom"));
            predicates.add(equalOrNullPredicate(cb, root, indCitta, "indCitta"));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }


   private static Predicate  equalOrNullPredicate(CriteriaBuilder cb, Root<RubricaCompleta> root, String s, String key){
        if(s == null || "".equals(s)){
            return cb.isNull(root.get(key));
        }
        return cb.equal(root.get(key), s);
   }





}
