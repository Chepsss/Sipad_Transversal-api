package it.almaviva.difesa.sipad.aadba.pratpprocatt.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.almaviva.difesa.sipad.aadba.prattattivazione.dto.response.TpPrattAttivazioneDTO;
import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.dto.response.TpPrtpoTprocedimentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpPratpProcAttDTO implements Serializable {

    private static final long serialVersionUID = -9162589490473443930L;

    private TpPratpProcAttIdDTO id;
    private LocalDate pratpDataIniz;
    private LocalDate pratpDataFine;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpPrattAttivazioneDTO pratpPrattIdPk;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpPrtpoTprocedimentoDTO pratpPrtpoIdPk;
}
