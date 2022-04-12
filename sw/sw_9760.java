package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_9760 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] cards=new String[5];
			String ans="";
			int [] suits = new int[4], ranks = new int [15];
			for(int i=0;i<5;i++) {
				cards[i]=st.nextToken();
				if(cards[i].charAt(0)=='S')
					suits[0]++;
				else if(cards[i].charAt(0)=='D')
					suits[1]++;
				else if(cards[i].charAt(0)=='H')
					suits[2]++;
				else if(cards[i].charAt(0)=='C')
					suits[3]++;
				if(cards[i].charAt(1) =='A') {
					ranks[1]++;
					ranks[14]++;
				}
				else if('2'<=cards[i].charAt(1) &&cards[i].charAt(1)<='9') 
					ranks[cards[i].charAt(1)-'0']++;
				else if(cards[i].charAt(1) =='T')
					ranks[10]++;
				else if(cards[i].charAt(1) =='J')
					ranks[11]++;
				else if(cards[i].charAt(1) =='Q')
					ranks[12]++;
				else if(cards[i].charAt(1) =='K')
					ranks[13]++;
			}
			ans = Print(suits, ranks);
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	public static String Print(int[] suits, int[] ranks) {
		boolean isFlush = false, isStright=false;
		for(int i=0;i<4;i++)
			if(suits[i]==5)
				isFlush=true;
		for(int i=1,j;i<11;i++) {
			for(j=0;j<5;j++)
				if(ranks[i+j]!=1)
					break;
			if(j==5)
				isStright=true;
		}
		if(isFlush && isStright)
			return "Straight Flush";
			
		boolean isFull2=false, isFull3=false;
		int cnt2=0;
		for(int i=1;i<14;i++) {
			if(ranks[i]==4)
				return "Four of a Kind";
			else if(ranks[i]==3)
				isFull3=true;
			else if(ranks[i]==2) {
				isFull2=true;
				cnt2++;
			}
		}
		if(isFull2 && isFull3)
			return "Full House";
		if(isFlush)
			return "Flush";
		if(isStright)
			return "Straight";
		if(isFull3)
			return "Three of a kind";
		if(isFull2 && cnt2==2)
			return "Two pair";
		if(isFull2)
			return "One pair";
		return "High card";
	}
}