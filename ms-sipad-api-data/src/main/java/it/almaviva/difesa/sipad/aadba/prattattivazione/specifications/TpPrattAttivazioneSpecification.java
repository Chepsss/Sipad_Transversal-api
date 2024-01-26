package it.almaviva.difesa.sipad.aadba.prattattivazione.specifications;

import it.almaviva.difesa.sipad.aadba.prattattivazione.entity.TpPrattAttivazione;
import it.almaviva.difesa.sipad.aadba.pratpprocatt.entity.TpPratpProcAtt;
import it.almaviva.difesa.sipad.aadba.prtpatprocedura.entity.TpPrtpaTprocedura;
import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.entity.TpPrtpoTprocedimento;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Setter
@Getter
public class TpPrattAttivazioneSpecification implements Specification<TpPrattAttivazione> {

    private static final long serialVersionUID = -7540462226235297295L;

    private String acrProc;
    private Boolean onlyNotExpired;

    @Override
    public Predicate toPredicate(Root<TpPrattAttivazione> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        Join<TpPrattAttivazione, TpPratpProcAtt> tpPratpProcAttJoin = root.join("tpPratpProcAtts", JoinType.INNER);
        Join<TpPratpProcAtt, TpPrtpoTprocedimento> procAttTpPrtpoTprocedimentoJoin = tpPratpProcAttJoin.join("pratpPrtpoIdPk", JoinType.INNER);
        Join<TpPrtpoTprocedimento, TpPrtpaTprocedura> tpPrtpaTproceduraJoin = procAttTpPrtpoTprocedimentoJoin.join("prtpoPrtpa", JoinType.INNER);

        predicates.add(cb.equal(tpPrtpaTproceduraJoin.get("prtpaAcrProc"), acrProc));
        if (onlyNotExpired) {
            LocalDate currentDate = LocalDate.now();
            predicates.add(cb.between(cb.literal(currentDate), root.get("prattDataIniz"), root.get("prattDataFine")));
        }
        criteriaQuery.distinct(true);
        criteriaQuery.orderBy(cb.asc(root.get("id")));
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
