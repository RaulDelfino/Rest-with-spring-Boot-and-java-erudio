package br.com.erudio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;



public class Mapper {
    
   private static ModelMapper mapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination){
            
        List<D> destinationsObjects = new ArrayList<D>();
        for (O o : origin) {
            destinationsObjects.add(mapper.map(o, destination));
        }
        return destinationsObjects;
    }

}
