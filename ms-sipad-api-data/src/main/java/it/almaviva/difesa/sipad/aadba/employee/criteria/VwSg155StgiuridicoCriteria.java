package it.almaviva.difesa.sipad.aadba.employee.criteria;

import it.almaviva.difesa.sipad.shared.repository.criteria.GenericCriteriaModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;


@Getter
@Setter
public class VwSg155StgiuridicoCriteria implements GenericCriteriaModel {

    private String sg155CodFfaa;
    private String sg155CodUidFfaa;
    private String sg155DescrFfaa;
    private Short sg155IdCatmil;
    private String sg155CodUidCatmil;
    private String sg155DescrCatmil;
    private String sg155CodRuolo;
    private String sg155CodUidRuolo;
    private String sg155DescrRuolo;
    private Date sg155DataDecGiuRuolo;
    private Short sg155NumeroPosRuolo;
    private Date sg155DataQualifica;
    private String sg155CodGrado;
    private String sg155CodUidGrado;
    private String sg155DescrGrado;
    private Short sg155ValGerarchia;
    private Date sg155DataDecGiuGrado;
    private Date sg155DataDecEcoGrado;
    private Long sg155IdDip;
    private String sg155Cognome;
    private String sg155Nome;
    private String sg155Sesso;
    private String sg155CodiceFiscale;
    private Date sg155DataNascita;
    private String sg155Matricola;
    private String sg155MailUfficio;
    private String sg155CodCatpers;
    private String sg155CodUidCatpers;
    private String sg155DescrCatpers;
    private Date sg155DataDecGiuCatpers;
    private String sg155IdPosser;
    private String sg155DescrPosser;
    private String sg155UidPosSer;
    private String sg155AcrPosSer;
    private String sg155CodSpecCat;
    private String sg155CodUidSpecCat;
    private String sg155DescrSpecCat;
    private String sg155DescrSpecInc;
    private Date sg155DataAnzSp;
    private boolean isFromArq;
    private List<Long> alreadyPresentEmployeesIds;
    private List<Long> authorityUserImmuneOrSupernumerary;
}
