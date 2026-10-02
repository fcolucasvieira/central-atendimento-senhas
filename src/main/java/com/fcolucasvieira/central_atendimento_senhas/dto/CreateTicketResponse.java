package com.fcolucasvieira.central_atendimento_senhas.dto;

import com.fcolucasvieira.central_atendimento_senhas.domain.TicketStatus;
import com.fcolucasvieira.central_atendimento_senhas.domain.TicketType;

public record CreateTicketResponse(
        long id,
        String name,
        TicketType type,
        TicketStatus status
) {
}
