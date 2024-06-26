package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends GenericEntity{
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Float price;
    @Column(name = "discount")
    private Integer discount = 0;
    @Column(name = "image", nullable = false)
    private String image;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "itemId",referencedColumnName = "id")
    private Item item;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Image> images;
    @OneToMany(mappedBy = "product")
    private Set<VariantProduct> productAttr;
//    @OneToMany(mappedBy = "product")
//    private Set<OrderDetail> productOrder;
//    @OneToMany(mappedBy = "product")
//    @JsonIgnore
//    private Set<Cart> carts;


}
