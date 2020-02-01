package br.com.rest.restExercises;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.restExercises.model.TimeZoneDTO;

/**
 * @author Luizg
 * 7) Rest Server - World Clock 
 */
@RestController
public class RequestController {
	
	@RequestMapping("/myClock")
	@ResponseBody
	public TimeZoneDTO currentDateTime() {
		TimeZoneDTO timeZoneDTO = new TimeZoneDTO();
		
		// data/hora atual
		LocalDateTime agora = LocalDateTime.now();
		// formatar a data
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
		String dataFormatada = formatterData.format(agora);
		timeZoneDTO.setCurrentDateTime(dataFormatada);
		return timeZoneDTO;

	}

}
