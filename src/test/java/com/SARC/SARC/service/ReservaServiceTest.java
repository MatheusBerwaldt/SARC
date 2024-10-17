package com.SARC.SARC.service;

import com.SARC.domain.*;
import com.SARC.repository.AulaRepository;
import com.SARC.repository.ReservaRepository;
import com.SARC.service.ReservaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private AulaRepository aulaRepository;

    @InjectMocks
    private ReservaService reservaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarReservaComSucesso() {
        LocalDate data = LocalDate.of(2024, 10, 17);
        String horario = "08:00-10:00";

        Professor professor = new Professor();
        professor.setId(1L);

        Turma turma = new Turma();
        turma.setCodigo(1L);
        turma.setProfessor(professor);

        Recurso recurso = new Recurso();
        recurso.setCodigo(1L);

        Reserva reserva = new Reserva(null, data, horario, turma, recurso);

        when(aulaRepository.existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), data, horario)).thenReturn(true);

        when(reservaRepository.existsByRecursoCodigoAndDataAndHorario(
                recurso.getCodigo(), data, horario)).thenReturn(false);

        when(reservaRepository.existsByTurmaProfessorIdAndDataAndHorario(
                professor.getId(), data, horario)).thenReturn(false);

        when(reservaRepository.save(reserva)).thenReturn(reserva);

        Reserva resultado = reservaService.criarReserva(reserva);

        assertNotNull(resultado);
        verify(aulaRepository, times(1)).existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), data, horario);
        verify(reservaRepository, times(1)).existsByRecursoCodigoAndDataAndHorario(
                recurso.getCodigo(), data, horario);
        verify(reservaRepository, times(1)).existsByTurmaProfessorIdAndDataAndHorario(
                professor.getId(), data, horario);
        verify(reservaRepository, times(1)).save(reserva);
    }

    @Test
    public void testCriarReservaSemAula() {
        LocalDate data = LocalDate.of(2024, 10, 17);
        String horario = "08:00-10:00";

        Turma turma = new Turma();
        turma.setCodigo(1L);

        Recurso recurso = new Recurso();
        recurso.setCodigo(1L);

        Reserva reserva = new Reserva(null, data, horario, turma, recurso);

        when(aulaRepository.existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), data, horario)).thenReturn(false);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            reservaService.criarReserva(reserva);
        });

        assertEquals("Não existe aula agendada para esta turma nesta data e horário.", exception.getMessage());
        verify(aulaRepository, times(1)).existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), data, horario);
        verifyNoMoreInteractions(reservaRepository);
    }

    @Test
    public void testCriarReservaComRecursoReservado() {
        LocalDate data = LocalDate.of(2024, 10, 17);
        String horario = "08:00-10:00";

        Turma turma = new Turma();
        turma.setCodigo(1L);

        Recurso recurso = new Recurso();
        recurso.setCodigo(1L);

        Reserva reserva = new Reserva(null, data, horario, turma, recurso);

        when(aulaRepository.existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), data, horario)).thenReturn(true);

        when(reservaRepository.existsByRecursoCodigoAndDataAndHorario(
                recurso.getCodigo(), data, horario)).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            reservaService.criarReserva(reserva);
        });

        assertEquals("Recurso já reservado neste horário.", exception.getMessage());
        verify(aulaRepository, times(1)).existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), data, horario);
        verify(reservaRepository, times(1)).existsByRecursoCodigoAndDataAndHorario(
                recurso.getCodigo(), data, horario);
        verify(reservaRepository, never()).save(reserva);
    }

    @Test
    public void testCriarReservaComProfessorOcupado() {
        LocalDate data = LocalDate.of(2024, 10, 17);
        String horario = "08:00-10:00";

        Professor professor = new Professor();
        professor.setId(1L);

        Turma turma = new Turma();
        turma.setCodigo(1L);
        turma.setProfessor(professor);

        Recurso recurso = new Recurso();
        recurso.setCodigo(1L);

        Reserva reserva = new Reserva(null, data, horario, turma, recurso);

        when(aulaRepository.existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), data, horario)).thenReturn(true);

        when(reservaRepository.existsByRecursoCodigoAndDataAndHorario(
                recurso.getCodigo(), data, horario)).thenReturn(false);

        when(reservaRepository.existsByTurmaProfessorIdAndDataAndHorario(
                professor.getId(), data, horario)).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            reservaService.criarReserva(reserva);
        });

        assertEquals("Professor já possui uma reserva neste horário.", exception.getMessage());
        verify(aulaRepository, times(1)).existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), data, horario);
        verify(reservaRepository, times(1)).existsByRecursoCodigoAndDataAndHorario(
                recurso.getCodigo(), data, horario);
        verify(reservaRepository, times(1)).existsByTurmaProfessorIdAndDataAndHorario(
                professor.getId(), data, horario);
        verify(reservaRepository, never()).save(reserva);
    }

    @Test
    public void testListarPorData() {
        LocalDate data = LocalDate.of(2024, 10, 17);

        Reserva reserva1 = new Reserva();
        Reserva reserva2 = new Reserva();

        List<Reserva> reservasMock = Arrays.asList(reserva1, reserva2);

        when(reservaRepository.findByData(data)).thenReturn(reservasMock);

        List<Reserva> reservas = reservaService.listarPorData(data);

        assertNotNull(reservas);
        assertEquals(2, reservas.size());
        verify(reservaRepository, times(1)).findByData(data);
    }

    @Test
    public void testListarPorTurma() {
        Long turmaCodigo = 1L;

        Reserva reserva1 = new Reserva();
        Reserva reserva2 = new Reserva();

        List<Reserva> reservasMock = Arrays.asList(reserva1, reserva2);

        when(reservaRepository.findByTurmaCodigo(turmaCodigo)).thenReturn(reservasMock);

        List<Reserva> reservas = reservaService.listarPorTurma(turmaCodigo);

        assertNotNull(reservas);
        assertEquals(2, reservas.size());
        verify(reservaRepository, times(1)).findByTurmaCodigo(turmaCodigo);
    }

    @Test
    public void testDeletarPorId() {
        Long id = 1L;

        doNothing().when(reservaRepository).deleteById(id);

        reservaService.deletarPorId(id);

        verify(reservaRepository, times(1)).deleteById(id);
    }
}
