package it.almaviva.difesa.sipad.docattdocumento.service;

import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.ListaCategoriaOutput;
import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.TpDocatCdocumentoDTO;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response.ListaTipiDocumentiOutput;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response.TpDotipTDocumentoDto;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.entity.TpDotipTDocumento;

import java.util.List;

public interface TipodocumentoService {


    List<TpDocatCdocumentoDTO> listDocatCDocumentoDTO();

    TpDocatCdocumentoDTO getDocatCCategoryById(Long id);

    ListaCategoriaOutput listCategorie();

    ListaTipiDocumentiOutput listTipiDocumenti(long idApplicativo, long docatId);

    TpDotipTDocumentoDto getByCode(String code);

    TpDotipTDocumento getEntityByCode(String code);

    ListaCategoriaOutput listSpecificCategorie(List<Long> idCategories);
}
