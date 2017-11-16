package be.tcla.bookinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BookInventoryApplication {



	public static void main(String[] args) {

	    ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
	    msgSource.setBasename("messages");

        //MessageSource msgSource = new ResourceBundleMessageSource();

		Locale english = Locale.ENGLISH;
		Locale dutch = new Locale("nl", "BE");

        System.out.println("Title= " + msgSource.getMessage("title",null, english));
        System.out.println("Titel= " + msgSource.getMessage("title",null, dutch));

		SpringApplication.run(BookInventoryApplication.class, args);
	}

//@Bean
//@Primary
//    public MessageSource mySource(){
//    ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
//    msgSource.setBasename("messages");
//    return msgSource;
//    }

}
