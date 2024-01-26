package it.almaviva.difesa.sipad.shared.utils;


import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.repository.GenericRepository;
import it.almaviva.difesa.sipad.shared.util.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Slf4j
public class LambdaUtils {

    /***
     * Method to search all generic entities into generic repository
     * @param repository specific repository (child of GenericRepository)
     * @param findAllMethod signature of method to find all entities
     * @param <E>
     * @param <I>
     * @param <R>
     * @return
     */
    public static <E extends GenericEntity, I extends Serializable, R extends GenericRepository<E, I>> List<E> findAll(R repository, Function<R, List<E>> findAllMethod) {
        List<E> entityList = findAllMethod.apply(repository);
        if (CollectionUtils.isEmpty(entityList)) {
            log.info("There are not any entities into DB");
            throw new EntityNotFoundException(StatusEnum.ENTITY_NOT_FINDABLE_PARAMETER.getNameMessage());
        }

        return entityList;
    }

    /***
     * Method to search if one generic entity exists into generic repository
     * if not it throws an exception
     * @param repository specific repository (child of GenericRepository)
     * @param findByParameterMethod signature of method to find one entity
     * @param <E> parametric type
     * @param <I> parametric type
     * @param <R> parametric type
     * @return
     */
    public static <E extends GenericEntity, I extends Serializable, R extends GenericRepository<E, I>> E findByOneOrMoreParameters(R repository, Function<R, Optional<E>> findByParameterMethod) {
        Optional<E> entityOptional = findByParameterMethod.apply(repository);
        if (entityOptional.isEmpty()) {
            log.error("Cannot find any entity with the given parameter");
            throw new EntityNotFoundException(StatusEnum.ENTITY_NOT_FINDABLE_PARAMETER.getNameMessage());
        }

        return entityOptional.get();
    }

    /***
     * Method to get boolean about the existence of generic entity into generic repository
     * @param repository specific repository (child of GenericRepository)
     * @param findByParameterMethod signature of method to find one entity
     * @param <E> parametric type
     * @param <I> parametric type
     * @param <R> parametric type
     * @return
     */
    public static <E extends GenericEntity, I extends Serializable, R extends GenericRepository<E, I>> boolean foundByOneOrMoreParameters(R repository, Function<R, Optional<E>> findByParameterMethod) {
        Optional<E> entityOptional = findByParameterMethod.apply(repository);
        return entityOptional.isPresent();
    }


    /***
     * Method to search all ids of generic entities into generic repository
     * @param repository specific repository (child of GenericRepository)
     * @param findAllMethod signature of method to find all ids of generic entities
     * @param <N> parametric type
     * @param <E> parametric type
     * @param <I> parametric type
     * @param <R> parametric type
     * @return
     */
    public static <N extends Number, E extends GenericEntity, I extends Serializable, R extends GenericRepository<E, I>> List<N> findAllIds(R repository, Function<R, List<N>> findAllMethod) {
        return findAllMethod.apply(repository);
    }
}
