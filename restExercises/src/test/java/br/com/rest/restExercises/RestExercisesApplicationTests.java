package br.com.rest.restExercises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rest.restExercises.dto.TimeZoneDTO;

/**
 * @author Luizg
 * 6) Rest Client - World Clock 
 */
@SpringBootTest
class RestExercisesApplicationTests {

	@Test
	void consumerAPI() {
		RestTemplate template = new RestTemplate();
        //montando a URI
		UriComponents uri = UriComponentsBuilder.newInstance()
		.scheme("http")
		.host("worldclockapi.com/api/json/utc/now")
		.build();
		
		ResponseEntity<TimeZoneDTO> entity = template.getForEntity(uri.toString(), TimeZoneDTO.class );
		//data ao consumir a api
		System.out.println("Time Zone UTC: " + entity.getBody().getCurrentDateTime());
		
		String dateTimeUTC  = entity.getBody().getCurrentDateTime();
		//Retirando T e Z, pois estava dando erro de parse
		dateTimeUTC = dateTimeUTC.replace( "T" , " " ) 
								 .replace( "Z" , "" );
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC-3"));
		try {
			Date local = sdf.parse(dateTimeUTC);
			
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
	        String dateTimeLocal = dateFormat.format(local);
	        System.out.println("Time Zone Local: " + dateTimeLocal);		
			
			
		} catch (ParseException e) {
			System.out.println("ERROR");
		}
	}
}
