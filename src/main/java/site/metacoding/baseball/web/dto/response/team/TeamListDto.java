package site.metacoding.baseball.web.dto.response.team;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamListDto {
	private Integer id;
	private Integer numbers;
	private String stadiumName;
	private String teamName;
	private Timestamp createdAt;
}