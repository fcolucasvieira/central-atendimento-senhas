package com.fcolucasvieira.central_atendimento_senhas.service;

import com.fcolucasvieira.central_atendimento_senhas.domain.Ticket;
import com.fcolucasvieira.central_atendimento_senhas.domain.TicketType;
import com.fcolucasvieira.central_atendimento_senhas.dto.CreateTicketRequest;
import com.fcolucasvieira.central_atendimento_senhas.dto.CreateTicketResponse;
import com.fcolucasvieira.central_atendimento_senhas.repository.TicketRepositoryMemory;

public class TicketService {
    private final TicketRepositoryMemory repository;

    long proxNumber = 1;

    public TicketService(TicketRepositoryMemory repository) {
        this.repository = repository;
    }

    public CreateTicketResponse create(CreateTicketRequest request) {
        String type = request.type() != null ? request.type().trim().toUpperCase() : "";

        if (!type.equals("COMUM") && !type.equals("PRIORITARIA"))
            throw new IllegalArgumentException("Ticket type should be 'COMUM' or 'PRIORIDADE'");

        TicketType typeEnum = TicketType.valueOf(type);

        Ticket ticket = new Ticket(proxNumber, request.name(), typeEnum);

        proxNumber++;

        ticket = repository.save(ticket);

        return new CreateTicketResponse(
                ticket.getId(),
                ticket.getName(),
                ticket.getType(),
                ticket.getStatus()
        );
    }
}
