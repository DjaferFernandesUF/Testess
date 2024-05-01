package cinefilos;

import java.io.Serializable;
import java.util.Objects;

public class Gerente implements Serializable {
    private String senha;

    public Gerente(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gerente gerente = (Gerente) o;
        return Objects.equals(senha, gerente.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(senha);
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "senha='" + senha + '\'' +
                '}';
    }
}
