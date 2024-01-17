package com.tobeto.a.spring.intro.core.utilities.mappers;
import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
