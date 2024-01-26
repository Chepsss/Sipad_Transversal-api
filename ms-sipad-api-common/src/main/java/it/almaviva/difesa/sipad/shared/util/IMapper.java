package it.almaviva.difesa.sipad.shared.util;

import java.util.List;

public interface IMapper<D, E> {
    E toEntity(D dto);
    D toDto(E entity);
    List <E> toEntity(List<D> dtoList);
    List <D> toDto ( List<E> entityList );
}