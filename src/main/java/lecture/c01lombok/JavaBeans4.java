package lecture.c01lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 파라미터 있는 생성자 만드는 메소드
@NoArgsConstructor // 파라미터 없는 생성자 만드는 메소드
@Data
public class JavaBeans4 {
	private String name;
	private int age;
	
	
}
