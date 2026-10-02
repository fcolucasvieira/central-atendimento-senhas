package com.fcolucasvieira.central_atendimento_senhas.domain;

public class Ticket {
    private long id;
    private String name;
    private TicketType type;
    private TicketStatus status;

    public Ticket(long id, String name, TicketType type) {
        if (id <= 0)
            throw new IllegalArgumentException("Id can't be negative or zero");

        this.id = id;

        name = name.trim();

        if(name.isBlank())
            throw new IllegalArgumentException("Name can't be blank");

        this.name = name;

        this.type = type;

        this.status = TicketStatus.AGUARDANDO;
    }
}
