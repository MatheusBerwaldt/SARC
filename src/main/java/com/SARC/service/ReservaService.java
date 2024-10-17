package com.SARC.service;

import com.SARC.domain.Reserva;
import com.SARC.repository.ReservaRepository;
import com.SARC.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final AulaRepository aulaRepository;

    public ReservaService(ReservaRepository reservaRepository, AulaRepository aulaRepository) {
        this.reservaRepository = reservaRepository;
        this.aulaRepository = aulaRepository;
    }

    public Reserva criarReserva(Reserva reserva) {
        boolean aulaExiste = aulaRepository.existsByTurmaCodigoAndDataAndHorario(
                reserva.getTurma().getCodigo(), reserva.getData(), reserva.getHorario());
        if (!aulaExiste) {
            throw new IllegalArgumentException("Não existe aula agendada para esta turma nesta data e horário.");
        }

        boolean recursoReservado = reservaRepository.existsByRecursoCodigoAndDataAndHorario(
                reserva.getRecurso().getCodigo(), reserva.getData(), reserva.getHorario());
        if (recursoReservado) {
            throw new IllegalArgumentException("Recurso já reservado neste horário.");
        }

        boolean professorOcupado = reservaRepository.existsByTurmaProfessorIdAndDataAndHorario(
                reserva.getTurma().getProfessor().getId(), reserva.getData(), reserva.getHorario());
        if (professorOcupado) {
            throw new IllegalArgumentException("Professor já possui uma reserva neste horário.");
        }

        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarPorData(LocalDate data) {
        return reservaRepository.findByData(data);
    }

    public List<Reserva> listarPorTurma(Long turmaCodigo) {
        return reservaRepository.findByTurmaCodigo(turmaCodigo);
    }

    public void deletarPorId(Long id) {
        reservaRepository.deleteById(id);
    }
}

