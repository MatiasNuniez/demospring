package com.matiasnuniez.DemoSpring.controller;

import com.matiasnuniez.DemoSpring.models.Ticket;
import com.matiasnuniez.DemoSpring.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TicketsController {

    private final TicketService ticketService;

    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket")
    public List<Ticket> getTickets(){
        return this.ticketService.getAllTickets();
    }

    @GetMapping("/ticket/{id}")
    public Ticket getTicket(@PathVariable Long id){
        return this.ticketService.getOneTicket(id);
    }

    @PostMapping("/ticket")
    public Ticket createTickets(@RequestBody Ticket ticket){
        return this.ticketService.createNewTicket(ticket);
    }

//    Solamente para aprender query params. Si o si el nombre del query tiene que concidir con el de la variable que estyo pidiendo
//    @GetMapping("/ticket/{id}")
//    public String getOneTicket(@PathVariable String id, @RequestParam String params){
//        return "Leyendo el id: " + id + ", y los parametros son: " + params;
//    }

//    Ejemplo de peticion /ticket/{id}?params=holahola

    @PutMapping("/ticket/{id}")
    public Ticket editTicket(@PathVariable Long id, @RequestBody Ticket ticket){
        return this.ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/ticket/{id}")
    public String deleteTicket(@PathVariable Long id){
        return this.ticketService.deleteTicket(id);
    }


}
