package com.SARC.SARC.service;

import com.SARC.domain.Aula;
import com.SARC.domain.Turma;
import com.SARC.repository.AulaRepository;
import com.SARC.service.AulaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AulaServiceTest{

    @Mock
    private AulaRepository aulaRepository;

    @InjectMocks
    private AulaService aulaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarPorTurma() {
        Long turmaCodigo = 1L;

        Turma turma = new Turma();
        turma.setCodigo(turmaCodigo);

        Aula aula1 = new Aula(1L, LocalDate.of(2024, 10, 17), "08:00-10:00", turma);
        Aula aula2 = new Aula(2L, LocalDate.of(2024, 10, 18), "10:00-12:00", turma);

        List<Aula> aulasMock = Arrays.asList(aula1, aula2);

        when(aulaRepository.findByTurmaCodigo(turmaCodigo)).thenReturn(aulasMock);

        List<Aula> aulas = aulaService.listarPorTurma(turmaCodigo);

        assertNotNull(aulas);
        assertEquals(2, aulas.size());
        verify(aulaRepository, times(1)).findByTurmaCodigo(turmaCodigo);
    }

    @Test
    public void testSalvarAulaComSucesso() {
        Turma turma = new Turma();
        turma.setCodigo(1L);

        Aula aula = new Aula(null, LocalDate.of(2024, 10, 17), "08:00-10:00", turma);

        when(aulaRepository.existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), aula.getData(), aula.getHorario())).thenReturn(false);

        when(aulaRepository.save(aula)).thenReturn(aula);

        Aula aulaSalva = aulaService.salvar(aula);

        assertNotNull(aulaSalva);
        verify(aulaRepository, times(1)).existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), aula.getData(), aula.getHorario());
        verify(aulaRepository, times(1)).save(aula);
    }

    @Test
    public void testSalvarAulaComConflito() {
        Turma turma = new Turma();
        turma.setCodigo(1L);

        Aula aula = new Aula(null, LocalDate.of(2024, 10, 17), "08:00-10:00", turma);

        when(aulaRepository.existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), aula.getData(), aula.getHorario())).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            aulaService.salvar(aula);
        });

        assertEquals("Já existe uma aula para esta turma neste horário.", exception.getMessage());
        verify(aulaRepository, times(1)).existsByTurmaCodigoAndDataAndHorario(
                turma.getCodigo(), aula.getData(), aula.getHorario());
        verify(aulaRepository, never()).save(aula);
    }

    @Test
    public void testDeletarPorId() {
        Long id = 1L;

        doNothing().when(aulaRepository).deleteById(id);

        aulaService.deletarPorId(id);

        verify(aulaRepository, times(1)).deleteById(id);
    }
}
