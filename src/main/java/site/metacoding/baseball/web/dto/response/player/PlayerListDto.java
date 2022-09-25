package site.metacoding.baseball.web.dto.response.player;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerListDto {
	private Integer id;
	private Integer numbers;
	private String teamName;
	private String positions;
	private String playerName;
	private Timestamp createdAt;
}
