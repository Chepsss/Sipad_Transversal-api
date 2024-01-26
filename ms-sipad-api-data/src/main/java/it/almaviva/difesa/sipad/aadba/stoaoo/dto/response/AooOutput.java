package it.almaviva.difesa.sipad.aadba.stoaoo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AooOutput  implements Serializable {
    private static final long serialVersionUID = -3407781972682829159L;

    private String codAoo;
    private String aoo;
}
