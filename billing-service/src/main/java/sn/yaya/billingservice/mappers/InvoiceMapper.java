package sn.yaya.billingservice.mappers;

import org.mapstruct.Mapper;
import sn.yaya.billingservice.dto.InvoiceRequestDTO;
import sn.yaya.billingservice.dto.InvoiceResponseDTO;
import sn.yaya.billingservice.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceResponseDTO invoiceToInvoiceResponseDTO(Invoice invoice);
    Invoice invoiceRequestDTOToInvoice(InvoiceRequestDTO invoiceRequestDTO);
}
