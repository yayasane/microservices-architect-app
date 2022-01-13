package sn.yaya.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.yaya.billingservice.entities.Customer;

import java.math.BigDecimal;
import java.util.Date;

@Data @AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequestDTO {
    private String id;
    private BigDecimal amount;
    private String customerId;
}
