package ex2_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {

	public static void main(String[] args) {
		System.out.println("Main시작");
		
		String configLocation = "classpath:applicationContext.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		System.out.println("Application Context 컨테이너 생성 완료");
		
		OperatorBean operator = ctx.getBean("operatorBean",OperatorBean.class);
		int value = operator.doOperate();
		System.out.println("Plus 결과:" + value);
		
		OperatorBean operator2 = ctx.getBean("operatorBean2",OperatorBean.class);
		int value2 = operator2.doOperate();
		System.out.println("Minus 결과:" + value2);

		System.out.println("Main종료");
	}

}
