package site.metacoding.baseball.domain.stadium;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Stadium {

	private Integer id;
	private String stadiumName;
	private 	Timestamp createdAt;
	
	public Stadium(String stadiumName) {
		this.stadiumName = stadiumName;
	}

}
