package it.almaviva.difesa.sipad.stoaoo.service;

import it.almaviva.difesa.sipad.aadba.stoaoo.dto.response.AooAutocompleteOut;
import it.almaviva.difesa.sipad.aadba.stoaoo.entity.TbStaooAoo;
import org.springframework.stereotype.Service;

@Service
public interface AooService {


    AooAutocompleteOut list(String filtro, Integer num);

    TbStaooAoo dettaglio(String cod);
}
