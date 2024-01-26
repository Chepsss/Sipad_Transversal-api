package it.almaviva.difesa.sipad.aadba.employee.criteria;

import it.almaviva.difesa.sipad.shared.repository.criteria.GenericCriteriaModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class VwSg155StgiurFastMiCiCriteria implements Serializable, GenericCriteriaModel {
    private static final long serialVersionUID = -4500548458494598394L;
    private Long sg155IdDip;
    private String sg155Cognome;
    private String sg155Nome;
    private String sg155CodiceFiscale;
    private LocalDate sg155DataNascita;
    private String sg155Sesso;
    private String sg155Mail;
    private String sg155CodGrado;
    private String sg155DescrGrado;
    private String sg155CodFfaa;
    private String sg155DescrFfaa;
    private List<Long> alreadyPresentEmployeesIds;
}