package it.almaviva.difesa.sipad.struarubricaaoo.service;

import it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response.DestinatarioListReturnValue;
import it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response.DettaglioDestinatarioOut;

public interface RubricaAooService {
    DestinatarioListReturnValue elenco(String filtro, Integer max);

    DettaglioDestinatarioOut getById(Long id);
}
