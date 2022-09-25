package site.metacoding.baseball.domain.player;

import java.util.List;

import site.metacoding.baseball.web.dto.response.player.PlayerListDto;

public interface PlayerDao {
	public void insert(Player player); // 선수등록
	public List<Player> findByPosition(); // 선수목록
	public List<PlayerListDto>findAll(); // 선수+포지션
	public void deleteById(Integer id); // 선수 삭제	
	public Player findById(Integer id); // 선수찾기
	public void update(Player player); // 선수 인적사항 변경
}
