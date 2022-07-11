package com.example.demo;

//import org.springframework.cglib.core.Converter;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.Ingridient.Type;
import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingridient> {
    private Map<String,Ingridient> ingridientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingridientMap.put("FLTO",
                new Ingridient("FLTO", "Flour Tortilla", Type.WRAP));
        ingridientMap.put("COTO",
                new Ingridient("COTO", "Corn Tortilla", Type.WRAP));
        ingridientMap.put("GRBF",
                new Ingridient("GRBF", "Ground Beef", Type.PROTEIN));
        ingridientMap.put("CARN",
                new Ingridient("CARN", "Carnitas", Type.PROTEIN));
        ingridientMap.put("TMTO",
                new Ingridient("TMTO", "Diced Tomatoes", Type.VEGGIES));
        ingridientMap.put("LETC",
                new Ingridient("LETC", "Lettuce", Type.VEGGIES));
        ingridientMap.put("CHED",
                new Ingridient("CHED", "Cheddar", Type.CHEESE));
        ingridientMap.put("JACK",
                new Ingridient("JACK", "Monterrey Jack", Type.CHEESE));
        ingridientMap.put("SLSA",
                new Ingridient("SLSA", "Salsa", Type.SAUCE));
        ingridientMap.put("SRCR",
                new Ingridient("SRCR", "Sour Cream", Type.SAUCE));
    }

    @Override
    public Ingridient convert(String id) {
        return ingridientMap.get(id);
    }

}
