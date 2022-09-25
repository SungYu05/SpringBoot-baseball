package site.metacoding.baseball.domain.expulsion;

import java.util.List;

public interface ExpulsionDao {
	public void insert(Expulsion expulsion); // 퇴출선수 등록
	public List<Expulsion> findAll(); // 퇴출 선수 목록 페이지
	public void deleteById(Integer id); // 퇴출 선수 목록에서 지우기
	public Expulsion findById(Integer id); // 퇴출 선수 찾기
	public void update(Expulsion expulsion); // 퇴출 선수 인적사항 변경
}
