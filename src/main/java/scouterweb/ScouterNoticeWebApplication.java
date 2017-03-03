package scouterweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ScouterNoticeWebApplication {

	public static void main(String[] args) {
		System.setProperty("SERVER_PORT", "6181");
		SpringApplication.run(ScouterNoticeWebApplication.class, args);
	}
}
