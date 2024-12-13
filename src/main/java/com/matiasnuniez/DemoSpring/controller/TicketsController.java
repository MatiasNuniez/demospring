package com.matiasnuniez.DemoSpring.controller;

import com.matiasnuniez.DemoSpring.models.Ticket;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TicketsController {

    @GetMapping("/ticket")
    public void getTickets(){

    }

    @GetMapping("/ticket/{id}")
    public String getOneTicket(@PathVariable String id){
        return "Leyendo el id: " + id;
    }

    @PostMapping("/ticket")
    public String createTickets(@RequestBody Ticket ticket){
        return "hola";
//                "id" + ticket.id + ", idResponsable: " + ticket.idResponsable + ", nombreResponsable: " + ticket.nombreResponsable + ", status: " + ticket.status;
    }

//    Solamente para aprender query params. Si o si el nombre del query tiene que concidir con el de la variable que estyo pidiendo
//    @GetMapping("/ticket/{id}")
//    public String getOneTicket(@PathVariable String id, @RequestParam String params){
//        return "Leyendo el id: " + id + ", y los parametros son: " + params;
//    }

//    Ejemplo de peticion /ticket/{id}?params=holahola

    @PutMapping("/ticket")
    public void editTicket(){

    }

    @DeleteMapping("/ticket")
    public void deleteTicket(){

    }


}
