package ch01;

public class MainTest2 {
	
	public static void main(String[] args) {
		
		// 제네릭이란?
		// 무엇이든 담을 수 있는 프로그래밍 -> ver 5.0;
		
		// 사용하는 이유
		// 우리가 변수를 사용한다고 하면 항상 자료형을 먼저 지정하게 되어 있다.
		
		// 변수의 이름이 같고, 하지만 데이터 타입 (자료형)이 달라야 한다면 --> 제네릭 문법을 생각하자.
		
		ThreeDPrinter dPrinter1 = new ThreeDPrinter();
		dPrinter1.setMaterial(new Plastic());
		System.out.println(dPrinter1.material.toString());
		
		// 위 ThreeDPrinter 한계는 재료가 플라스틱에 종속 되어었다.
		// 하지만 사용자 입장에서 재료를 파우더로 변경한다면
		// 코드에 수정이나 새로운 클래스가 필요하다.
		
		
	} // end of main

} // end of class
