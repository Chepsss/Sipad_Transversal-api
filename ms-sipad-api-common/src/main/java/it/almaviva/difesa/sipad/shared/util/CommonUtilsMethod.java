package it.almaviva.difesa.sipad.shared.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

@Slf4j
public class CommonUtilsMethod {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    private CommonUtilsMethod() {}

    public static boolean isNotBlankString(String string) {
        return string != null && !string.trim().isEmpty();
    }

    public static <T> boolean isNotCollectionEmpty(Collection<T> collection) {
        return !CollectionUtils.isEmpty(collection);
    }

    public static String getClassName(Class<?> clazz) {
        String genericClassTypeName = clazz.getTypeName();
        String[] directoriesAndClass = genericClassTypeName.split("\\.");
        return directoriesAndClass[directoriesAndClass.length - 1].toLowerCase();
    }

    public static boolean isValidDateFormat(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            log.warn(e.getMessage());
            return false;
        }

        return true;
    }

    public static String upperCaseTrimValueField(String valueField) {
        return valueField == null ? null : valueField.toUpperCase().trim();
    }
}