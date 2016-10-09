package jms;

import javax.jms.Destination;
import org.springframework.jms.core.JmsTemplate;
import spring.SpringBean;

public class MessageSender{
	
	/**获取注册到spring的jms实现容器对象*/
	private static JmsTemplate jms_container = (JmsTemplate) SpringBean.getBean("jmsTemplate");
	/**获取注册到spring的activeMQ的客户端调用对象*/
	private static Destination activeMQ_cache = (Destination) SpringBean.getBean("messageQueue");
	
	public static void main(String[] args) throws Exception{
		System.out.println("发送消息至messageQueue中...");
        for (int i = 1; i < 10; i++) {
        	System.out.println("ping..."+i);
            jms_container.send(activeMQ_cache, new MyMessageCreator(i));
            Thread.sleep(1000);
        }
	}

}
