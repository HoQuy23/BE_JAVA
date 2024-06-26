package com.project.repository;

import com.project.model.Image;
import com.project.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Query( "SELECT od FROM OrderDetail od WHERE od.order.id = :orderId")
    List<OrderDetail> checkInOrderDetail(Integer orderId);
}
