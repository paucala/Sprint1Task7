package n3exercici1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjecttoJson {
	
	//metode per contertir un objecte a JSON
	public String convertToJson(Object object) throws JsonSerializationException {
        try {
            checkIfSerializable(object);
            return getJsonString(object);
        } catch (Exception e) {
            throw new JsonSerializationException(e.getMessage());
        }
    }
	
	//checkeig d'exepcions
	private void checkIfSerializable(Object object) throws JsonSerializationException {
	    if (Objects.isNull(object)) {
	        throw new JsonSerializationException("The object to serialize is null");
	    }
	        
	    Class<?> clazz = object.getClass();
	    if (!clazz.isAnnotationPresent(SerializeJson.class)) {
	        throw new JsonSerializationException("The class " 
	          + clazz.getSimpleName() 
	          + " is not annotated with JsonSerializable");
	    }
	}
	
	//pasem la classe a String
	private String getJsonString(Object object) throws Exception {	
	    Class<?> clazz = object.getClass();
	    Map<String, String> jsonElementsMap = new HashMap<>();
	    for (Field field : clazz.getDeclaredFields()) {
	        field.setAccessible(true);
	        if (field.isAnnotationPresent(JsonElement.class)) {
	            jsonElementsMap.put(getKey(field), (String) field.get(object));
	        }
	    }		
	     
	    String jsonString = jsonElementsMap.entrySet()
	        .stream()
	        .map(entry -> "\"" + entry.getKey() + "\":\"" 
	          + entry.getValue() + "\"")
	        .collect(Collectors.joining(","));
	    return "{" + jsonString + "}\n";
	}
	
	//obtenir les key
	private String getKey(Field field) {
		String value = field.getAnnotation(JsonElement.class).key();
		return value.isEmpty() ? field.getName() : value;
	}
	
	//obtenir el path
	public String getPath(Object object) {
		Class<?> clazz = object.getClass();
		return clazz.getAnnotation(SerializeJson.class).path();
	}

}
