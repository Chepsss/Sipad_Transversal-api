package it.almaviva.difesa.sipad.aadba.rubricacompleta.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter(AccessLevel.NONE)
@Entity
@ToString
@Table(name = "VW_AN003_RUBRICA_COMPLETA")
public class RubricaCompleta implements GenericEntity {

    /**
     * Denominazione  Nominativo.
     */
    @Id
    @Column(name = "AN003_ID")
    private String id;

    /**
     * Denominazione  Nominativo.
     */
    @Basic
    @Column(name = "AN003_DENOM_NOM", nullable = true)
    private String denomNom;


    /**
     * Descrizione indirizzo
     */
    @Basic
    @Column(name = "AN003_IND_VIA", nullable = true)
    private String indVia;


    /**
     * Indirizzo Nominativo - Città
     */
    @Basic
    @Column(name = "AN003_IND_CITTA", nullable = true)
    private String indCitta;


    /**
     * Indirizzo Nominativo - CAP
     */
    @Basic
    @Column(name = "AN003_IND_CAP", nullable = true)
    private String indCap;


    /**
     * Indirizzo Nominativo - Sigla Provincia
     */
    @Basic
    @Column(name = "AN003_IND_PRO", nullable = true)
    private String indPro;

    /**
     * Mail Nominativo
     */
    @Basic
    @Column(name = "AN003_MAIL_NOM", nullable = true)
    private String mailNom;


    /**
     * PEC Nominativo
     */
    @Basic
    @Column(name = "AN003_PEC_NOM", nullable = true)
    private String pecNom;


    /**
     * Codice IPA
     */
    @Basic
    @Column(name = "AN003_COD_IPA", nullable = true)
    private String codIpa;

    /**
     * Codice univoco AOO
     */
    @Basic
    @Column(name = "AN003_COD_UNIV_AOO", nullable = true)
    private String codUnivAoo;


    /**
     * Codice AOO
     */
    @Basic
    @Column(name = "AN003_COD_AOO", nullable = true)
    private String codAoo;


    /**
     * Tipo contatto. Valori possibili: IPA, PF, PG, PAE, PAI
     */
    @Basic
    @Column(name = "AN003_TIPO_CONTATTO", nullable = true)
    private String tipoContatto;


    /**
     * Titolo
     */
    @Basic
    @Column(name = "AN003_TITOLO", nullable = true)
    private String titolo;

    /**
     * Nome
     */
    @Basic
    @Column(name = "AN003_NOME", nullable = true)
    private String nome;



    /**
     * Cognome
     */
    @Basic
    @Column(name = "AN003_COGNOME", nullable = true)
    private String cognome;


    /**
     * CF o Partita IVA
     */
    @Basic
    @Column(name = "AN003_CF_PIVA", nullable = true)
    private String cfPiva;


    /**
     * Denominazione Ufficio
     */
    @Basic
    @Column(name = "AN003_DENOM_UFFICIO", nullable = true)
    private String denomUfficio;

    @Basic
    @Column(name = "AN003_DENOMINAZIONE_AOO", nullable = true)
    private String denomAoo;

    @Basic
    @Column(name = "AN003_CODICE_UO", nullable = true)
    private String codiceUo;

    @Basic
    @Column(name = "AN003_DENOMINAZIONE_UO", nullable = true)
    private String denomUo;


    public String getKey(){
        return String.format("%s|%s|%s|%s|%s", f(tipoContatto), f(denomNom), f(mailNom), f(pecNom), f(indCitta));
    }

    private static String f(String s){
        return s==null?"":s;
    }

}
