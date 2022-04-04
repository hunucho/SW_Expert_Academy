package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_3307 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int maxlength=0;
			int n=Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] values=new int[n+1];
			for(int i=1;i<=n;i++)
				values[i]=Integer.parseInt(st.nextToken());
			
			int[] arr=new int[n+1];
			for(int i=1;i<=n;i++) {
				arr[i]=1;
				for(int j=1;j<=i-1;j++)
					if(values[j]<values[i] && arr[i]<1+arr[j])
						arr[i]=1+arr[j];
			}
			for(int i=1;i<=n;i++)
				if(maxlength<arr[i])
					maxlength=arr[i];
			System.out.printf("#%d %d\n", test_case, maxlength);
		}
	}
}