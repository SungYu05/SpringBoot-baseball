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
	private String positions ;
	private Timestamp createdAt;
	private boolean expulsion;
	
	public Player(String playerName, Integer teamId, String positions) {
		this.playerName = playerName;
		this.teamId = teamId;
		this.positions = positions;
	}
	
	
}
