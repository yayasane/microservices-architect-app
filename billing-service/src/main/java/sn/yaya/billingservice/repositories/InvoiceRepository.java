package sn.yaya.billingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.yaya.billingservice.entities.Invoice;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    List<Invoice> findByCustomerId(String id);
}
