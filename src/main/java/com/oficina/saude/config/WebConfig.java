package com.oficina.saude.config;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver jasperReportsViewResolver(DataSource dataSource) {
		JasperReportsViewResolver resolver = new JasperReportsViewResolver();
		resolver.setPrefix("classpath:/relatorios/");
		resolver.setSuffix(".jasper");
		resolver.setViewNames("rel_*");
		resolver.setViewClass(JasperReportsMultiFormatView.class);
		resolver.setJdbcDataSource(dataSource);
		resolver.setOrder(0);
		return resolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/index");
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
