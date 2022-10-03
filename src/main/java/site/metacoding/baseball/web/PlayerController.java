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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.player.Player;
import site.metacoding.baseball.domain.stadium.Stadium;
import site.metacoding.baseball.domain.team.Team;
import site.metacoding.baseball.service.PlayerService;
import site.metacoding.baseball.service.TeamService;
import site.metacoding.baseball.web.dto.request.player.SaveDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;
import site.metacoding.baseball.web.dto.response.player.PlayerListDto;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final PlayerService playerService;
	
	@PostMapping("/api/player/save")
	public @ResponseBody CMRespDto<?> save(@RequestBody SaveDto saveDto){
		playerService.선수등록하기(saveDto);
		return new CMRespDto<>(1, "선수 등록 완료" , null);
	}
	
	@GetMapping("/player/saveForm")
	public String saveForm(Model model) {
		List<Team> teams = playerService.팀목록보기();
		model.addAttribute("teams", teams);
		return "player/playerSaveForm";
	}
	
	@GetMapping("/player")
	public String playList(Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		model.addAttribute("playerList", playerList);
		return "player/playerList";
	}
	
	@DeleteMapping("/api/player/{id}/delete")
	public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id){
		playerService.선수삭제하기(id);
		return new CMRespDto<>(1, "선수 삭제 완료", null);
	}
}
