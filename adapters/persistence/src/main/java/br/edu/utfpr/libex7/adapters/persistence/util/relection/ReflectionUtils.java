package br.edu.utfpr.libex7.adapters.persistence.util.relection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtils {

    @SuppressWarnings("unchecked")
	public static List<Field> getFields(Class<?> clazz, Class<? extends Annotation>... annotationClasses){
        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        List<Class<? extends Annotation>> annotations = Arrays.asList(annotationClasses); 
        List<Field> fieldAnnotations = new LinkedList<>();
        for(Class<? extends Annotation> annotationClass : annotations) {
        	fieldAnnotations.addAll(fields.stream()
                    .filter(f -> f.isAnnotationPresent(annotationClass))
                    .collect(Collectors.toList()));
        }
        return fieldAnnotations;          
    }

    public static void updateField(Field field, Object object, Object fieldValue){
        try {
            field.setAccessible(true);
            field.set(object, fieldValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao modificar valor do atributo " + field.getName(), e);
        }
    }
}