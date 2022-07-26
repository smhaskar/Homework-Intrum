package StepDefinition;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.List;
import java.util.Map;


import org.apache.commons.io.IOUtils;
import org.openqa.selenium.remote.http.HttpResponse;

import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import io.cucumber.java.en.And;

public class ConvertCSVtoJson {
	
    public static void main(String[] args) throws IOException {
    	FileReader input = new FileReader("testdata//sample1.csv");
        
           CsvSchema csv = CsvSchema.emptySchema().withHeader();
           CsvMapper csvMapper = new CsvMapper();
           MappingIterator<Map<?, ?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(input);
           List<Map<?, ?>> list = mappingIterator.readAll();
           ObjectMapper mapper=new ObjectMapper();
   
          String arrayToJson = mapper.writeValueAsString(list);
          System.out.println(arrayToJson);  
          FileOutputStream fos=new FileOutputStream("output.txt");
          ObjectOutputStream oos=new ObjectOutputStream(fos);
          oos.writeObject(arrayToJson);
          oos.close();   
          String json="{\"id\":12345,\"firstName\":\"s\",\"lastName\":\"m\",\"email\":\"sm@emailIntrum.lv\",\"companyId\":1234567}";
          URL url =new URL("http://intrumhomework.mocklab.io/v1/contact");
          HttpURLConnection conn= (HttpURLConnection) url.openConnection();
          conn.setDoOutput(true);
          conn.setRequestMethod("POST");
          conn.setRequestProperty("Content-Type","application/json");
          conn.connect();
          final DataOutputStream os=new DataOutputStream(conn.getOutputStream());
          os.write(json.getBytes("UTF-8"));
          os.flush();
          os.close();
          
          InputStream in= new BufferedInputStream(conn.getInputStream());
          String result=IOUtils.toString(in,"UTF-8");
          
          System.out.println(result);
          in.close();
          conn.disconnect();
               	}          
    }

           



