package demo.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DatasourceConfiguration {

	@Bean
	public DataSource dataSource() throws Exception {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("classpath:schema-all.sql")
				.addScript("classpath:org/springframework/batch/core/schema-drop-hsqldb.sql")
				.addScript("classpath:org/springframework/batch/core/schema-hsqldb.sql")
				.build();
	}
}
