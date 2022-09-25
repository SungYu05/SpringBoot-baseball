package site.metacoding.baseball.domain.reason;

import java.util.List;

public interface ReasonDao {
	public void insert(Reason reason); // 퇴출이유 등록
	public List<Reason> findAll(); // 퇴출 목록 페이지
	public void deleteById(Integer id); // 퇴출이유 지우기
	public Reason findById(Integer id); // 퇴출이유 찾기
	public void update(Reason reason); // 퇴출이유 변경
}
