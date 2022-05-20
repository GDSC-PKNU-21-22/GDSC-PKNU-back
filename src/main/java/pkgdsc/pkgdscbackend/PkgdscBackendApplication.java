package pkgdsc.pkgdscbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.gdsc.pknu.backend"})
@SpringBootApplication
public class PkgdscBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PkgdscBackendApplication.class, args);
	}

}
