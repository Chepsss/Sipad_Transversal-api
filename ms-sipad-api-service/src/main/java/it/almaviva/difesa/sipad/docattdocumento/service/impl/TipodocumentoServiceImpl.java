package it.almaviva.difesa.sipad.docattdocumento.service.impl;

import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.CategoriaDto;
import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.ListaCategoriaOutput;
import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.TpDocatCdocumentoDTO;
import it.almaviva.difesa.sipad.aadba.docatcdocumento.entity.TpDocatCDocumento;
import it.almaviva.difesa.sipad.aadba.docatcdocumento.repository.TpDocatCDocumentoRepository;
import it.almaviva.difesa.sipad.docattdocumento.mapper.TpDocatCDocumentoMapper;
import it.almaviva.difesa.sipad.docattdocumento.mapper.TpDotipTDocumentoMapper;
import it.almaviva.difesa.sipad.docattdocumento.service.TipodocumentoService;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response.ListaTipiDocumentiOutput;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response.TpDotipTDocumentoDto;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.entity.TpDotipTDocumento;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.repository.TpDotipTDocumentoRepository;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.specification.DotipSpecifications;
import it.almaviva.difesa.sipad.shared.util.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TipodocumentoServiceImpl implements TipodocumentoService {

    @Autowired
    TpDocatCDocumentoRepository categoriaRepository;

    @Autowired
    TpDotipTDocumentoRepository tipoDocumentoRepository;

    @Autowired
    TpDotipTDocumentoMapper tpDotipTDocumentoMapper;

    @Autowired
    TpDocatCDocumentoMapper tpDocatCDocumentoMapper;


    @Override
    public List<TpDocatCdocumentoDTO> listDocatCDocumentoDTO() {
        List<TpDocatCDocumento> categorie = categoriaRepository.findAllByDataFineAfterAndDataInizBeforeOrderByAcrCat(new Date(), new Date());
        if(categorie == null || categorie.isEmpty()){
            return new ArrayList<>();
        }
        return tpDocatCDocumentoMapper.toDto(categorie);
    }

    @Override
    public TpDocatCdocumentoDTO getDocatCCategoryById(Long id){
        TpDocatCDocumento tpDocatCDocumento = categoriaRepository.findById(id).orElse(null);
       if(null == tpDocatCDocumento){
           throw new EntityNotFoundException("TpDocatCdocumentoDTO non trovato");
       }
        return tpDocatCDocumentoMapper.toDto(tpDocatCDocumento);

    }


    @Override
    public ListaCategoriaOutput listCategorie() {

        List<TpDocatCDocumento> categorie = categoriaRepository.findAllByDataFineAfterAndDataInizBeforeOrderByAcrCat(new Date(), new Date());
        ListaCategoriaOutput out = new ListaCategoriaOutput();
        out.setCategorie(new ArrayList<>());
        for (TpDocatCDocumento categoria : categorie) {
            CategoriaDto dto = new CategoriaDto();
            dto.setCodice(String.valueOf(categoria.getId()));
            dto.setDescrizione(categoria.getDescrCat());
            out.getCategorie().add(dto);
        }
        return out;
    }

    @Override
    public ListaTipiDocumentiOutput listTipiDocumenti(long idApplicativo, long docatId) {
        List<TpDotipTDocumento> tipiDoc = tipoDocumentoRepository.findAll(DotipSpecifications.getTipoDocumentoByCategoria(idApplicativo, docatId));
        ListaTipiDocumentiOutput out = new ListaTipiDocumentiOutput();
        out.setTipiDocumenti(new ArrayList<>());
        for (TpDotipTDocumento tipo : tipiDoc) {
            CategoriaDto dto = new CategoriaDto();
            dto.setCodice(tipo.getCod());
            dto.setDescrizione(tipo.getDescrTip());
            out.getTipiDocumenti().add(dto);
        }
        return out;
    }

    @Override
    public TpDotipTDocumentoDto getByCode(String code) {
        TpDotipTDocumento dotip = tipoDocumentoRepository.findByCod(code);
        return tpDotipTDocumentoMapper.toDto(dotip);
    }

    @Override
    public TpDotipTDocumento getEntityByCode(String code) {
        var entity = Optional.of(tipoDocumentoRepository.findByCod(code)).orElseThrow(
                ()-> {
                    log.error("It is impossible to find a document type with code: " + code);
                    throw new EntityNotFoundException(StatusEnum.CANNOT_FIND_DOCUMENT_TYPE.getNameMessage());
                }
        );
        return entity;
    }

    @Override
    public ListaCategoriaOutput listSpecificCategorie(List<Long> idCategories) {
        List<TpDocatCDocumento> categorie = categoriaRepository.findByDataAfterAndDataInizBeforeAndInListIdsOrderByAcrCat(new Date(), new Date(), idCategories);
        ListaCategoriaOutput out = new ListaCategoriaOutput();
        out.setCategorie(new ArrayList<>());
        for (TpDocatCDocumento categoria : categorie) {
            CategoriaDto dto = new CategoriaDto();
            dto.setCodice(String.valueOf(categoria.getId()));
            dto.setDescrizione(categoria.getDescrCat());
            out.getCategorie().add(dto);
        }
        return out;
    }


}
