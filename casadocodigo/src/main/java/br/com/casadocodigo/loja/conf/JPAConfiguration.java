package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // essa linha só habilita o Spring cuida das transações para nós,
//o @EnableTransactionMangement Temos que ir até onde queremos que o Spring cuide da transação e marcar com o @Transactional nesse caso ProdutoDAO 
public class JPAConfiguration {
	
	@Bean // essa linha serve para o Spring reconhecer o metodo abaixo
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		
		//criando conexão com mysql
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		dataSource.setUrl("jdbc:mysql://localhost/casadocodigo?useSSL=false&serverTimezone=UTC");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		factoryBean.setDataSource(dataSource);
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		factoryBean.setJpaProperties(props);
		factoryBean.setPackagesToScan("br.com.casadocodigo.loja.models");
		
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager TransactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
