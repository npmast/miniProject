package myprj.learn08;

public class BeanTest {
	private String name = "hongkildong";
	
	public String getName() {
		return name;
	}
		
	public void SetName(String name) {
		this.name = name;
	}
}

// 관련있는 데이터를 설계 규약에 맞게 작성된 클래스
// - 인자없는 생성자로 구성된다.
// - getter, setter 메서드를 통해 멤버 변수에 접근한다.

//<jsp:useBean />태그 : 자바빈 객체를 생성하거나 참조하기위한 액션 태그.유용하지만 jsp를 단순히 뷰역할로만 사용한다면 쓸일이 없다. --%>
//<jsp:useBean id = "빈이름" class = "자바빈 클래스명" scope = "사용범위" />