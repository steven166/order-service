package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@RestController
	public class TraceController{

		@Autowired
		private ProductClient productClient;

		@RequestMapping(method = RequestMethod.GET, path = "/api/v1/trace")
		public String trace(){
			return "order-service: 1.0\n" + productClient.trace();
		}

	}

	@FeignClient("product-service")
	public interface ProductClient{

		@RequestMapping(method = RequestMethod.GET, path = "/api/v1/trace")
		public String trace();

	}
}
