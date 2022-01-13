package sn.yaya.billingservice.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.yaya.billingservice.entities.Customer;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerServiceRestClient {
    @GetMapping("/api/customers/{id}")
    Customer customerById(@PathVariable String id);

    @GetMapping("/api/customers")
    List<Customer> customers();
}
