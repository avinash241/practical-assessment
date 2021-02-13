package com.example.demo.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

public class LowerCaseClassNameResolver extends TypeIdResolverBase{
	
	@Override
	public String idFromValue(Object value) {
		// TODO Auto-generated method stub
		return value.getClass().getSimpleName().toLowerCase();
	}
	
	@Override
	public String idFromValueAndType(Object value, Class<?> suggestedType) {
		// TODO Auto-generated method stub
		return idFromValue(value);
	}
	
	@Override
	public Id getMechanism() {
		// TODO Auto-generated method stub
		return JsonTypeInfo.Id.CUSTOM;
	}

	@Override
	public String getDescForKnownTypeIds() {
		// TODO Auto-generated method stub
		return super.getDescForKnownTypeIds();
	}

	@Override
	public String idFromBaseType() {
		// TODO Auto-generated method stub
		return super.idFromBaseType();
	}

	@Override
	public void init(JavaType bt) {
		// TODO Auto-generated method stub
		super.init(bt);
	}

	@Override
	public JavaType typeFromId(DatabindContext context, String id) throws IOException {
		// TODO Auto-generated method stub
		return super.typeFromId(context, id);
	}
	
	

}
