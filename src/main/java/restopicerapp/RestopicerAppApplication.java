package restopicerapp;

import java.io.IOException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestopicerAppApplication {
	@Value("${spring.datasource.driverClassName}")
	private String databaseDriverClassName;
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	
	@Value("${spring.datasource.username}")
	private String databaseUsername;
	
	@Value("${spring.datasource.password}")
	private String databasePassword;
	
	@Bean
	public DataSource datasource() throws IOException {
	    DataSource ds = new DataSource();
	    ds.setDriverClassName(databaseDriverClassName);
	    ds.setUrl(datasourceUrl);
	    ds.setUsername(databaseUsername);
	    ds.setPassword(databasePassword);
	    return ds;
	}
    public static void main(String[] args) {
        SpringApplication.run(RestopicerAppApplication.class, args);
    }
}
