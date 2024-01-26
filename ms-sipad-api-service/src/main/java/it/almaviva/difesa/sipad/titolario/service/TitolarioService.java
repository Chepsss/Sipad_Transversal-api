package it.almaviva.difesa.sipad.titolario.service;

import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaClassi;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaFascicoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaSottoclassi;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaSottofascicoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.ListaTitoli;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.TitolarioDto;

public interface TitolarioService {

    ListaTitoli titolarioCompleto();

    ListaClassi titolario(String codiceTitolo);

    ListaSottoclassi titolario(String codiceTitolo, String codiceClasse);

    ListaFascicoli titolario(String codiceTitolo, String codiceClasse, String codiceSottoclasse, String filtro, Integer max);

    ListaSottofascicoli titolario(String codiceTitolo, String codiceClasse, String codiceSottoclasse, String codiceFascicolo, String filtro, Integer max);

    TitolarioDto dettaglio(String codiceTitolo, String codiceClasse, String codiceSottoclasse, String codiceFascicolo, String codiceSottofascicolo);

}
