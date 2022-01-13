package sn.yaya.customerservice.services;

import org.springframework.stereotype.Service;
import sn.yaya.customerservice.dto.CustomerRequestDTO;
import sn.yaya.customerservice.dto.CustomerResponseDTO;
import sn.yaya.customerservice.entities.Customer;
import sn.yaya.customerservice.mappers.CustomerMapper;
import sn.yaya.customerservice.repositories.CustomerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = this.customerMapper.customerResponseDTOToCustomer(customerRequestDTO);
        return customerMapper.customerToCustomerResponseDTO(customerRepository.save(customer));
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        return customerMapper.customerToCustomerResponseDTO(customerRepository.findById(id).get());
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = this.customerMapper.customerResponseDTOToCustomer(customerRequestDTO);
        return customerMapper.customerToCustomerResponseDTO(customerRepository.save(customer));
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::customerToCustomerResponseDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
