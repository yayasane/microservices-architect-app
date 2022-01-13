package sn.yaya.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import sn.yaya.billingservice.dto.InvoiceRequestDTO;
import sn.yaya.billingservice.services.InvoiceService;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication implements CommandLineRunner {
    private final InvoiceService invoiceService;

    public BillingServiceApplication(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        invoiceService.save(new InvoiceRequestDTO("",BigDecimal.valueOf(98000), "C01"));
        invoiceService.save(new InvoiceRequestDTO("",BigDecimal.valueOf(54300), "C01"));
        invoiceService.save(new InvoiceRequestDTO("",BigDecimal.valueOf(98000), "C02"));
    }
}
