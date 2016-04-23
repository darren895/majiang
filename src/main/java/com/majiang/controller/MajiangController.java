package com.majiang.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.majiang.entity.Fight;
import com.majiang.entity.Game;
import com.majiang.service.FightService;
import com.majiang.service.GameService;

@Controller
public class MajiangController {
	
	@Autowired
	private GameService gameService;

	@Autowired
	private FightService fightService;
	
	private final int pageSize = 10;
	
	@RequestMapping("/start")
	public String start(){
		return "start";
	}
	
	@RequestMapping("/save_name")
	public String saveName(@ModelAttribute("game")Game game){
		game.setStartTime(new Date());
		gameService.saveGame(game);
		if(game.getId()>0){
			return "redirect:/edit_game/"+game.getId();
		}else{
			return "404";
		} 
	}
	
	@RequestMapping("/edit_game/{id}")
	public String editGame(@PathVariable("id")int id,Model model){
		Game game = gameService.getGame(id);
		if(game == null){
			return "404";
		}
		model.addAttribute("game", game);
		List<Fight> fights = this.fightService.getFightByGameId(game.getId());
		model.addAttribute("fightList", fights);
		Map<String, Integer> scoreMap = fightService.getScoreMap(game.getId());
		model.addAttribute("scoreMap", scoreMap);
		return "editGame";
	}
	
	@ResponseBody
	@RequestMapping(value="/fights/{id}",method=RequestMethod.GET)
	public List<Fight> getFights(@PathVariable("id")int id){
		List<Fight> fights= this.fightService.getFightByGameId(id);
		if (fights == null ||fights.isEmpty()){
			return Collections.EMPTY_LIST;
		}else{
			return fights;
		}
	}
	@ResponseBody
	@RequestMapping(value="/games/{page}",method=RequestMethod.GET)
	public List<Game> getGames(@PathVariable("page")int page){
		List<Game> games = this.gameService.getGames(page, pageSize);
		if(games==null){
			return Collections.EMPTY_LIST;
		}else{
			return games;
		}
	}
	
	@RequestMapping("/viewgames")
	public String viewGames(){
		return "viewGames";
	}
}
