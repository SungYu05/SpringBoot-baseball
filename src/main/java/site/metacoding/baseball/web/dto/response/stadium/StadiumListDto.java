package site.metacoding.baseball.web.dto.response.stadium;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StadiumListDto {
	private Integer id;
	private Integer numbers;
	private String stadiumName;
	private Timestamp createdAt;

}
