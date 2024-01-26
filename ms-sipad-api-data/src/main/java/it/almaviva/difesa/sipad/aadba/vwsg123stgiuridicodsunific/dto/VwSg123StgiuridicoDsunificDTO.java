package it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.dto;

import it.almaviva.difesa.sipad.shared.dto.GenericResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VwSg123StgiuridicoDsunificDTO implements GenericResponseDTO {

    private Long sg123IdDip;
    private String sg123Cognome;
    private String sg123Nome;
    private String sg123CodiceFiscale;
    private LocalDate sg123DataNascita;
    private String sg123Matricola;
    private LocalDate sg123DataArruolamento;
    private String sg123IdForzaArmata;
    private String sg123DescrForzaArmata;
    private String sg123CodGrado;
    private String sg123DescrGrado;
    private LocalDate sg123DataDecGiuGrado;
    private String sg123DescrStatoGrado;
    private String sg123DescrCategoria;
    private String sg123CodRuolo;
    private String sg123DescrRuolo;
    private LocalDate sg123DataDecGiuRuolo;
    private String sg123DescrStatoRuolo;
    private String sg123CodPosizione;
    private LocalDate sg123DataDecGiuPosizione;
    private String sg123DescrPosizione;
    private String sg123DescrStatoPosizione;
    private String sg123CodTipArmaCorpo;
    private String sg123DescrTipoArmaCorpo;
    private LocalDate sg123DataDecGiuImm;
    private LocalDate sg123DataImm;
    private Long sg123IdCatPersonale;
    private Long sg123IdCatPosStato;
    private String sg123DescrCatoPosStato;
    private LocalDate sg123DataIniTipPosStato;
    private LocalDate sg123DecorEconRuolo;
    private LocalDate sg123DecorEconGrado;
    private LocalDate sg123DataDescrPosser;
    private String sg123IdPosser;
    private String sg123DescrPosser;
    private Long sg123IdCtpCatPersonale;
    private LocalDate sg123DecgiuCatoPosStato;
    private String sg123IdForzaArmataPrec;
    private String sg123DescrForzaArmataPrec;
    private String sg123CodGradoPrec;
    private String sg123DescrGradoPrec;
    private Long sg123IdCatPersPrec;
    private String sg123DescrCatPersPrec;
    private Long sg123DsctpIdPk;
    private String sg123DsctpDescrCatmilit;
    private Long sg123SgctsIdCatSgPrec;
    private String sg123SgctsDescrCatSgPrec;
    private String sg123SgtpoCodCatPerPrec;
    private String sg123SgtpoDescrCatPerPrec;
    private String sg123SgtpsIdPosStaPrec;
    private String sg123SgtpsDescrPosStaPrec;
    private LocalDate sg123GtpsDataPosStaPrec;
    private LocalDate sg123DataDecGiuGradoPrec;
    private String sg123CodRuoloPrec;
    private String sg123DescrRuoloPrec;
    private LocalDate sg123DataRuoloPrec;
    private String sg123DescrProNas;
    private String sg123DescrComNas;
    private String sg123DescrStatoCivile;
    private String sg123FlagSesso;
}
