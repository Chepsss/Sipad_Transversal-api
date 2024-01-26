package it.almaviva.difesa.sipad.aadba.stoaoo.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class AooAutocompleteOut implements Serializable {
    private static final long serialVersionUID = 8144621113297136036L;

    private List<AooOutput> list;
}
