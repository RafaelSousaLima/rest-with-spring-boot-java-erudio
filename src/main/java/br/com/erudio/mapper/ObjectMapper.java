package br.com.erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O object, Class<D> destinationClass) {
        return mapper.map(object, destinationClass);
    }

    public static <O, D> List<D> parseList(List<O> origin, Class<D> destinationClass) {
        List<D> destinationList = new ArrayList<>();
        for (O object : origin) {
            destinationList.add(parseObject(object, destinationClass));
        }
        return destinationList;
    }

}
