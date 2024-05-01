package cinefilos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void criarCliente() {
        cliente = new Cliente("Heloísa", "heloisa@gmail.com", "rabanada123");
    }

    @Test
    void setNome() {
        Assertions.assertEquals("Heloísa", cliente.getNome());
        cliente.setNome("");
        Assertions.assertEquals("Heloísa", cliente.getNome());
        cliente.setNome("H5l0!s4");
        Assertions.assertEquals("Heloísa", cliente.getNome());
        cliente.setNome("Eduarda");
        Assertions.assertEquals("Eduarda", cliente.getNome());
    }

    @Test
    void setEmail() {
        Assertions.assertEquals("heloisa@gmail.com", cliente.getEmail());
        cliente.setEmail(null);
        Assertions.assertEquals("heloisa@gmail.com", cliente.getEmail());
        cliente.setEmail("");
        Assertions.assertEquals("heloisa@gmail.com", cliente.getEmail());
        cliente.setEmail("heloisa@gmail.com.br");
        Assertions.assertEquals("heloisa@gmail.com.br", cliente.getEmail());
        cliente.setEmail("heloisagmail.com.br");
        Assertions.assertEquals("heloisa@gmail.com.br", cliente.getEmail());
    }

    @Test
    void setSenha() {
        Assertions.assertEquals("rabanada123", cliente.getSenha());
        cliente.setSenha("");
        Assertions.assertEquals("rabanada123", cliente.getSenha());
        cliente.setSenha(null);
        Assertions.assertEquals("rabanada123", cliente.getSenha());
        cliente.setSenha("senha123");
        Assertions.assertEquals("senha123", cliente.getSenha());
    }
}