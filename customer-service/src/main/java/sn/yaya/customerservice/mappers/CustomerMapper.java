package sn.yaya.customerservice.mappers;

import org.mapstruct.Mapper;
import sn.yaya.customerservice.dto.CustomerRequestDTO;
import sn.yaya.customerservice.dto.CustomerResponseDTO;
import sn.yaya.customerservice.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerResponseDTOToCustomer(CustomerRequestDTO customer);
}
