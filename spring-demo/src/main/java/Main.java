import com.dyliu.config.AppConfig;
import com.dyliu.springlife.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liudongyang
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		//激活pro环境.
		//ac.getEnvironment().setActiveProfiles("dev");
		ac.register(AppConfig.class);

		ac.refresh();
		/*ac.getBean(PropertyDemo.class).printEnv();*/
		//ac.getBean(TestStaticAware.class).test();
		//System.out.println(ac.getBean(OtherClass.class));
		ac.close();
		//BeanWrapper bw = new BeanWrapperImpl(new SpringBean());
		//System.out.println(ac.getBean("testClass"));
		//ac.getBean(Service.class).query();

		//ac.getBean(TestService.class).get();

		//System.out.println(ac.getBean("myFactoryBean").getClass().getSimpleName());
		//System.out.println(ac.getBean("&myFactoryBean").getClass().getSimpleName());


	}
}

