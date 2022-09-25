package site.metacoding.baseball.domain.expulsion;

import java.sql.Timestamp;

public class Expulsion {
	private Integer id;
	private Integer playerId;
	private Integer teamId;
	private Integer positionId;
	private Integer reasonId;
	private Timestamp createdAt;
	
	public Expulsion(Integer playerId, Integer teamId, Integer positionId, Integer reasonId) {
		this.playerId = playerId;
		this.teamId = teamId;
		this.positionId = positionId;
		this.reasonId = reasonId;
	}
	
	
}
