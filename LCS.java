package Algorithm;
//动态规划寻找最长公共字串
public class LCS {
	
	private void printLCS(StringBuffer sb, int i, int j, String s1, int[][] flag) {
		if (i == 0 || j == 0)
			return;
		if (flag[i][j] == 1) {
			printLCS(sb, i-1, j-1, s1, flag);
			sb.append(s1.charAt(i-1));
		} else if (flag[i][j] == 2) {
			printLCS(sb, i-1, j, s1, flag);
		} else {
			printLCS(sb, i, j-1, s1, flag);
		}
	}
	
	public String calculateLCS(String s1, String s2) {
		
		int[][] result = new int[s1.length()+1][s2.length()+1];
		int[][] flag = new int[s1.length()+1][s2.length()+1];
		for (int i = 0; i <= s1.length(); i++) {
			result[i][0] = 0;
		}
		for (int i = 0; i <= s2.length(); i++) {
			result[0][i] = 0;
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					result[i][j] = result[i-1][j-1] + 1;
					flag[i][j] = 1;
				} else if (result[i-1][j] >= result[i][j-1]) {
					result[i][j] = result[i-1][j];
					flag[i][j] = 2;
				} else {
					result[i][j] = result[i][j-1];
					flag[i][j] = 3;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		printLCS(sb, s1.length(), s2.length(), s1, flag);
		String lcs = sb.toString();
		return lcs;
		
	}
	
	
	public static void main(String[] args) {
		String s1="ssssssssssssssssssssssssssssssss";
		String s2="111sssss11ssccssssssss";
		LCS lcs = new LCS();
		System.out.print(lcs.calculateLCS(s1, s2));
	}

}