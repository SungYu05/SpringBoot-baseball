package site.metacoding.baseball.domain.team;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Team {
	
	private Integer id;
	private String teamName;
	private Integer stadiumId;
	private Timestamp createdAt;
	
	public Team(String teamName, Integer stadiumId) {
		this.teamName = teamName;
		this.stadiumId = stadiumId;
	}
	
}
