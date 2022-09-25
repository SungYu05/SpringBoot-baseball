package site.metacoding.baseball.web.dto.request.team;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.baseball.domain.team.Team;

@Setter
@Getter
public class SaveDto {
	private String teamName;
	private Integer stadiumId;
	
	public Team toEntity(String teamName, Integer stadiumId) {
		Team team = new Team(this.teamName, this.stadiumId);
		return team;
	}
	
}
