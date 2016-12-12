package com.sample;

import java.util.Date;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.auto.A;
import com.auto.B;
import com.auto.D;

import klient.Klient;
import klient.Rezerwacja;
import klient.Zwrot;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
//            Message message = new Message();
//            message.setMessage("Hello World");
//            message.setStatus(Message.HELLO);
//            kSession.insert(message);
            kSession.insert(new A());
            kSession.insert(new A());
            kSession.insert(new B());
            kSession.insert(new D());
            kSession.insert(new D());
            Klient klient1 =  new Klient("Klient1",true);
            Klient klient2 =  new Klient("Klient2",false);
            Klient klient3 =  new Klient("Klient3",false);
            
            kSession.insert(klient1);
            kSession.insert(klient2);
            kSession.insert(klient3);
            Rezerwacja rezerwacja1 = new Rezerwacja(klient1, null, new Date("11/11/2016"),new Date("11/12/2016"),1,1);
            Rezerwacja rezerwacja2 = new Rezerwacja(klient2, new B(), new Date("11/10/2016"),new Date("11/13/2016"),1,0); 
            Rezerwacja rezerwacja3 = new Rezerwacja(klient2, new A(), new Date("11/11/2016"),new Date("11/14/2016"),1,0);
            Rezerwacja rezerwacja4 = new Rezerwacja(klient3, new B(), new Date("11/11/2016"),new Date("11/16/2016"),0,0);
            
            System.out.println(rezerwacja2.dateBetween(rezerwacja1.dataDo));
            System.out.println(rezerwacja1.dataDo);
            kSession.insert(rezerwacja1);
            kSession.insert(rezerwacja2);
            kSession.insert(rezerwacja3);
            kSession.insert(rezerwacja4);
                
        	kSession.fireAllRules();
        	
        	kSession.insert(new Zwrot(rezerwacja1,new Date("11/12/2016"),66.0,0,0));
        	kSession.insert(new Zwrot(rezerwacja2,new Date("11/13/2016"),100.0,0,0));
        	kSession.insert(new Zwrot(rezerwacja4,new Date("11/18/2016"),1000.0,1,2));
        	
        	kSession.fireAllRules();

        	
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
                                                                                                             
    }

}
