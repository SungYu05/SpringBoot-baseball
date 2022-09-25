package site.metacoding.baseball.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.player.Player;
import site.metacoding.baseball.service.PlayerService;
import site.metacoding.baseball.web.dto.request.player.SaveDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final HttpSession session;
	private final PlayerService playerService;
	
	@PostMapping("/api/player/save")
	public @ResponseBody CMRespDto<?> save(@RequestBody SaveDto saveDto){
		playerService.선수등록하기(saveDto);
		return new CMRespDto<>(1, "선수 등록 완료" , null);
	}
	
	@GetMapping("/player/SaveForm")
	public String signForm() {
		return "player/playerSaveForm";
	}
	
	@GetMapping("/player")
	public String playList(Player player) {
		List<Player> playerList = playerService.포지션보기();
		return "player/playerList";
	}
	
	@DeleteMapping("/api/player/{id}/delete")
	public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id){
		playerService.선수삭제하기(id);
		return new CMRespDto<>(1, "선수 삭제 완료", null);
	}
}
