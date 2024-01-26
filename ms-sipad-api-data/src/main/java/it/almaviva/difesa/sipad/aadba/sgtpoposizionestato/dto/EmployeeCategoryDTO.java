package it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeCategoryDTO {

    List<String> categories;

}
