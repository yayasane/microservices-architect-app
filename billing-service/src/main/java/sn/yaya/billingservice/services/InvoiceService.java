package sn.yaya.billingservice.services;

import sn.yaya.billingservice.dto.InvoiceRequestDTO;
import sn.yaya.billingservice.dto.InvoiceResponseDTO;
import sn.yaya.billingservice.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    public List<InvoiceResponseDTO> listInvoices(String id);
    public List<InvoiceResponseDTO> allInvoices();
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    public InvoiceResponseDTO update(InvoiceRequestDTO invoiceRequestDTO);
    public InvoiceResponseDTO getInvoice(String id);
    public void delete(String id);
}
