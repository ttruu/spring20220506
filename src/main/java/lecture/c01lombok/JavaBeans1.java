package lecture.c01lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class JavaBeans1 {
	// ctrl + shift + o
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private int age;
	
}
