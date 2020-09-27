package com.example.medical.ctrl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medical.dto.Start;
import com.example.medical.dto.Vals;
import com.example.medical.service.GameService;

@RestController
@RequestMapping("/play")
public class MedController
{
	@Autowired
	GameService gameService;
	
	@PostMapping(path="/start",consumes="application/json")
	public String gamestart(@RequestBody Start start)
	{
		return gameService.gameReady(start.getSt());
	}
	@PostMapping(path="/column",consumes="application/json")
	public String getCol(@RequestBody Vals val)
	{
		return gameService.getPos(val.getColumn());
	}
	@GetMapping(path="/moves")
	public ArrayList<String> getMoves()
	{
		return gameService.getMoves();
	}
}
