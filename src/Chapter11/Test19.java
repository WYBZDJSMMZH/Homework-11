package Chapter11;

import java.util.Scanner;

public class Test19 {
	static int []a = new int[100];
	static int []v = new int[100];
	static int ans = 0;
	static int []Ans = new int[100];
	static int []k = new int[100];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 1;i<=n;i++)
			a[i] = input.nextInt();
		ans = n;
		dfs(1,n,1);
		System.out.println(ans);
		for(int i = 1; i<=ans; i++) {
			System.out.print("container " + i + "container with");
			for(int j = 1;j<=n;j++) {
				if(Ans[j] == i)
					System.out.print(" " + a[j]);
			}
			System.out.println();

		}
	}
	public static void dfs(int now,int n,int sum) {
		if(sum >= ans)
		if(now > n) {
			if(sum<ans) {
				ans = sum;
				for(int i = 1;i<=n;i++)
					Ans[i] = v[i];
			}
		}
		for(int i = 1;i<=sum;i++) {
			if(k[i] + a[now] <= 10) {
				v[now] = i;
				k[i] += a[now];
				dfs(now+1, n, sum);
				v[now] = 0;
				k[i] -= a[now];
			}
		}
		v[now] = sum +1;
		k[sum + 1]= a[now];
		dfs(now+1,n,sum+1);
	}
}
