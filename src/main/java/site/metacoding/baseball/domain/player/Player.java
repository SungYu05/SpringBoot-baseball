package site.metacoding.baseball.domain.player;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {
	private Integer id;
	private String playerName;
	private Integer teamId;
	private Integer positionId;
	private Timestamp createdAt;
	
	public Player(String playerName, Integer teamId, Integer positionId) {
		this.playerName = playerName;
		this.teamId = teamId;
		this.positionId = positionId;
	}
	
	
}
