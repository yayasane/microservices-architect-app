package sn.yaya.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.yaya.billingservice.entities.Customer;

import java.math.BigDecimal;
import java.util.Date;

@Data @AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDTO {
    private String id;
    private Date date;
    private BigDecimal amount;
    private String customerId;
    private Customer customer;
}
