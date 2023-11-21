//package com.cruzeiro.icust.utils;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.persistence.AttributeConverter;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@RequiredArgsConstructor
//@Slf4j
//public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {
//
//	private final ObjectMapper objectMapper;
//
//	@Override
//	public String convertToDatabaseColumn(Map<String, Object> customerInfo) {
//
//		String customerInfoJson = null;
//		try {
//			customerInfoJson = objectMapper.writeValueAsString(customerInfo);
//		} catch (final JsonProcessingException e) {
//			log.error("JSON writing error", e);
//		}
//
//		return customerInfoJson;
//	}
//
//	@Override
//	public Map<String, Object> convertToEntityAttribute(String customerInfoJSON) {
//
//		Map<String, Object> customerInfo = null;
//		try {
//			customerInfo = objectMapper
//					.readValue(customerInfoJSON,
//					           new TypeReference<HashMap<String, Object>>() {
//					           });
//		} catch (final IOException e) {
//			log.error("JSON reading error", e);
//		}
//
//		return customerInfo;
//	}
//}