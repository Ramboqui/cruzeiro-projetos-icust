package com.cruzeiro.icust.services;

import com.cruzeiro.icust.model.dto.ICustPedidoDTO;
import com.cruzeiro.icust.model.entities.ICustOfertaServicoEntity;
import com.cruzeiro.icust.model.entities.ICustPedidosEntity;
import com.cruzeiro.icust.model.entities.user.ClienteEntity;
import com.cruzeiro.icust.model.request.ICustPedidosRequest;
import com.cruzeiro.icust.repositories.ClienteRepository;
import com.cruzeiro.icust.repositories.ICustOfertaServicoRepository;
import com.cruzeiro.icust.repositories.ICustPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ICustPedidoService {

	private final ICustPedidoRepository iCustPedidoRepository;
	private final ClienteRepository clienteRepository;
	private final ICustOfertaServicoRepository iCustOfertaServicoRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public List<ICustPedidoDTO> getOrdersList() {
		return iCustPedidoRepository.findAll().stream().map(pedido -> modelMapper.map(pedido, ICustPedidoDTO.class))
		                            .collect(Collectors.toList());
	}

	public ICustPedidoDTO postOrdersList(ICustPedidosRequest iCustPedidosRequest) {
		ICustPedidosEntity iCustPedidosEntity = modelMapper.map(iCustPedidosRequest, ICustPedidosEntity.class);
		ICustOfertaServicoEntity servico = iCustOfertaServicoRepository.findById(iCustPedidosRequest.getServicoID())
		                                                               .orElseThrow();
		ClienteEntity cliente = clienteRepository.findById(iCustPedidosRequest.getClienteID()).orElseThrow();
		iCustPedidosEntity.setCliente(cliente);
		iCustPedidosEntity.setServico(servico);
		iCustPedidosEntity.setNomePrestadora(servico.getPrestador().getNome());
		return modelMapper.map(iCustPedidoRepository.save(iCustPedidosEntity), ICustPedidoDTO.class);
	}

	public ICustPedidoDTO getOrderById(Integer id) {
		return modelMapper.map(iCustPedidoRepository.findById(id).orElseThrow(), ICustPedidoDTO.class);
	}
}
