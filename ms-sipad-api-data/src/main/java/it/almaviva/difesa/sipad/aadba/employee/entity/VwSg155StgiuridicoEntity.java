package it.almaviva.difesa.sipad.aadba.employee.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "VW_SG155_STGIURIDICO")
public class VwSg155StgiuridicoEntity implements GenericEntity {
    
    @Basic
    @Column(name = "SG155_COD_FFAA", length = 12)
    private String sg155CodFfaa;
    @Basic
    @Column(name = "SG155_COD_UID_FFAA", length = 12)
    private String sg155CodUidFfaa;
    @Basic
    @Column(name = "SG155_DESCR_FFAA", length = 255)
    private String sg155DescrFfaa;
    @Basic
    @Column(name = "SG155_ID_CATMIL", precision = 0)
    private Short sg155IdCatmil;
    @Basic
    @Column(name = "SG155_COD_UID_CATMIL", length = 12)
    private String sg155CodUidCatmil;
    @Basic
    @Column(name = "SG155_DESCR_CATMIL", length = 255)
    private String sg155DescrCatmil;
    @Basic
    @Column(name = "SG155_COD_RUOLO", length = 12)
    private String sg155CodRuolo;
    @Basic
    @Column(name = "SG155_COD_UID_RUOLO", length = 12)
    private String sg155CodUidRuolo;
    @Basic
    @Column(name = "SG155_DESCR_RUOLO", length = 255)
    private String sg155DescrRuolo;
    @Basic
    @Column(name = "SG155_DATA_DEC_GIU_RUOLO")
    private Date sg155DataDecGiuRuolo;
    @Basic
    @Column(name = "SG155_NUMERO_POS_RUOLO", precision = 0)
    private Short sg155NumeroPosRuolo;
    @Basic
    @Column(name = "SG155_DATA_QUALIFICA")
    private Date sg155DataQualifica;
    @Basic
    @Column(name = "SG155_COD_GRADO", length = 12)
    private String sg155CodGrado;
    @Basic
    @Column(name = "SG155_COD_UID_GRADO", length = 12)
    private String sg155CodUidGrado;
    @Basic
    @Column(name = "SG155_DESCR_GRADO", length = 100)
    private String sg155DescrGrado;
    @Basic
    @Column(name = "SG155_VAL_GERARCHIA", precision = 0)
    private Short sg155ValGerarchia;
    @Basic
    @Column(name = "SG155_DATA_DEC_GIU_GRADO")
    private Date sg155DataDecGiuGrado;
    @Basic
    @Column(name = "SG155_DATA_DEC_ECO_GRADO")
    private Date sg155DataDecEcoGrado;
    @Id
    @Basic
    @Column(name = "SG155_ID_DIP", nullable = false, precision = 0)
    private Long sg155IdDip;
    @Basic
    @Column(name = "SG155_COGNOME", nullable = false, length = 50)
    private String sg155Cognome;
    @Basic
    @Column(name = "SG155_NOME", nullable = false, length = 50)
    private String sg155Nome;
    @Basic
    @Column(name = "SG155_SESSO", nullable = false, length = 1)
    private String sg155Sesso;
    @Basic
    @Column(name = "SG155_CODICE_FISCALE", nullable = false, length = 16)
    private String sg155CodiceFiscale;
    @Basic
    @Column(name = "SG155_DATA_NASCITA", nullable = false)
    private Date sg155DataNascita;
    @Basic
    @Column(name = "SG155_MATRICOLA", length = 20)
    private String sg155Matricola;
    @Basic
    @Column(name = "SG155_MAIL_UFFICIO", length = 100)
    private String sg155MailUfficio;
    @Basic
    @Column(name = "SG155_COD_CATPERS", length = 12)
    private String sg155CodCatpers;
    @Basic
    @Column(name = "SG155_COD_UID_CATPERS", length = 12)
    private String sg155CodUidCatpers;
    @Basic
    @Column(name = "SG155_DESCR_CATPERS", length = 100)
    private String sg155DescrCatpers;
    @Basic
    @Column(name = "SG155_DATA_DEC_GIU_CATPERS")
    private Date sg155DataDecGiuCatpers;
    @Basic
    @Column(name = "SG155_ID_POSSER", length = 10)
    private String sg155IdPosser;
    @Basic
    @Column(name = "SG155_DESCR_POSSER", length = 100)
    private String sg155DescrPosser;
    @Basic
    @Column(name = "SG155_UID_POS_SER", length = 12)
    private String sg155UidPosSer;
    @Basic
    @Column(name = "SG155_ACR_POSSER", length = 12)
    private String sg155AcrPosSer;
    @Basic
    @Column(name = "SG155_COD_SPEC_CAT", length = 12)
    private String sg155CodSpecCat;
    @Basic
    @Column(name = "SG155_COD_UID_SPEC_CAT", length = 12)
    private String sg155CodUidSpecCat;
    @Basic
    @Column(name = "SG155_DESCR_SPEC_CAT", length = 255)
    private String sg155DescrSpecCat;
    @Basic
    @Column(name = "SG155_DESCR_SPEC_INC", length = 255)
    private String sg155DescrSpecInc;
    @Basic
    @Column(name = "SG155_DATA_ANZ_SP")
    private Date sg155DataAnzSp;
    @Basic
    @Column(name = "SG155_SIGLA_PROV_NASC", length = 2)
    private String sg155SiglaProvNasc;
    @Basic
    @Column(name = "SG155_COMUNE_NASCITA", length = 100)
    private String sg155ComuneNascita;
    @Basic
    @Column(name = "SG155_DESCR_CATPOS", length = 100)
    private String sg155DescrCatpos;
    @Basic
    @Column(name = "SG155_STATO_CIVILE", length = 100)
    private String sg155StatoCivile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VwSg155StgiuridicoEntity that = (VwSg155StgiuridicoEntity) o;
        return sg155IdDip != null && Objects.equals(sg155IdDip, that.sg155IdDip);
    }

    @Override
    public int hashCode() { return getClass().hashCode();}

}
