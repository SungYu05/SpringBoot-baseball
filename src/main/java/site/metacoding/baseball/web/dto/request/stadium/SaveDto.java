package site.metacoding.baseball.web.dto.request.stadium;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.baseball.domain.stadium.Stadium;

@Setter
@Getter
public class SaveDto {
	private String stadiumName;
	
	public Stadium toEntity(String stadiumName) {
		Stadium stadium = new Stadium(this.stadiumName);
		return stadium;
	}
}
