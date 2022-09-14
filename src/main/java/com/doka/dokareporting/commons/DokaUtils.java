package com.doka.dokareporting.commons;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Locale;
import java.util.Objects;

public class DokaUtils {
    private DokaUtils() {
    }

    public static Locale getLocaleFromRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Objects.isNull(requestAttributes) ? DokaConstants.TURKISH_LOCALE : requestAttributes.getRequest().getLocale();
    }

    public static Locale getLocale(String languageCode) {
        return StringUtils.isEmpty(languageCode) ? DokaConstants.TURKISH_LOCALE : new Locale(languageCode);
    }
}
