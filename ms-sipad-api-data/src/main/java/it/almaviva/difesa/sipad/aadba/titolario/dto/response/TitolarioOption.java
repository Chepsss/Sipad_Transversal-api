package it.almaviva.difesa.sipad.aadba.titolario.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class TitolarioOption implements Serializable {
    private static final long serialVersionUID = -6891697956254645264L;
    private String value;
    private String label;
}
