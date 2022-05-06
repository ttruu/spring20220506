package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// component --> spring bean이 된다
// 언제? class path scanning할때 component가 된다
// class path scanning은 설정파일(xml)에 써주면 쓸수있다
public class Car {
	
	private Engine engine;
	
	@Autowired
	private void setEngine(Engine engine) {
		this.engine = engine;

	}
	
	public void go() {
		engine.action();
	}
}
