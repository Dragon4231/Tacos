package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.Ingridient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingridient> ingredients = Arrays.asList(
                new Ingridient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingridient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingridient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingridient("CARN", "Carnitas", Type.PROTEIN),
                new Ingridient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingridient("LETC", "Lettuce", Type.VEGGIES),
                new Ingridient("CHED", "Cheddar", Type.CHEESE),
                new Ingridient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingridient("SLSA", "Salsa", Type.SAUCE),
                new Ingridient("SRCR", "Sour Cream", Type.SAUCE)
        );
        Type[] types = Ingridient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }
    private Iterable<Ingridient> filterByType(List<Ingridient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}