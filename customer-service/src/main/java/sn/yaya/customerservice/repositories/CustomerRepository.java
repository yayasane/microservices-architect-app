package sn.yaya.customerservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sn.yaya.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository <Customer, String> {
}
