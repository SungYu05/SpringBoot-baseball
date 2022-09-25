package site.metacoding.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.stadium.Stadium;
import site.metacoding.baseball.domain.stadium.StadiumDao;
import site.metacoding.baseball.domain.team.Team;
import site.metacoding.baseball.domain.team.TeamDao;
import site.metacoding.baseball.web.dto.request.team.SaveDto;
import site.metacoding.baseball.web.dto.response.team.TeamListDto;

@RequiredArgsConstructor
@Service
public class TeamService {
	
	private final StadiumDao stadiumDao;
	private final TeamDao teamDao;
	
	public void 팀등록하기(SaveDto saveDto) {
		Team team = saveDto.toEntity(saveDto.getTeamName(), saveDto.getStadiumId());
		teamDao.insert(team);
	}
	
	public List<TeamListDto> 팀목록보기() {
		return teamDao.findAByStadiumName();
	}
	
	public List<Stadium> 구장목록(){
		return stadiumDao.findByTeam();
	}

	public void 팀삭제하기(Integer id) {
		teamDao.deleteById(id);
	}

}
