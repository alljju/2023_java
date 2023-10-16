package Generic;

class Box2<T>{
	private T t;
	
	//Getter 메소드
	public T get() {
		return t;
	}
	
	//Setter메소드
	public void set(T t) {
		this.t=t;
	}
}

public class GenericMe {
	
	//제네릭 메소드
	public static <T> Box2<T> boxing(T t){
		Box2<T> box = new Box2<T>(); //타입 파라미터 T정의
		box.set(t);
		return box;
	}
	public static void main(String[] args) {
		// 제네릭 메소드 호출
		Box2<Integer> box1 = boxing(100); //Integer로 대체
		int intValue = box1.get();
		System.out.println(intValue);
		
		// 제네릭 메소드 호출
		Box2<String> box2 = boxing("안녕"); //String으로 대체
		String strValue = box2.get();
		System.out.println(strValue);
	}
}
