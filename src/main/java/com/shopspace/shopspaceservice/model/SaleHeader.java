package com.shopspace.shopspaceservice.model;

import com.shopspace.shopspaceservice.converter.DateConverter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ss_sale_header")
public class SaleHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(precision = 10, scale = 2)
    private BigDecimal shippingCost;
    @Column(precision = 10, scale = 2)
    private BigDecimal tax;
    @Column(nullable = false)
    @Convert(converter = DateConverter.class)
    private Date saleDate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id")
    private CreditCardInformation creditCardInformation;
    @ManyToOne()
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sale_header_id")
    private List<SaleBody> detail;

    public SaleHeader() {
    }

    public SaleHeader(Long id, BigDecimal shippingCost, BigDecimal tax, Date saleDate, PaymentMethod paymentMethod, CreditCardInformation creditCardInformation, Coupon coupon, Customer customer, List<SaleBody> detail) {
        this.id = id;
        this.shippingCost = shippingCost;
        this.tax = tax;
        this.saleDate = saleDate;
        this.paymentMethod = paymentMethod;
        this.creditCardInformation = creditCardInformation;
        this.coupon = coupon;
        this.customer = customer;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CreditCardInformation getCreditCardInformation() {
        return creditCardInformation;
    }

    public void setCreditCardInformation(CreditCardInformation creditCardInformation) {
        this.creditCardInformation = creditCardInformation;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SaleBody> getDetail() {
        return detail;
    }

    public void setDetail(List<SaleBody> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "SaleHeader{" +
                "id=" + id +
                ", shippingCost=" + shippingCost +
                ", tax=" + tax +
                ", saleDate=" + saleDate +
                ", paymentMethod=" + paymentMethod +
                ", creditCardInformation=" + creditCardInformation +
                ", coupon=" + coupon +
                ", customer=" + customer +
                ", detail=" + detail +
                '}';
    }
}
