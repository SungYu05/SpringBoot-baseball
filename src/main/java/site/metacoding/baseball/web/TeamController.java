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

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.stadium.Stadium;
import site.metacoding.baseball.domain.team.Team;
import site.metacoding.baseball.service.TeamService;
import site.metacoding.baseball.web.dto.request.team.SaveDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;
import site.metacoding.baseball.web.dto.response.team.TeamListDto;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	
	@PostMapping("/api/team/save")
	public @ResponseBody CMRespDto<?> save(@RequestBody SaveDto saveDto) {
		teamService.팀등록하기(saveDto);
		return new CMRespDto<>(1, "팀 등록 완료", null);
	}
	
	@GetMapping("/team/saveForm")
	public String savaForm(Model model) {
		List<Stadium> stadiums = teamService.구장목록();
		model.addAttribute("stadiums", stadiums);
		return "team/teamSaveForm";
	}
	
	@GetMapping("/team")
	public String teamList(Model model) {
		List<TeamListDto> teamList = teamService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return "team/teamList";
	}

	
	@DeleteMapping("/api/team/{id}/delete")
	public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id) {
		teamService.팀삭제하기(id);
		return new CMRespDto<>(1, "팀 삭제 완료", null);	
	}

}
