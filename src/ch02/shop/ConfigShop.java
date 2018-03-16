package ch02.shop;

import java.util.Arrays;
import java.util.Properties;

import ch02.erp.ErpClientFactory;
import ch02.search.SearchClientFactory;
import ch02.search.SearchClientFactoryBean;
import ch02.search.SearchServiceHealthChecker;
import ch02.shop.OrderService;
import ch02.shop.ProductService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigShop {

	@Bean
	public ProductService productService() {
		return new ProductService();
	}

	@Bean
	public OrderService orderService() {
		return new OrderService();
	}

	@Bean
	@Qualifier("order")
	public SearchClientFactoryBean orderSearchClientFactory() {
		SearchClientFactoryBean searchClientFactoryBean = new SearchClientFactoryBean();
		searchClientFactoryBean.setServer("10.20.30.40");
		searchClientFactoryBean.setPort(8888);
		searchClientFactoryBean.setContentType("json");
		return searchClientFactoryBean;
	}

	@Bean
	public SearchClientFactoryBean productSearchClientFactory() {
		SearchClientFactoryBean searchClientFactoryBean = new SearchClientFactoryBean();
		searchClientFactoryBean.setServer("10.20.30.41");
		searchClientFactoryBean.setPort(9999);
		searchClientFactoryBean.setContentType("json");
		return searchClientFactoryBean;
	}

	@Bean
	public ErpClientFactory erpClientFactory() {
		Properties props = new Properties();
		props.setProperty("server", "10.50.0.101");
		return ErpClientFactory.instance(props);
	}

	@Bean
	public SearchServiceHealthChecker searchServiceHealthChecker(
			SearchClientFactory orderSearchClientFactory,
			SearchClientFactory productSearchClientFactory
			) throws Exception {
		SearchServiceHealthChecker healthChecker = new SearchServiceHealthChecker();
		healthChecker.setFactories(Arrays.asList(
				orderSearchClientFactory, productSearchClientFactory
		));
		return healthChecker;
	}
}
