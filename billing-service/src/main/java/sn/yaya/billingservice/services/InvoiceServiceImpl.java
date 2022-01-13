package sn.yaya.billingservice.services;

import org.springframework.stereotype.Service;
import sn.yaya.billingservice.dto.InvoiceRequestDTO;
import sn.yaya.billingservice.dto.InvoiceResponseDTO;
import sn.yaya.billingservice.entities.Customer;
import sn.yaya.billingservice.entities.Invoice;
import sn.yaya.billingservice.mappers.InvoiceMapper;
import sn.yaya.billingservice.openfeign.CustomerServiceRestClient;
import sn.yaya.billingservice.repositories.InvoiceRepository;
import sn.yaya.billingservice.services.exceptionHandlers.CustomerNotFoundExecption;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final CustomerServiceRestClient customerServiceRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerServiceRestClient customerServiceRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerServiceRestClient = customerServiceRestClient;
    }

    @Override
    public List<InvoiceResponseDTO> listInvoices(String id) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(id);
        for (Invoice invoice :
                invoices) {
            Customer customer = customerServiceRestClient.customerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoiceMapper::invoiceToInvoiceResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice :
                invoices) {
            Customer customer = customerServiceRestClient.customerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoiceMapper::invoiceToInvoiceResponseDTO).collect(Collectors.toList());
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        /*
         * Vérification intégrité référentiel Invoice/Customer
         * */
        Customer customer = null;
        try {
            customer = customerServiceRestClient.customerById(invoiceRequestDTO.getCustomerId());
        }catch (Exception e){
            throw new CustomerNotFoundExecption("Customer not found");
        }
        Invoice invoice = invoiceMapper.invoiceRequestDTOToInvoice(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice savedInvoice = invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customer);

        return invoiceMapper.invoiceToInvoiceResponseDTO(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO update(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.invoiceRequestDTOToInvoice(invoiceRequestDTO);
        return invoiceMapper.invoiceToInvoiceResponseDTO(invoiceRepository.save(invoice));
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {
        Invoice invoice = invoiceRepository.findById(id).get();
        Customer customer = customerServiceRestClient.customerById(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDTO(invoice);
    }

    @Override
    public void delete(String id) {
        invoiceRepository.deleteById(id);
    }
}
