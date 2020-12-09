package hbrs.se2.main;

import java.awt.EventQueue;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "hbrs.se2.main")
@EnableAutoConfiguration
public class WobblSpring {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(WobblSpring.class).headless(false)
				.run(args);

		EventQueue.invokeLater(() -> {
			@SuppressWarnings("unused")
			WobblGame window = context.getBean(WobblGame.class);
		});
	}

}
