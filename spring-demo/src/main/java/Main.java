import com.dyliu.config.AppConfig;
import com.dyliu.prototype.ProtoType;
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
		/*try {
			System.out.println(ac.getBean("myFactoryBean"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.println(ac.getBean(ProtoType.class));
		//((Map<String,Object>)ac.getBeanFactory().getSingletonMutex()).keySet().forEach(System.out::println);
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

