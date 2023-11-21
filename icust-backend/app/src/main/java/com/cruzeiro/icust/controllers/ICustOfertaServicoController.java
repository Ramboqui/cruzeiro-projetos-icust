package com.cruzeiro.icust.controllers;

import com.cruzeiro.icust.model.dto.ICustOfertaServicoDTO;
import com.cruzeiro.icust.model.entities.ICustOfertaServicoEntity;
import com.cruzeiro.icust.model.entities.ICustTipoOfertaServicoEntity;
import com.cruzeiro.icust.services.ICustOfertaServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/icust/oferta-servico")
@RequiredArgsConstructor
public class ICustOfertaServicoController {

	private final ICustOfertaServicoService iCustOfertaServicoService;

	@GetMapping("/tipo")
	public ResponseEntity<List<ICustTipoOfertaServicoEntity>> getTipoOfertaServicoList() {
		return ResponseEntity.ok(iCustOfertaServicoService.getTipoOfertaServicoList());
	}

	@GetMapping
	public ResponseEntity<List<ICustOfertaServicoDTO>> getOfertaServicoList(
			@RequestParam(required = false) String query,
			@RequestParam(required = false) Integer tipo
	) {
		return ResponseEntity.ok(iCustOfertaServicoService.getOfertaServicoList(query, tipo));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ICustOfertaServicoDTO> getOfertaServico(
			@PathVariable Integer id
	) {
		return ResponseEntity.ok().body(iCustOfertaServicoService.getOfertaServico(id));
	}

}
