import com.dyliu.aop.AopAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liudongyang
 */
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		// 激活pro环境.
		// ac.getEnvironment().setDefaultProfiles("dev");
		// ac.getEnvironment().setActiveProfiles("pro");
		ac.register(AopAppConfig.class);
		//ac.scan("com.dyliu.config");
		ac.refresh();
		//ac.getBean(A.class).testA();
		//ac.getBean(TestClass.class);
		//ac.getBean(X.class);
		/*try {
			System.out.println(ac.getBean("myFactoryBean"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//ac.getBean(A.class).testA();
		/**
		 * 自动装配未被spring管理的bean，但是spring容器中还是没有这个bean
		 * Spring 提供了一种机制，能够为第三方框架赋能，让Spring管理的Bean去装配和填充那些不被Spring托管的Bean，
		 * 这种机制叫AutowireCapableBeanFactory。
		 *
		 * AutowireCapableBeanFactory autowireCapableBeanFactory = ac.getAutowireCapableBeanFactory();
		 * Object autowire = autowireCapableBeanFactory.autowire(SpringBean.class, AutowireCapableBeanFactory.AUTOWIRE_NO, false);
		 * autowireCapableBeanFactory.initializeBean(autowire,SpringBean.class.getName()+AutowireCapableBeanFactory.ORIGINAL_INSTANCE_SUFFIX);
		 *
		 */
		//((Map<String,Object>)ac.getBeanFactory().getSingletonMutex()).keySet().forEach(System.out::println);
		/*ac.getBean(PropertyDemo.class).printEnv();*/
		//ac.getBean(TestStaticAware.class).test();
		//System.out.println(ac.getBean(OtherClass.class));
		ac.close();
		//这个是获取FactoryBean代理的对象（也就是getObject返回的对象）
		//System.out.println(ac.getBean("myFactoryBean").getClass().getSimpleName());
		//这个是获取FactoryBean对象
		//System.out.println(ac.getBean("&myFactoryBean").getClass().getSimpleName());


	}
}

