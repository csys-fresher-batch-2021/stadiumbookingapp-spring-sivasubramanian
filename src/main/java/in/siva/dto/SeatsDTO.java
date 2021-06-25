package in.siva.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SeatsDTO {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate matchDate;
	private String stadiumName;
}
