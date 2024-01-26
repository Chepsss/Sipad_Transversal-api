package it.almaviva.difesa.sipad.aadba.dsctpcatmilit.repository;

import it.almaviva.difesa.sipad.aadba.dsctpcatmilit.entity.TpDsctpCatmilit;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.repository.specification.GenericSearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TpDsctpCatmilitRepository extends GenericRepository<TpDsctpCatmilit, Long>, GenericSearchRepository<TpDsctpCatmilit> {

    List<TpDsctpCatmilit> findAllByOrderByDsctpAcrCatmilitAsc();

    @Query( "select c from TpDsctpCatmilit c where c.id in :ids" )
    List<TpDsctpCatmilit> findTpDsctpCatmilitByIdIs(@Param("ids") Set<Long> id);

}
