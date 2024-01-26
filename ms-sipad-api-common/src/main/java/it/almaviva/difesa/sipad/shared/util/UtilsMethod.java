package it.almaviva.difesa.sipad.shared.util;


import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;


@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilsMethod {


    /***
     *
     * @param pageable -
     * @param clazz -
     * @param <E> -
     * @return -
     */
    public static <E extends Sortable> Pageable setSortToPageableIfNecessary(Pageable pageable, Class<?> clazz) {
        if (pageable.getSort().isUnsorted()) {
            Class<E> eClass = (Class<E>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
            E entity = createEntity(eClass);
            Sort sort = entity.getSort() == null ? Sort.unsorted() : entity.getSort();
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        }
        return pageable;
    }


    /***
     *
     * @param clazz -
     * @param <E> -
     * @return -
     */
    private static <E> E createEntity(Class<E> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                 InstantiationException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    /***
     * Method to check specific format data
     * @param dateStr data to check
     * @return -
     */
    public static boolean isValidDateFormat(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(AppConstants.YYYY_MM_DD);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            log.warn(e.getMessage());
            return false;
        }

        return true;
    }


    /***
     * Method to transform string into uppercase without initial and final spaces
     * @param valueField -
     * @return -
     */
    public static String upperCaseTrimValueField(String valueField) {
        return valueField == null ? null : valueField.toUpperCase().trim();
    }

    public static <E extends GenericEntity> Optional<Predicate> addFieldToPredicatesIfNotEmptyOrBlank(Root<E> root,
                                                                                                      CriteriaBuilder criteriaBuilder,
                                                                                                      boolean useLikeCriteria,
                                                                                                      Object value,
                                                                                                      String... fieldName) {
        Predicate predicate = null;
        Path<?> path = root.get(fieldName[0]);
        for (int i = 1; fieldName.length > 1 && i < fieldName.length; i++) {
            path = path.get(fieldName[i]);
        }
        if (CommonUtilsMethod.isNotBlankString((String) value)) {
            if (useLikeCriteria)
                predicate = criteriaBuilder.like(criteriaBuilder.upper((Expression<String>) path), ((String) value).toUpperCase() + "%");
            else
                predicate = criteriaBuilder.equal(criteriaBuilder.upper((Expression<String>) path), ((String) value).toUpperCase());
        } else if (!ObjectUtils.isEmpty(value)) {
            predicate = criteriaBuilder.equal(path, value);
        }
        return Optional.ofNullable(predicate);
    }
}