package site.metacoding.baseball.domain.stadium;

import java.util.List;

import site.metacoding.baseball.web.dto.response.stadium.StadiumListDto;

public interface StadiumDao {
	public void insert(Stadium stadium); // 야구장등록
	public List<StadiumListDto> findAll(); // 야구장목록
	public void deleteById(Integer id); // 야구장 삭제
	public List<Stadium> findByTeam(); // 팀등록시 필요한 야구장 목록
	public Stadium findById(Integer id); // 야구장 찾기
	public void update(Stadium stadium); // 야구장 업데이트
}