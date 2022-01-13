package sn.yaya.billingservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.yaya.billingservice.dto.InvoiceRequestDTO;
import sn.yaya.billingservice.dto.InvoiceResponseDTO;
import sn.yaya.billingservice.services.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController implements InvoiceAPI {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoicesByCustomer/{customerId}")
    @Override
    public List<InvoiceResponseDTO> listInvoices(@PathVariable String customerId) {
        return invoiceService.listInvoices(customerId);
    }

    @GetMapping("/invoices")
    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        return invoiceService.allInvoices();
    }

    @PostMapping("/invoices")
    @Override
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {
        return invoiceService.save(invoiceRequestDTO);
    }

    @PutMapping("/invoices/{id}")
    @Override
    public InvoiceResponseDTO update(@RequestBody InvoiceRequestDTO invoiceRequestDTO, @PathVariable String id) {
        invoiceRequestDTO.setId(id);
        return invoiceService.save(invoiceRequestDTO);
    }

    @GetMapping("/invoices/{id}")
    @Override
    public InvoiceResponseDTO getInvoice(@PathVariable String id) {
        return invoiceService.getInvoice(id);
    }

    @DeleteMapping("/invoices/{id}")
    @Override
    public void delete(@PathVariable String id) {
    invoiceService.delete(id);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
