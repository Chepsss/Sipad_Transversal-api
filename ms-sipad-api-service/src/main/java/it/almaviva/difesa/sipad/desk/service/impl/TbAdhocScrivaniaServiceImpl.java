package it.almaviva.difesa.sipad.desk.service.impl;

import it.almaviva.difesa.sipad.aadba.desk.dto.response.TbAdhocScrivaniaDto;
import it.almaviva.difesa.sipad.aadba.desk.entity.TbAdhocScrivania;
import it.almaviva.difesa.sipad.desk.mapper.TbAdhocScrivaniaMapper;
import it.almaviva.difesa.sipad.aadba.desk.repository.TbAdhocScrivaniaRepository;
import it.almaviva.difesa.sipad.desk.service.TbAdhocScrivaniaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TbAdhocScrivaniaServiceImpl implements TbAdhocScrivaniaService {

    @Autowired
    TbAdhocScrivaniaRepository scrivaniaRepository;

    @Autowired
    TbAdhocScrivaniaMapper scrivaniaMapper;

    @Override
    public List<TbAdhocScrivaniaDto> list(String codApp) {
        List<TbAdhocScrivania> all = scrivaniaRepository.findAllByAdhocCodApp(codApp);
        return scrivaniaMapper.toDto(all);
    }

    @Override
    public List<TbAdhocScrivaniaDto> listByCodeAppAndCatPers(String codApp, Long catPers) {
        List<TbAdhocScrivania> list = scrivaniaRepository.getByAdhocCodAppAndAdhocSgctpCatpers(codApp, catPers);
        log.info(">>>>>>>>>>>>>> Size of the list is: {}", list.size());
        return scrivaniaMapper.toDto(list);
    }

    @Override
    public TbAdhocScrivaniaDto getTbAdhocScrivania(String codPk, String codApp) {
        return scrivaniaMapper.toDto(scrivaniaRepository.getTbAdhocScrivaniaByCodPkAndCodApp(codPk, codApp));
    }

}
