package it.almaviva.difesa.sipad.shared.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutputGenericListResponse < F, L >  implements Serializable {

    private static final long serialVersionUID = -6924726377612573219L;
    private F filter;
    private L list;
    
}
