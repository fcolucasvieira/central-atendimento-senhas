package com.fcolucasvieira.central_atendimento_senhas.service;

import com.fcolucasvieira.central_atendimento_senhas.dto.CreateTicketRequest;
import com.fcolucasvieira.central_atendimento_senhas.dto.CreateTicketResponse;
import com.fcolucasvieira.central_atendimento_senhas.repository.TicketRepositoryMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {
    private TicketService service;
    private TicketRepositoryMemory repository;

    @BeforeEach
    void setUp() {
        repository = new TicketRepositoryMemory();
        service = new TicketService(repository);
    }

    @Test
    void deveCriarSenhasComIdSequencialUnico() {
        CreateTicketRequest req1 = new CreateTicketRequest("Lucas", "COMUM");
        CreateTicketRequest req2 = new CreateTicketRequest("Suzy", "PRIORITARIA");

        CreateTicketResponse resp1 = service.create(req1);
        CreateTicketResponse resp2 = service.create(req2);

        assertEquals(1, resp1.id());
        assertEquals(2, resp2.id());
    }


    @Test
    void deveLancarExcecaoENaoAvancarSequenciaDeIdQuandoNomeForVazio() {
        CreateTicketRequest req1 = new CreateTicketRequest(" ", "COMUM");

        assertThrows(IllegalArgumentException.class, () -> service.create(req1));

        CreateTicketRequest req2 = new CreateTicketRequest("Lucas", "COMUM");

        CreateTicketResponse resp2 = service.create(req2);
        assertEquals(1, resp2.id());
    }

    @Test
    void deveLancarExcecaoENaoAvancarSequenciaDeIdQuandoTipoForInvalido() {
        CreateTicketRequest req = new CreateTicketRequest("Lucas", "INEXISTENTE");

        assertThrows(IllegalArgumentException.class, () -> service.create(req));

        CreateTicketRequest req2 = new CreateTicketRequest("Lucas", "COMUM");

        CreateTicketResponse resp2 = service.create(req2);
        assertEquals(1, resp2.id());
    }

}