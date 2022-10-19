package kz.client.forWeatherApi.WeatherRest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       RestTemplate restTemplate = new RestTemplate();
       
       final String URL = "http://localhost:8084/measurements/add"; 
      
       Map <String,Object> jsonData = new HashMap<>();
       
       final String sensorName = "sensor-3"; // Название сенсора куда будут отправлены полученные значение
       
       Random rd = new Random();
       
       for(int i=0;i<10;++i) {
    	   
    	  jsonData.put("value",Math.random()*(100-(-100))+(-100));
    	  
    	  jsonData.put("raining",rd.nextBoolean());//TODOs
    	  
    	  jsonData.put("sensor",Map.of("title",sensorName));
    	  
    	  HttpEntity<Map<String,Object>> request = new HttpEntity<>(jsonData);
    	  
    	  try {
          restTemplate.postForObject(URL, request, String.class);
    	  }
    	  catch(HttpClientErrorException e) {
    		  System.out.println(e.getMessage());
    	  }
          jsonData.clear();
      }
      // HttpEntity<Map<String,String>> request = new HttpEntity<>(jsonData);
       //restTemplate.postForObject(URL, request, String.class);
     
    }
}
