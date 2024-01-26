package it.almaviva.difesa.sipad.hierarchy.service;

import javax.persistence.EntityNotFoundException;

public interface VwSg003SggraGradoService {


    Short findHierarchicalValueByGradeDescription (String gradeDescription) throws EntityNotFoundException;
}
