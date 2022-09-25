package site.metacoding.baseball.web.dto.request.expulsion;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.baseball.domain.expulsion.Expulsion;

@Getter
@Setter
public class SaveDto {
	private Integer playerId;
	private Integer teamId;
	private Integer positionId;
	private Integer reasonId;
	
	public Expulsion toEntity() {
		Expulsion expulsion = new Expulsion(this.playerId, this.teamId, this.positionId, this.reasonId);
		return expulsion;
		}
}
