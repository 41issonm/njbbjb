package br.gov.sp.fatec.apipixel.core.domain.entity;

import br.gov.sp.fatec.apipixel.core.domain.enumerations.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgressoColaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private Set<Colaborador> colaborador = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "colaborador_id")
    private List<TrilhaCurso> trilhaCurso;
    @Embedded
    private Status status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Long porcentagemAndamento;
}
