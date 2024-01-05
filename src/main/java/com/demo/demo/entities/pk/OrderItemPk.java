package com.demo.demo.entities.pk;
// essa classe serve para fazer o par entre o produto e pedido
// e uma classe auxiliar para a OrderItem

import java.io.Serializable;

import com.demo.demo.entities.Order;
import com.demo.demo.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Embeddable // é usada em para marcar uma classe cujos objetos são embutidos como componentes em outras entidades. Significa que os atributos dessa classe serao embutidos nas colunas da tabela da classe que usar essa aqui
public class OrderItemPk implements Serializable{
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    // e necessario que o hash e o equals tenha a informaçao tanto do pedido quanto do produto pois os dois sao dados essenciais para diferenciar um pedido de outro 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItemPk other = (OrderItemPk) obj;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }
    
}
