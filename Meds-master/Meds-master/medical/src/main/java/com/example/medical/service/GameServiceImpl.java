package com.example.medical.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.medical.dto.Board;
import com.example.medical.util.ValidateWinner;


@Service
public class GameServiceImpl implements GameService{

	ValidateWinner val=new ValidateWinner();
	Board coins;
	boolean check=false;
	int rowrec[];
	char ch='Y';
	ArrayList<String> moves;
	@Override
	public String gameReady(String s) {
		// TODO Auto-generated method stub
		if(s.equalsIgnoreCase("start"))
		{
			moves=new ArrayList<>();
			coins=new Board();
			check=true;
			rowrec=new int[7];
			return "Ready";
		}
		return "Not Ready";
	}
	@Override
	public String getPos(int c) {
		// TODO Auto-generated method stub
		if(!check)
			return "Game Not Started";
		int r=rowrec[c]++;
		if(r>5 || c<0 || c>6)
		{
			if(ch=='Y')
			ch='R';
			else
				ch='Y';
			return "Invalid";
		}
		else {
			moves.add(ch+" added to row "+r+" column "+c);
			Board.b[r][c]=ch;
			if(val.checkColumn(Board.b, ch , r, c) || val.checkDiagonal(Board.b, ch , r, c) || val.checkRow(Board.b, ch , r, c))
			{
				if(ch=='Y')
					return "Yellow Wins";
				return "Red Wins";
			}
		}
		if(ch=='Y')
		ch='R';
		else
			ch='Y';
		return "Valid";
	}
	@Override
	public ArrayList<String> getMoves() {
		// TODO Auto-generated method stub
		return moves;
	}
}
