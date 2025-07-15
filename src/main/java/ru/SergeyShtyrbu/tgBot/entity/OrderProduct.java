//package ru.SergeyShtyrbu.tgBot.entity;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "order_products")
//public class OrderProduct {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @ManyToOne
//    private ClientOrder clientOrder;
//
//    @ManyToOne
//    private Product product;
//
//    @Column(nullable = false)
//    private Integer countProduct;
//
//    public OrderProduct() {}
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public ClientOrder getClientOrder() {
//        return clientOrder;
//    }
//
//    public void setClientOrder(ClientOrder clientOrder) {
//        this.clientOrder = clientOrder;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Integer getCountProduct() {
//        return countProduct;
//    }
//
//    public void setCountProduct(Integer countProduct) {
//        this.countProduct = countProduct;
//    }
//}


package ru.SergeyShtyrbu.tgBot.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.data.rest.core.annotation.RestResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "order_products")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_order_id")
    @RestResource(exported = false)
    private ClientOrder clientOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @RestResource(exported = false)
    private Product product;

    @Column(nullable = false)
    private Integer countProduct;

    public OrderProduct() {}

    // 🔻 Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct) {
        this.countProduct = countProduct;
    }
}
