package lecture.c07core;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car {
	
	private Engine engine;
	
	/*  @AllArgsConstructor 로 밑에 코드를 대신함
	public Car(Engine engine) {
		this.engine = engine;
	} 
	 */
	
	public void move() {
		engine.action();
		
	}
}
