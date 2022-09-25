package site.metacoding.baseball.domain.positions;

import java.util.List;

public interface PositionsDao {
	public void insert(Positions positions); // 포지션 등록
	public List<Positions> findAll(); // 포지션 목록 페이지
	public void deleteById(Integer id); // 포지션 지우기
	public Positions findById(Integer id); // 포지션 찾기
	public void update(Positions positions); // 포지션 인적사항 변경
}
