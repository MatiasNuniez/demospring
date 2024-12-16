package com.matiasnuniez.DemoSpring.services;

import com.matiasnuniez.DemoSpring.models.Ticket;
import com.matiasnuniez.DemoSpring.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class TicketService {

    private final TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets(){
        return this.ticketRepository.findAll();
    }

    public Ticket getOneTicket(Long id){
        return this.ticketRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id invalido, no se encontro ningun ticket con ese ID."));
    }

    public Ticket createNewTicket(Ticket ticket){
        return this.ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket dataUpdate){
        Ticket ticket = this.ticketRepository.findById(dataUpdate.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el ID del ticket a actualizar."));

        ticket.setStatus(dataUpdate.isStatus());
        ticket.setIdResponsible(dataUpdate.getIdResponsible());
        ticket.setNameResponsible(dataUpdate.getNameResponsible());

        return this.ticketRepository.save(ticket);
    }

    public String deleteTicket(Long id){

        Ticket ticket = this.ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id invalido, no se encontro ningun ticket"));

        this.ticketRepository.deleteById(id);

        return "Elemento eliminado correctamente, el ID es: " + ticket.getId();

    }


}
