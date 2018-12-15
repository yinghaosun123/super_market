package com.yjw.supermarket.framework.utils;


import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

/**
 * Provides a helper that locates the declarated generics type of a class.
 *
 */
public class GenericsUtils {
    /**
     * Locates the first generic declaration on a class.
     *
     * @param clazz The class to introspect
     * @return the first generic declaration, or <code>null</code> if cannot be determined
     */
    @SuppressWarnings("rawtypes")
	public static Class getGenericClass(Class clazz) {
        return GenericsUtils.getGenericClass(clazz, 0);
    }

    /**
     * Locates  generic declaration by index on a class.
     *
     * @param clazz clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     */
    @SuppressWarnings("rawtypes")
    public static Class getGenericClass(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if ((params != null) && (params.length >= (index - 1))) {
                return (Class) params[index];
            }
        }
        return null;
    }
}
