package study;

public class P단어변환 {
	/**
	 * 시작 단어와 타겟 단어가 존재한다. 시작 단어에서 타겟 단어로 만드려고 하는데 한 번에 한 개의 알파벳만 변경 가능하다. words에 있는
	 * 단어로만 변환이 가능하다.
	 * 
	 * @param args
	 */
	static String begin = "hit";
	static String target = "cog";
	static String[] words = { "hot", "dot", "dog", "lot", "log"};
	static int N;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited = new boolean[words.length];

	public static void main(String[] args) {
		N = begin.length();

		dfs(begin, 0);
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(min);
	}

	public static void dfs(String start, int count) {
		if (start.equals(target)) {
			min = Math.min(min, count);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (changable(start, words[i])) {
				// start가 words[i]로 바뀔 수 있다면 바꾸자
				if(!visited[i]) {
					visited[i] = true;
					dfs(words[i], count + 1);
					visited[i] = false;
				}
			}
		}
		
		return;
	}

	public static boolean changable(String start, String dest) {
		int cnt = 0;
		for (int j = 0; j < N; j++) {
			if (start.charAt(j) == dest.charAt(j)) {
				cnt++;
			}
		}
		if (cnt == N - 1) {
			return true;
		}
		return false;
	}

}
