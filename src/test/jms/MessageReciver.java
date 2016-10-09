package jms;
import javax.jms.Destination;
import javax.jms.TextMessage;
import org.springframework.jms.core.JmsTemplate;
import spring.SpringBean;

public class MessageReciver {
	
	/**获取注册到spring的jms实现容器对象*/
	private static JmsTemplate jms_container = (JmsTemplate) SpringBean.getBean("jmsTemplate");
	/**获取注册到spring的activeMQ的客户端调用对象*/
	private static Destination activeMQ_cache = (Destination) SpringBean.getBean("messageQueue");
	
	 public static void main(String args[]) throws Exception {
		 	System.out.println("获取ActiveMQ中的收到的消息...");
	        while (true) {
	        	TextMessage   msg = (TextMessage) jms_container.receive(activeMQ_cache);
	            System.out.println("收到消息 :" + msg.getText());
	            if (msg.getText().equals(MyMessageCreator.END_TAG)) 
	            	break;
	            
	        }
	    }

}
