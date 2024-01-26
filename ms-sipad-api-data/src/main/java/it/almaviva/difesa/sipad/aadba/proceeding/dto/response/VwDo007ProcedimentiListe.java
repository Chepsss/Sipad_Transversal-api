package it.almaviva.difesa.sipad.aadba.proceeding.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VwDo007ProcedimentiListe {

    Page<VwDo007ProcedimentiDTO> openedProceedings;
    Page<VwDo007ProcedimentiDTO> closedProceedings;
}
