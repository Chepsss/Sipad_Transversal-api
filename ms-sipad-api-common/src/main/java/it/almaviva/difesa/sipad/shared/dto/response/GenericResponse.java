package it.almaviva.difesa.sipad.shared.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
public class GenericResponse implements Serializable {
    private static final long serialVersionUID = -1765473539361610397L;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String warning;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String error;

}
