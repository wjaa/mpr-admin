package br.com.mpr.admin.utils;

import br.com.mpr.admin.annotation.IgnoreCopy;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * Created by wagner on 9/5/18.
 */
public class BeanUtils {

    public static void copyPropertiesIgnoreAnnotation(Object source, Object target){
        String [] ignoreProps = getPropertyIgnoreAnnotation(target);
        org.springframework.beans.BeanUtils.copyProperties(source,target,ignoreProps);
    }

    public static String[] getPropertyIgnoreAnnotation(Object source) {
        return Stream.of(source.getClass().getDeclaredFields())
                .map(Field::getName)
                .filter(propertyName -> {
                    try {
                        return source.getClass().getDeclaredField(propertyName).isAnnotationPresent(IgnoreCopy.class);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .toArray(String[]::new);
    }

}
