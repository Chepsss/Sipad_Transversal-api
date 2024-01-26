package it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.repository;

import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.entity.TbStoraOrganigrammaAoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganigrammaAooRepository extends GenericRepository<TbStoraOrganigrammaAoo, Long>, GenericSearchRepository<TbStoraOrganigrammaAoo> {

    @Query("select distinct t.denomLiv1 from TbStoraOrganigrammaAoo t  where t.denomLiv1 is not null  order by t.denomLiv1")
    public List<String> denomLiv1();

    @Query("select distinct t.denomLiv2 from TbStoraOrganigrammaAoo t where t.denomLiv1 = ?1 and t.denomLiv2 is not null order by t.denomLiv2")
    List<String> denomLiv2(String liv1);


    @Query("select distinct t.denomLiv3 from TbStoraOrganigrammaAoo t where t.denomLiv1 = ?1 and t.denomLiv2 = ?2 and t.denomLiv3 is not null order by t.denomLiv3")
    List<String> denomLiv3(String liv1, String liv2);


    @Query("select distinct t.denomLiv4 from TbStoraOrganigrammaAoo t " +
            "where t.denomLiv1 = ?1 and t.denomLiv2 = ?2 and t.denomLiv3 = ?3 and t.denomLiv4 is not null order by t.denomLiv4")
    List<String> denomLiv4(String liv1, String liv2, String liv3);


    @Query("select distinct t.denomLiv5 from TbStoraOrganigrammaAoo t " +
            "where t.denomLiv1 = ?1 and t.denomLiv2 = ?2 and t.denomLiv3 = ?3 and t.denomLiv4 = ?4  and t.denomLiv5 is not null order by t.denomLiv5")
    List<String> denomLiv5(String liv1, String liv2, String liv3, String liv4);


    TbStoraOrganigrammaAoo findByCodLoginPk(String loginPk);

    TbStoraOrganigrammaAoo findFirstByIdUo(Long idUo);

}
