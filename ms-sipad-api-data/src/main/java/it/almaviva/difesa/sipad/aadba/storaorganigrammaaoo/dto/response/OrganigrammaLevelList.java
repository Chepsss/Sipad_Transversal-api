package it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrganigrammaLevelList implements Serializable {


    private List<String> list;
    private List<OrganigrammaLevel> livelli;
}
