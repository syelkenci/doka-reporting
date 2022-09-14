package com.doka.dokareporting.commons;

import java.util.Objects;

public class ObjectUtils {
    private ObjectUtils() {
    }

    public static boolean isAnyNull(Object... args) {
        Object[] var1 = args;
        int var2 = args.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Object object = var1[var3];
            if (Objects.isNull(object)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isAllNull(Object... args) {
        Object[] var1 = args;
        int var2 = args.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Object object = var1[var3];
            if (Objects.nonNull(object)) {
                return false;
            }
        }

        return true;
    }
}
