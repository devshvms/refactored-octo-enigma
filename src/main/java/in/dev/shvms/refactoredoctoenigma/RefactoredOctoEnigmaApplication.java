package in.dev.shvms.refactoredoctoenigma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RefactoredOctoEnigmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefactoredOctoEnigmaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext context) {
//		return args -> {
//			System.out.println("All initialized beans in Application context (Sorted by name):");
//			String[] beans = context.getBeanDefinitionNames();
//			Arrays.sort(beans);
//			Arrays.stream(beans).forEach(System.out::println);
//		};
//	}
}
