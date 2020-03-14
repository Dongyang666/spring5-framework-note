import com.dyliu.aop.A;
import com.dyliu.aop.AopAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liudongyang
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		//激活pro环境.
		//ac.getEnvironment().setActiveProfiles("dev");
		ac.register(AopAppConfig.class);

		ac.refresh();
		ac.getBean(A.class).testPublic();
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

