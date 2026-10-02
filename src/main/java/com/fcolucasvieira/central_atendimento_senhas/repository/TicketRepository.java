package com.fcolucasvieira.central_atendimento_senhas.repository;

import com.fcolucasvieira.central_atendimento_senhas.domain.Ticket;

public interface TicketRepository {
    public Ticket save(Ticket ticket);
}
