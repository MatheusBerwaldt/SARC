package com.SARC.controller;

import com.SARC.domain.Reserva;
import com.SARC.service.ReservaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> listarPorData(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return reservaService.listarPorData(data);
    }

    @GetMapping("/class/{turmaCodigo}")
    public List<Reserva> listarPorTurma(@PathVariable Long turmaCodigo) {
        return reservaService.listarPorTurma(turmaCodigo);
    }

    @PostMapping
    public Reserva criarReserva(@RequestBody Reserva reserva) {
        return reservaService.criarReserva(reserva);
    }

    @DeleteMapping("/{id}")
    public void deletarReserva(@PathVariable Long id) {
        reservaService.deletarPorId(id);
    }
}
