package site.metacoding.baseball.domain.team;

import java.util.List;

import site.metacoding.baseball.web.dto.response.team.TeamListDto;

public interface TeamDao {
	public void insert(Team team); // 팀등록
	public List<Team> findByPlayer(); // 선수등록시팀목록
	public List<TeamListDto> findAll(); //팀+구장
	public void deleteById(Integer id); // 팀삭제
	public Team findById(Integer id); // 팀 찾기
	public void update(Team team); // 팀 업데이트
}
