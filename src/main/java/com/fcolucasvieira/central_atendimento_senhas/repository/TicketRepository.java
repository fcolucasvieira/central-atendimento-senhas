package com.fcolucasvieira.central_atendimento_senhas.repository;

import com.fcolucasvieira.central_atendimento_senhas.domain.Ticket;
import com.fcolucasvieira.central_atendimento_senhas.dto.CreateTicketRequest;

public interface TicketRepository {
    public void createTicket(CreateTicketRequest request);
}
