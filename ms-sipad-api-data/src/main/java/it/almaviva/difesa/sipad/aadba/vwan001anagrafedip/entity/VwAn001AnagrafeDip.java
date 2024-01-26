package it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import lombok.*;
import org.springframework.data.domain.Sort;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "vw_an001_anagrafe_dip")
public class VwAn001AnagrafeDip implements Serializable, GenericEntity, Sortable {

    private static final long serialVersionUID = 2929418803254197752L;

    @Id
    @Column(name = "an001_id_dip", unique = true)
    private Long idDip;

    @Column(name = "an001_descr_cogn")
    private String cognome;

    @Column(name = "an001_descr_nome")
    private String nome;

    @Column(name = "an001_cod_fiscale")
    private String codFiscale;

    @Column(name = "an001_data_nascita")
    private LocalDate dataNascita;

    @Column(name = "an001_flag_sesso")
    private String sesso;

    @Column(name = "an001_cod_matricola")
    private String codMatricola;

    @Column(name = "an001_mail_ufficio")
    private String mailUfficio;

    @Column(name = "an001_descr_com_nas")
    private String descrComNas;

    @Column(name = "an001_id_com_nas")
    private Long idComNas;

    @Column(name = "an001_descr_pro_nas")
    private String descrProNas;

    @Column(name = "an001_cod_pro_nas")
    private String codProNas;

    @Column(name = "an001_descr_naz_nas")
    private String descrNazNas;

    @Column(name = "an001_ind_res")
    private String indRes;

    @Column(name = "an001_cap_res")
    private String capRes;

    @Column(name = "an001_descr_com_res")
    private String descrComRes;

    @Column(name = "an001_descr_pro_res")
    private String descrProRes;

    @Column(name = "an001_cod_pro_res")
    private String codProRes;

    @Column(name = "an001_descr_stato_civile")
    private String descrStatoCivile;

    @Column(name = "an001_data_stato_civile")
    private LocalDate dataStatoCivile;

    @Column(name = "an001_id_stato_civile")
    private Long idStatoCivile;

    @Column(name = "an001_res_estera")
    private String resEstera;

    @Column(name = "an001_ind_domicilio")
    private String indDomicilio;

    @Column(name = "an001_cap_domicilio")
    private String capDomicilio;

    @Column(name = "an001_comune_domicilio")
    private String comuneDomicilio;

    @Column(name = "an001_nazione_estera_dom")
    private String nazioneEsteraDom;

    @Column(name = "an001_provincia_domicilio")
    private String provinciaDomicilio;

    @Column(name = "an001_cod_prov_dom")
    private String codProvDom;

    @Column(name = "an001_stfaa")
    private String stfaa;

    @Override
    public Sort getSort() {
        return null;
    }

}
