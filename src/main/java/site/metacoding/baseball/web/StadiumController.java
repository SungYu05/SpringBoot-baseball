package site.metacoding.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.stadium.Stadium;
import site.metacoding.baseball.service.StadiumService;
import site.metacoding.baseball.web.dto.request.stadium.SaveDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;
import site.metacoding.baseball.web.dto.response.stadium.StadiumListDto;
import site.metacoding.baseball.web.dto.response.team.TeamListDto;

@RequiredArgsConstructor
@Controller
class StadiumController {
	
	private final StadiumService stadiumService;
	
	@PostMapping("/api/stadium/save")
	public @ResponseBody CMRespDto<?> save(@RequestBody SaveDto saveDto) {
		stadiumService.야구장등록하기(saveDto);
		return new CMRespDto<>(1, "구장 등록 완료", null);
	}
	
	@GetMapping("/stadium/saveForm")
	public String saveForm() {
		return "stadium/stadiumSaveForm";
	}
		
	@GetMapping("/stadium")
	public String stadiumList(Model model) {
		List<StadiumListDto> stadiumList = stadiumService.야구장목록보기();
		model.addAttribute("stadiumList", stadiumList);
		return "stadium/stadiumList";
	}
		
	@DeleteMapping("/api/stadium/{id}/delete")
	public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id) {
		stadiumService.야구장삭제하기(id);
		return new CMRespDto<>(1, "구장 삭제 완료", null);
	}


}
