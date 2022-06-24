package com.libre.repository;

import com.libre.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservqtionRepository extends JpaRepository<Reservation, Long> {
}
