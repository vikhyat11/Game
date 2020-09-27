package com.example.medical.util;

import com.example.medical.dto.Board;

public class ValidateWinner {
	public boolean checkRow(char[][] b,char col,int r,int c)
	{
		int count=0;
		for(int i=c-3;i<=c;i++)
		{
			count=0;
			if(i<0)
				continue;
			for(int j=i;j<(i+4);j++)
			{
				if(j>6)
					break;
				if(b[r][j]!=col)
					break;
				count++;
				if(count==4)
					return true;
			}
		}
		return false;
	}
	public boolean checkColumn(char[][] b,char col,int r,int c)
	{
		int count=0;
		for(int i=r-3;i<=r;i++)
		{
			count=0;
			if(i<0)
				continue;
			for(int j=i;j<(i+4);j++)
			{
				if(j>5)
					break;
				if(b[j][c]!=col)
					break;
				count++;
				if(count==4)
					return true;
			}
		}
		return false;
	}
	public boolean checkDiagonal(char[][] b,char col,int r,int c)
	{
		int count=0;
		for(int i=r-3,j=c-3;i<=r && j<=c;i++,j++)
		{
			count=0;
			if(i<0 || j<0)
				continue;
			for(int k=i,l=j;k<(i+4) && l<(j+4);k++,l++)
			{
				if(k>5 || l>6)
					break;
				if(b[k][l]!=col)
					break;
				count++;
				if(count==4)
					return true;
			}
		}
		return false;
	}
}
