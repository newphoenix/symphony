package ba.sec.app.secApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class SecAppApplication {
	
	@Value("${spring.datasource.driver}")
	private String driver;
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUser;
	@Value("${spring.datasource.password}")
	private String dbPass;
	@Value("${spring.datasource.testWhileIdle}")
	private String testWhileIdle;
	@Value("${spring.datasource.validationQuery}")
	private String validityQuery;

	public static void main(String[] args) {
		SpringApplication.run(SecAppApplication.class, args);
	}
	
	
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driver);
        driverManagerDataSource.setUrl(dbUrl);
        driverManagerDataSource.setUsername(dbUser);
        driverManagerDataSource.setPassword(dbPass);
        return driverManagerDataSource;
    }
}
