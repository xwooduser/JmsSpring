package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

 
public class MyMessageCreator implements MessageCreator {

	public int id = 0;
	
	public static String END_TAG="end";

	public MyMessageCreator(int id) {
		super();
		this.id = id;
	}



	public Message createMessage(Session paramSession) throws JMSException {
        if (id == 9) {
            return paramSession.createTextMessage(END_TAG);//结束标记
        }
        return paramSession.createTextMessage("这个是第 " + id + " 个测试消息！");
    }


}
