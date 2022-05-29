package com.finalproyect.coderhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Invoice")
@Table(name = "Invoice")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long invoice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "invoice_type")
    private String invoiceType;

    @Column(name = "total")
    private int total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<InvoiceDetail> invoiceDetail;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    public InvoiceDetail addDetail(InvoiceDetail invoiceDetail) {
        getInvoiceDetail().add(invoiceDetail);
        invoiceDetail.setInvoice(this);
        return invoiceDetail;
    }

    public InvoiceDetail removeDetail(InvoiceDetail invoiceDetail) {
        getInvoiceDetail().remove(invoiceDetail);
        invoiceDetail.setInvoice(null);
        return invoiceDetail;
    }
}
