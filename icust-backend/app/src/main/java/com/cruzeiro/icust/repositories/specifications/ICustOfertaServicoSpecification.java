package com.cruzeiro.icust.repositories.specifications;

import com.cruzeiro.icust.model.entities.ICustOfertaServicoEntity;
import com.cruzeiro.icust.model.entities.ICustTipoOfertaServicoEntity_;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static com.cruzeiro.icust.model.entities.ICustOfertaServicoEntity_.*;

@Component
public class ICustOfertaServicoSpecification {

	public static Specification<ICustOfertaServicoEntity> query(String text) {
		if (text == null || StringUtils.isEmpty(text)) {
			return (ofertaServico, cq, cb) -> cb.isTrue(cb.literal(true));
		}
		String query = "%" + text + "%";
		return (ofertaServico, cq, cb) -> cb.or(
				cb.like(ofertaServico.get(TITULO), query),
				cb.like(ofertaServico.get(TIPO_DE_SERVICO)
				                     .get(ICustTipoOfertaServicoEntity_.NOME_TIPO_OFERTA_SERVICO), query),
//				cb.like(ofertaServico.get(MODELO_DA_PECA), query),
				cb.like(ofertaServico.get(PRESTADOR), query),
				cb.like(ofertaServico.get(DESCRICAO), query)
//				cb.like(ofertaServico.get(MODELO_DA_PECA), query)
//				cb.like(cb.function("JSON_CONTAINS", String.class), )
		);
	}

	public static Specification<ICustOfertaServicoEntity> tipo(Integer tipoOfertaServico) {
		if (tipoOfertaServico == null) {
			return (ofertaServico, cq, cb) -> cb.isTrue(cb.literal(true));
		}
		return (ofertaServico, cq, cb) -> cb.equal(
				ofertaServico.get(TIPO_DE_SERVICO).get(ICustTipoOfertaServicoEntity_.ID_TIPO_OFERTA_SERVICO),
				tipoOfertaServico);
	}

}
