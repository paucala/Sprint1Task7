package n3exercici1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainSerializeJson {

	public static void main(String[] args) throws JsonSerializationException {
		ObjecttoJson object = new ObjecttoJson();
		
		ArrayList<Capital> capitals = new ArrayList<Capital>();	
		Capital españa = new Capital ("España", "Madrid");
		Capital portugal = new Capital ("Portugal", "Lisboa");
		Capital frança = new Capital ("França", "París");
		
		capitals.add(españa);
		capitals.add(portugal);
		capitals.add(frança);
		
		String json = "";
		for (Capital cap : capitals) {
			json = object.convertToJson(cap);
			write(object.getPath(cap), json);
		}
		
	}
	//metode per escriure el JSON
	public static void write(String directori, String json) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(directori, true));
			bw.write(json);
			bw.close();
		} catch (IOException e) {
			System.out.println("Buffer problem (Write)");
		}
	}

}
