import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	
	static class Student implements Comparable<Student>{
		String name;
		int korean;
		int english;
		int math;
		
		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
		
		public int compareTo(Student other) {
			if(this.korean - other.korean > 0) {
				return -1;
			}
			else if(this.korean - other.korean < 0){
				return 1;
			}
			else {
				if(this.english - other.english > 0) {
					return 1;
				}
				else if(this.english - other.english < 0) {
					return -1;
				}
				else {
					if(this.math - other.math > 0) {
						return -1;
					}
					else if(this.math - other.math < 0) {
						return 1;
					}
					else {
						return this.name.compareTo(other.name);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		ArrayList<Student> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			list.add(new Student(name, korean, english, math));
		}
		
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).name);
		}
	
	}
}
