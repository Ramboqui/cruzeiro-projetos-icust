package com.cruzeiro.icust.controllers;

import com.cruzeiro.icust.model.dto.ICustPedidoDTO;
import com.cruzeiro.icust.model.entities.ICustPedidosEntity;
import com.cruzeiro.icust.model.request.ICustPedidosRequest;
import com.cruzeiro.icust.services.ICustPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/icust/pedido")
@RequiredArgsConstructor
public class ICustPedidoController {

	private final ICustPedidoService iCustPedidoService;

	@GetMapping("/{id}")
	public ResponseEntity<ICustPedidoDTO> getICustOrder(@PathVariable Integer id) {
		return ResponseEntity.ok(iCustPedidoService.getOrderById(id));
	}

	@GetMapping
	public ResponseEntity<List<ICustPedidoDTO>> getICustOrderList() {
		return ResponseEntity.ok(iCustPedidoService.getOrdersList());
	}

	@PostMapping
	public ResponseEntity<ICustPedidoDTO> postICustOrderList(@RequestBody ICustPedidosRequest iCustPedidosRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(iCustPedidoService.postOrdersList(iCustPedidosRequest));
	}
}
