package br.com.uff.vendasys.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component("mapperUtil")
public class MapperUtil {

    private static MapperUtil INSTANCE;
    protected ModelMapper mapper;

    private MapperUtil() {
        mapper = new ModelMapper();
    }

    public static MapperUtil getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MapperUtil();
        }
        return INSTANCE;
    }

    public <S, T> T mapTo(S source, Class<T> targetClass) {
        return mapper.map(source, targetClass);
    }

    public <S, T> List<T> toList(List<S> sourceList, Type targetClass) {
        return mapper.map(sourceList, targetClass);
    }
}
