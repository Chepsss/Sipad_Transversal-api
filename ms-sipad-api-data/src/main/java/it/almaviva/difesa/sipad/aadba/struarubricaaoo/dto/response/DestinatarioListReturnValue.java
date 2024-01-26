package it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DestinatarioListReturnValue implements Serializable {

    List<DestinatarioOut> destinatariEsterni;


}
