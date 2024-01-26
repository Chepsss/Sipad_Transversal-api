package it.almaviva.difesa.sipad.stoaoo.service.impl;

import it.almaviva.difesa.sipad.aadba.stoaoo.dto.response.AooAutocompleteOut;
import it.almaviva.difesa.sipad.aadba.stoaoo.dto.response.AooOutput;
import it.almaviva.difesa.sipad.aadba.stoaoo.entity.TbStaooAoo;
import it.almaviva.difesa.sipad.aadba.stoaoo.repository.TbStaooAooRepository;
import it.almaviva.difesa.sipad.stoaoo.service.AooService;
import it.almaviva.difesa.sipad.aadba.stoaoo.specifications.TbStaooAooSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AooServiceImpl implements AooService {

    @Autowired
    TbStaooAooRepository aooRepository;


    @Override
    public AooAutocompleteOut list(String filtro, Integer num) {
        if(null == num){
            num = 10;
        }
        Pageable pager = PageRequest.of(0, num);
        Page<TbStaooAoo> aoos = aooRepository.findAll(TbStaooAooSpecifications.listAutocomplete(filtro), pager);
        ArrayList<AooOutput>  result = new ArrayList<>();
        for (TbStaooAoo aoo: aoos){
          result.add(new AooOutput(aoo.getCod(), aoo.getDescrAoo()));
        }
        AooAutocompleteOut out = new AooAutocompleteOut();
        out.setList(result);
        return out;
    }

    @Override
    public TbStaooAoo dettaglio(String cod) {

        TbStaooAoo aoo = aooRepository.findByCod(cod);
        return aoo;
    }
}
