package sn.yaya.customerservice.services;

import sn.yaya.customerservice.dto.CustomerRequestDTO;
import sn.yaya.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
    public void delete(String id);
}
