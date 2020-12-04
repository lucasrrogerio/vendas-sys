package br.com.uff.vendasys.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component("mapperUtil")
public class MapperUtil {

    private static MapperUtil instance;
    protected ModelMapper mapper;

    private MapperUtil() {
        mapper = new ModelMapper();
    }

    public static MapperUtil getInstance() {
        if(instance == null) {
            instance = new MapperUtil();
        }
        return instance;
    }

    public <S, T> T mapTo(S source, Class<T> targetClass) {
        return mapper.map(source, targetClass);
    }

    public <S, T> List<T> toList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream()
                .map(source -> mapper.map(source, targetClass))
                .collect(Collectors.toList());
    }
}
