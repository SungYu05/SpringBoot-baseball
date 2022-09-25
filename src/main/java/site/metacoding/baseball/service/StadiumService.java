package site.metacoding.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.stadium.Stadium;
import site.metacoding.baseball.domain.stadium.StadiumDao;
import site.metacoding.baseball.web.dto.request.stadium.SaveDto;
import site.metacoding.baseball.web.dto.response.stadium.StadiumListDto;
import site.metacoding.baseball.web.dto.response.team.TeamListDto;

@RequiredArgsConstructor
@Service
public class StadiumService {
	
	private final StadiumDao stadiumDao;
	
	public void 야구장등록하기(SaveDto saveDto) {
		Stadium stadium = saveDto.toEntity(saveDto.getStadiumName());
		stadiumDao.insert(stadium);
	}
	
	public List<StadiumListDto> 야구장목록보기() {
		return stadiumDao.findAll();
	}
	
	public void 야구장삭제하기(Integer id) {
		stadiumDao.deleteById(id);
	}
}
