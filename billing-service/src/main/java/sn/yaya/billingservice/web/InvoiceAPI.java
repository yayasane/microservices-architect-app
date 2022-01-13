package sn.yaya.billingservice.web;

import sn.yaya.billingservice.dto.InvoiceRequestDTO;
import sn.yaya.billingservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceAPI {
    public List<InvoiceResponseDTO> listInvoices(String customerId);
    public List<InvoiceResponseDTO> allInvoices();
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    public InvoiceResponseDTO update(InvoiceRequestDTO invoiceRequestDTO, String id);
    public InvoiceResponseDTO getInvoice(String id);
    public void delete(String id);
}
