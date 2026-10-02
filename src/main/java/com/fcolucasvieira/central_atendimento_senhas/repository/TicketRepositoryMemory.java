package com.fcolucasvieira.central_atendimento_senhas.repository;

import com.fcolucasvieira.central_atendimento_senhas.domain.Ticket;
import com.fcolucasvieira.central_atendimento_senhas.dto.CreateTicketRequest;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryMemory implements TicketRepository {
    List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        return ticket;

    }
}
