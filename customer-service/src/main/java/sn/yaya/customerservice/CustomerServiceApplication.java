package sn.yaya.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.yaya.customerservice.dto.CustomerRequestDTO;
import sn.yaya.customerservice.services.CustomerService;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO("C01", "Adria", "adria@adria.com");
            customerService.save(customerRequestDTO);
            customerService.save(new CustomerRequestDTO("C02", "Adria", "openlab@openlab.com"));
        };
    }

}
