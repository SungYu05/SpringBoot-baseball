package site.metacoding.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.player.Player;
import site.metacoding.baseball.domain.player.PlayerDao;
import site.metacoding.baseball.domain.stadium.Stadium;
import site.metacoding.baseball.domain.stadium.StadiumDao;
import site.metacoding.baseball.domain.team.Team;
import site.metacoding.baseball.domain.team.TeamDao;
import site.metacoding.baseball.web.dto.request.player.SaveDto;
import site.metacoding.baseball.web.dto.response.player.PlayerListDto;
import site.metacoding.baseball.web.dto.response.team.TeamListDto;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final StadiumDao stadiumDao;
	private final TeamDao teamDao;
	private final PlayerDao playerDao;
	
	public void 선수등록하기(SaveDto saveDto) {
		Player player = saveDto.toEntity(saveDto.getPlayerName(), saveDto.getTeamId(), saveDto.getPositions());
		playerDao.insert(player);
	}
	
	public List<Player> 선수목록보기(){
		return playerDao.findByPosition();
	}
	
	public List<Stadium> 구장목록(){
		return stadiumDao.findByTeam();
	}
	
	public List<Team> 팀목록보기() {
		return teamDao.findByPlayer();
	}
	
	public void 선수삭제하기(Integer id) {
		playerDao.deleteById(id);
	}

}
