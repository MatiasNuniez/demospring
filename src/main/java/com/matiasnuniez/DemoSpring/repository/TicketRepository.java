package com.matiasnuniez.DemoSpring.repository;

import com.matiasnuniez.DemoSpring.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
