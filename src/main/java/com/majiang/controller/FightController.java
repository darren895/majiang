package com.majiang.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.majiang.entity.Fan;
import com.majiang.entity.Fight;
import com.majiang.entity.FightFan;
import com.majiang.entity.Game;
import com.majiang.service.FanService;
import com.majiang.service.FightFanService;
import com.majiang.service.FightService;
import com.majiang.service.GameService;

@Controller
public class FightController {
	
	@Autowired
	private FightService fightService;
	@Autowired
	private GameService gameService;
	@Autowired
	private FanService fanService;
	@Autowired
	private FightFanService fightFanService;
	
	@RequestMapping("/edit_fight")
	public String editFight(@RequestParam("gameId")int gameId, Model model){
		Map<Integer, List<Fan>> fanMap = fanService.getFanMap();
		List<List<Fan>> fanList = fanService.sortFanList(fanMap);
		Game game = this.gameService.getGame(gameId);
		model.addAttribute("game", game);
		model.addAttribute("fanList", fanList);
		return "editFight"; 
	}
	
	@RequestMapping("/edit_fight/{fightId}")
	public String editFight(@RequestParam("gameId")int gameId,@PathVariable("fightId")int fightId,HttpServletRequest request, Model model){
		Fight fight = this.fightService.getFightById(fightId);
		if(fight == null){
			return "redirect:/edit_fight?gameId="+gameId;
		}
		Game game = this.gameService.getGame(gameId);
		Map<Integer, List<Fan>> fanMap = fanService.getFanMap();
		List<List<Fan>> fanList = fanService.sortFanList(fanMap);
		 Map<Integer, Integer> fightFans = this.fightFanService.getFanMapByFight(fightId);
		model.addAttribute("game", game);
		model.addAttribute("fanList", fanList);
		model.addAttribute("game", game);
		model.addAttribute("fightFans", fightFans);
		model.addAttribute("fight", fight);
		if(request.getParameter("error")!= null){
			String errorMessage = (String) request.getSession().getAttribute("errorMessage");
			request.getSession().removeAttribute("errorMessage");
			model.addAttribute("errorMessage", errorMessage);
		}
		return "editFight"; 
	}
	
	@RequestMapping(value="/save_fight",method=RequestMethod.POST)
	public String saveFight(HttpServletRequest request){
		String gameId = request.getParameter("gameId");
		String[] scores = request.getParameterValues("score");
		String winner = request.getParameter("winner");
		String loser = request.getParameter("loser");
		Game game = gameService.getGame(Integer.parseInt(gameId));		

		String fightId = request.getParameter("fightId");
		Fight fight = null;
		if(fightId != null){
			fight = this.fightService.getFightById(Integer.parseInt(fightId));
			this.fightFanService.clearFightFanByFight(Integer.parseInt(fightId));
		}else{
			fight = new Fight();
			fight.fillEmpty();
			fight.setGameId(game.getId());
			this.fightService.insertFight(fight);	
		}
		if(winner== null){
			request.getSession().setAttribute("errorMessage", "请选择胡牌人");
			return "redirect:/edit_fight/"+fight.getId()+"?gameId="+gameId+"&error=1";
		}
		int result = 0;
		List<FightFan> fightFans = new ArrayList<FightFan>();
		StringBuffer sb = new StringBuffer();
		boolean zm = false;
		for (String score : scores) {
			int fanId = Integer.parseInt(score);
			Fan fan = fanService.getFan(fanId);
			String number = request.getParameter("number"+fanId);
			int count = 0;
			try {
				count = Integer.parseInt(number);
			} catch (NumberFormatException e) {
				request.getSession().setAttribute("errorMessage", "数量不能为非数字");
				return "redirect:/edit_fight/"+fight.getId()+"?gameId="+gameId+"&error=1";
			}
			if(count <=0){
				request.getSession().setAttribute("errorMessage", "数量不能为非数字");
				return "redirect:/edit_fight/"+fight.getId()+"?gameId="+gameId+"&error=1";
			}
			result += fan.getScore()*count;
			FightFan fightFan = new FightFan();
			fightFan.setFightId(fight.getId());
			fightFan.setUserId(game.getUserId(winner));
			fightFan.setFanId(fanId);
			for (int i = 0; i < count; i++) {
				fightFans.add(fightFan);	
			}
			sb.append(fan.getName());
			if(count > 1){
				sb.append("×").append(count);
			}
			if(fanId == 12 || fanId == 25 || fanId == 40){
				zm = true;
			}
			sb.append("，");
		}
		if(!zm && loser== null){
			request.getSession().setAttribute("errorMessage", "请选择点炮人");
			return "redirect:/edit_fight/"+fight.getId()+"?gameId="+gameId+"&error=1";
		}
		sb.deleteCharAt(sb.length()-1);
		fight.setScore(sb.toString());
		if(!zm){
			fight.setResult(winner, result);
			fight.setResult(loser, -result);
		}else{
			fight.setEast(-result);
			fight.setWest(-result);
			fight.setNorth(-result);
			fight.setSouth(-result);
			fight.setResult(winner, result*3);
		}
		this.fightService.updateFight(fight);
		for (FightFan fightFan : fightFans) {
			this.fightFanService.insertFightFan(fightFan);
		}
		return "redirect:/edit_game/"+gameId;
	}

}
