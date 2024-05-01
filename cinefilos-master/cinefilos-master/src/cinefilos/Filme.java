package cinefilos;

import java.io.Serializable;
import java.util.Objects;

public class Filme implements Serializable {
    private String titulo;
    private String horarioDoFilme;

    public Filme(String titulo, String horario) {
        this.titulo = titulo;
        this.horarioDoFilme = horario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(titulo, filme.titulo) && Objects.equals(horarioDoFilme, filme.horarioDoFilme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, horarioDoFilme);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", horarioDoFilme='" + horarioDoFilme + '\'' +
                '}';
    }
}

