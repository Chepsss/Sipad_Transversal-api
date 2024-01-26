package it.almaviva.difesa.sipad.aadba.employee.criteria;

import it.almaviva.difesa.sipad.shared.repository.criteria.GenericCriteriaModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class VwSg155StgiuridicoFastCriteria implements GenericCriteriaModel {

    private Long sg155IdDip;
    private String sg155Cognome;
    private String sg155Nome;
    private String sg155CodiceFiscale;
    private Date sg155DataNascita;
    private String sg155DescrGrado;
    private String sg155DescrRuolo;
    private String sg155DescrPosser;
    private Short sg155ValGerarchia;
    private String sg155CodFfaa;
    private boolean isFromArq;
    private List<Long> alreadyPresentEmployeesIds;
    private List<Long> authorityUserImmuneOrSupernumerary;
}
