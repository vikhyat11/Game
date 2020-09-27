package com.example.medical.dto;

public class Board {
	public static char b[][];

	public Board()
	{
		this.b=new char[6][7];
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				b[i][j]=' ';
			}
		}
	}
}
