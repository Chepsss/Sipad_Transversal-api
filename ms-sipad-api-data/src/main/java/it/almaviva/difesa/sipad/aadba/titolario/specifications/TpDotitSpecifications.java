package it.almaviva.difesa.sipad.aadba.titolario.specifications;

import it.almaviva.difesa.sipad.aadba.titolario.dto.response.TitolarioOption;
import it.almaviva.difesa.sipad.aadba.titolario.entity.TpDotitTitolario;
import it.almaviva.difesa.sipad.shared.util.UtilsMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TpDotitSpecifications {

    public static final String COD_TIT = "codTit";
    public static final String DESCR_TIT = "descrTit";
    public static final String COD_CLA = "codCla";
    public static final String DESCR_CLA = "descrCla";
    public static final String COD_SOTCLA = "codSotcla";
    public static final String DESCR_SOTCLA = "descrSotcla";
    public static final String COD_FAS = "codFas";
    public static final String DESCR_FAS = "descrFas";
    public static final String COD_SOTFAS = "codSotfas";
    public static final String DESCR_SOTFAS = "descrSotfas";

    @PersistenceContext
    private final EntityManager manager;

    private CriteriaBuilder criteriaBuilder;

    @PostConstruct
    public void postConstruct() {
        criteriaBuilder = manager.getCriteriaBuilder();
    }

    public List<TitolarioOption> getTitoli() {
        CriteriaQuery<TitolarioOption> query = criteriaBuilder.createQuery(TitolarioOption.class);
        Root<TpDotitTitolario> root = query.from(TpDotitTitolario.class);
        return setFilterToPredicates(null, null, query, root, new ArrayList<>(), COD_TIT, DESCR_TIT);

    }

    public List<TitolarioOption> titolarioByTitolo(String codiceTitolo) {

        CriteriaQuery<TitolarioOption> query = criteriaBuilder.createQuery(TitolarioOption.class);
        Root<TpDotitTitolario> root = query.from(TpDotitTitolario.class);
        List<Predicate> predicates = getPredicateCodTitAndCodClaAndCodSotClaAndCodFasAndCodSotfas(root, codiceTitolo, null, null, null, null);

        return setFilterToPredicates(null, null, query, root, predicates, COD_CLA, DESCR_CLA);

    }

    public List<TitolarioOption> titolarioByTitoloAndClasse(String codiceTitolo, String codiceClasse) {

        CriteriaQuery<TitolarioOption> query = criteriaBuilder.createQuery(TitolarioOption.class);
        Root<TpDotitTitolario> root = query.from(TpDotitTitolario.class);
        List<Predicate> predicates = getPredicateCodTitAndCodClaAndCodSotClaAndCodFasAndCodSotfas(root, codiceTitolo, codiceClasse, null, null, null);

        return setFilterToPredicates(null, null, query, root, predicates, COD_SOTCLA, DESCR_SOTCLA);

    }

    public List<TitolarioOption> titolarioByTitoloAndClasseAndSottoclasse(String codTit,
                                                                          String codCla,
                                                                          String codSotcla,
                                                                          String filtro,
                                                                          Integer max) {

        CriteriaQuery<TitolarioOption> query = criteriaBuilder.createQuery(TitolarioOption.class);
        Root<TpDotitTitolario> root = query.from(TpDotitTitolario.class);
        List<Predicate> predicates = getPredicateCodTitAndCodClaAndCodSotClaAndCodFasAndCodSotfas(root, codTit, codCla, codSotcla, null, null);

        return setFilterToPredicates(filtro, max, query, root, predicates, COD_FAS, DESCR_FAS);

    }

    public List<TitolarioOption> titolarioByTitoloAndClasseAndSottoclasseAndFascicolo(String codTit,
                                                                                      String codCla,
                                                                                      String codSotcla,
                                                                                      String codFas,
                                                                                      String filtro,
                                                                                      Integer max) {
        CriteriaQuery<TitolarioOption> query = criteriaBuilder.createQuery(TitolarioOption.class);
        Root<TpDotitTitolario> root = query.from(TpDotitTitolario.class);
        List<Predicate> predicates = getPredicateCodTitAndCodClaAndCodSotClaAndCodFasAndCodSotfas(root, codTit, codCla, codSotcla, codFas, null);
        return setFilterToPredicates(filtro, max, query, root, predicates, COD_SOTFAS, DESCR_SOTFAS);
    }

    public List<TpDotitTitolario> findByCodes(String codTit,
                                            String codCla,
                                            String codSotcla,
                                            String codFas,
                                            String codSotfas) {
        CriteriaQuery<TpDotitTitolario> query = criteriaBuilder.createQuery(TpDotitTitolario.class);
        Root<TpDotitTitolario> root = query.from(TpDotitTitolario.class);
        List<Predicate> predicates = getPredicateCodTitAndCodClaAndCodSotClaAndCodFasAndCodSotfas(root, codTit, codCla, codSotcla, codFas, codSotfas);
        query.distinct(true).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        return manager.createQuery(query).getResultList();
    }

    private List<TitolarioOption> setFilterToPredicates(String filtro, Integer max, CriteriaQuery<TitolarioOption> query, Root<TpDotitTitolario> root, List<Predicate> predicates, String code, String descr) {
        List<Order> orders = new ArrayList<>();
        orders.add(criteriaBuilder.asc(root.get("id").get(code)));

        if (filtro != null) {
            String pattern = "%" + filtro.toUpperCase() + "%";
            Predicate codeSotFasMatch = criteriaBuilder.like(criteriaBuilder.upper(root.get("id").get(code)), pattern);
            Predicate descrSotFasMatch = criteriaBuilder.like(criteriaBuilder.upper(root.get(descr)), pattern);
            Predicate autocompleteMach = criteriaBuilder.or(codeSotFasMatch, descrSotFasMatch);
            predicates.add(autocompleteMach);

            query.multiselect(root.get("id").get(code).alias("value")
                            , root.get(descr).alias("label"))
                    .distinct(true)
                    .where(criteriaBuilder.and(predicates.toArray(new Predicate[0])))
                    .orderBy(orders);

            if (Optional.ofNullable(max).orElse(0) != 0) {
                return manager.createQuery(query).setMaxResults(max).getResultList();
            } else {
                return manager.createQuery(query).getResultList();
            }
        } else {
            query.multiselect(root.get("id").get(code).alias("value")
                            , root.get(descr).alias("label"))
                    .distinct(true)
                    .where(criteriaBuilder.and(predicates.toArray(new Predicate[0])))
                    .orderBy(orders);
            return manager.createQuery(query).getResultList();
        }
    }

    private List<Predicate> getPredicateCodTitAndCodClaAndCodSotClaAndCodFasAndCodSotfas(Root<TpDotitTitolario> root, String codTit,
                                                                                         String codCla,
                                                                                         String codSotcla,
                                                                                         String codFas,
                                                                                         String codSotfas) {
        List<Predicate> predicates = new ArrayList<>();
        UtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, false, codTit, "id", COD_TIT).ifPresent(predicates::add);
        UtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, false, codCla, "id", COD_CLA).ifPresent(predicates::add);
        UtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, false, codSotcla, "id", COD_SOTCLA).ifPresent(predicates::add);
        UtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, false, codFas, "id", COD_FAS).ifPresent(predicates::add);
        UtilsMethod.addFieldToPredicatesIfNotEmptyOrBlank(root, criteriaBuilder, false, codSotfas, "id", COD_SOTFAS).ifPresent(predicates::add);
        return predicates;
    }
}
