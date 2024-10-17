package com.SARC.SARC.service;

import com.SARC.domain.Disciplina;
import com.SARC.repository.DisciplinaRepository;
import com.SARC.service.DisciplinaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DisciplinaServiceTest {

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @InjectMocks
    private DisciplinaService disciplinaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarTodas() {
        Disciplina disciplina1 = new Disciplina(1L, "Matemática", 60);
        Disciplina disciplina2 = new Disciplina(2L, "Física", 60);

        List<Disciplina> disciplinasMock = Arrays.asList(disciplina1, disciplina2);

        when(disciplinaRepository.findAll()).thenReturn(disciplinasMock);

        List<Disciplina> disciplinas = disciplinaService.listarTodas();

        assertNotNull(disciplinas);
        assertEquals(2, disciplinas.size());
        verify(disciplinaRepository, times(1)).findAll();
    }

    @Test
    public void testObterPorCodigoExistente() {
        Long codigo = 1L;
        Disciplina disciplina = new Disciplina(codigo, "Matemática", 60);

        when(disciplinaRepository.findById(codigo)).thenReturn(Optional.of(disciplina));

        Disciplina resultado = disciplinaService.obterPorCodigo(codigo);

        assertNotNull(resultado);
        assertEquals(codigo, resultado.getCodigo());
        verify(disciplinaRepository, times(1)).findById(codigo);
    }

    @Test
    public void testObterPorCodigoInexistente() {
        Long codigo = 1L;

        when(disciplinaRepository.findById(codigo)).thenReturn(Optional.empty());

        Disciplina resultado = disciplinaService.obterPorCodigo(codigo);

        assertNull(resultado);
        verify(disciplinaRepository, times(1)).findById(codigo);
    }

    @Test
    public void testSalvarDisciplinaNova() {
        Disciplina disciplina = new Disciplina(1L, "Química", 60);

        when(disciplinaRepository.existsByCodigo(disciplina.getCodigo())).thenReturn(false);
        when(disciplinaRepository.save(disciplina)).thenReturn(disciplina);

        Disciplina resultado = disciplinaService.salvar(disciplina);

        assertNotNull(resultado);
        assertEquals(disciplina.getCodigo(), resultado.getCodigo());
        verify(disciplinaRepository, times(1)).existsByCodigo(disciplina.getCodigo());
        verify(disciplinaRepository, times(1)).save(disciplina);
    }

    @Test
    public void testSalvarDisciplinaExistente() {
        Disciplina disciplina = new Disciplina(1L, "Biologia", 60);

        when(disciplinaRepository.existsByCodigo(disciplina.getCodigo())).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            disciplinaService.salvar(disciplina);
        });

        assertEquals("Código de disciplina já existe.", exception.getMessage());
        verify(disciplinaRepository, times(1)).existsByCodigo(disciplina.getCodigo());
        verify(disciplinaRepository, never()).save(disciplina);
    }

    @Test
    public void testDeletarPorCodigo() {
        Long codigo = 1L;

        doNothing().when(disciplinaRepository).deleteById(codigo);

        disciplinaService.deletarPorCodigo(codigo);

        verify(disciplinaRepository, times(1)).deleteById(codigo);
    }
}
