package com.example.medical.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public interface GameService
{
	public String gameReady(String s);
	public String getPos(int c);
	public ArrayList<String> getMoves();
}
