package br.com.usf.bar;

import br.com.usf.bar.screen.MainScreen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.swing.*;

@SpringBootApplication
@EntityScan(basePackages = {
		"br.com.usf.bar.model"
})
@EnableJpaRepositories(basePackages = {
		"br.com.usf.bar.repository"
})
public class BarApplication extends JFrame {

	public static void main(String[] args) {SpringApplication.run(BarApplication.class, args);

		JFrame frame = new MainScreen("Tela principal");
		frame.setVisible(true);
	}


}
