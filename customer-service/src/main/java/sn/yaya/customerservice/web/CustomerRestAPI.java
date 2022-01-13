package sn.yaya.customerservice.web;

import org.springframework.web.bind.annotation.*;
import sn.yaya.customerservice.dto.CustomerRequestDTO;
import sn.yaya.customerservice.dto.CustomerResponseDTO;
import sn.yaya.customerservice.services.CustomerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerRestAPI {
    private final CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerResponseDTO>allCustomers(){
        return this.customerService.listCustomers();
    }

    @PostMapping("/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @PutMapping("/customers/{id}")
    public CustomerResponseDTO update(@RequestBody CustomerRequestDTO customerRequestDTO, @PathVariable String id){
        customerRequestDTO.setId(id);
        return customerService.update(customerRequestDTO);
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable String id){
        customerService.delete(id);
    }
}
