package com.codemaster.seckil.repository;

import com.codemaster.seckil.model.Orders;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Orders, String> {

    public Orders findByUsernameAndCourseNo(String username, String courseNo);

    public List<Orders> findByUsername(String username, Sort sort);

}
