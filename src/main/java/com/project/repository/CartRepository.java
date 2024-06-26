package com.project.repository;

import com.project.model.Cart;
import com.project.model.VariantProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("SELECT c FROM Cart c WHERE c.product.id = :productId AND c.color.id = :colorId AND c.size.id = :sizeId")
    Cart checkCart(Integer productId, Integer colorId, Integer sizeId);
    @Query("SELECT c FROM Cart c WHERE c.user.id = :userId")
    List<Cart> getCart(Integer userId);
    @Query("SELECT c FROM Cart c WHERE c.user.id = :userId AND c.isCheckout = true")
    List<Cart> getCheckout(Integer userId);
}
