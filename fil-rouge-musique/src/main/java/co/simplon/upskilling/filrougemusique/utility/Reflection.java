package co.simplon.upskilling.filrougemusique.utility;

import java.lang.reflect.Field;

public class Reflection {
    public static boolean isFieldName(Class c, String fieldName){
        for(Field f : c.getDeclaredFields()){
            if(f.getName().equals(fieldName)){
                return true;
            }
        }
        return false;
    }
}
