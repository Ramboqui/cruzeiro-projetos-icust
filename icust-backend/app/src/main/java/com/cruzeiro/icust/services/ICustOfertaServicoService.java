package com.cruzeiro.icust.services;

import com.cruzeiro.icust.model.dto.ICustOfertaServicoDTO;
import com.cruzeiro.icust.model.entities.ICustOfertaServicoEntity;
import com.cruzeiro.icust.model.entities.ICustTipoOfertaServicoEntity;
import com.cruzeiro.icust.repositories.ICustOfertaServicoRepository;
import com.cruzeiro.icust.repositories.ICustTipoOfertaServicoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.cruzeiro.icust.repositories.specifications.ICustOfertaServicoSpecification.query;
import static com.cruzeiro.icust.repositories.specifications.ICustOfertaServicoSpecification.tipo;

@Service
@RequiredArgsConstructor
public class ICustOfertaServicoService {
	private final ICustOfertaServicoRepository iCustOfertaServicoRepository;
	private final ICustTipoOfertaServicoRepository iCustTipoOfertaServicoRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public List<ICustTipoOfertaServicoEntity> getTipoOfertaServicoList() {
		return iCustTipoOfertaServicoRepository.findAll();
	}

	public List<ICustOfertaServicoDTO> getOfertaServicoList(String query, Integer tipo) {
		return iCustOfertaServicoRepository.findAll(query(query).and(tipo(tipo))).stream()
		                                   .map(os -> modelMapper.map(os, ICustOfertaServicoDTO.class)).collect(
						Collectors.toList());
	}

	public ICustOfertaServicoDTO getOfertaServico(Integer id) {
		return modelMapper.map(iCustOfertaServicoRepository.findById(id).orElseThrow(), ICustOfertaServicoDTO.class);
	}
}
