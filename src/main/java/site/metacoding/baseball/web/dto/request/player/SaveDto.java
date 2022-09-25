package site.metacoding.baseball.web.dto.request.player;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.baseball.domain.player.Player;

@Getter
@Setter
public class SaveDto {
	private String playerName;
	private Integer teamId;
	private String positions ;
	
	public Player toEntity(String playerName, Integer teamId, String positions) {
		Player player = new Player(this.playerName, this.teamId, this.positions);
		return player;
	}

	
}
