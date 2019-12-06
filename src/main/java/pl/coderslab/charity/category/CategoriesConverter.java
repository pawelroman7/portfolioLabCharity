package pl.coderslab.charity.category;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoriesConverter implements Converter<String, CategoryEntity> {

    private final CategoryService categoryService;

    public CategoriesConverter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public CategoryEntity convert(String s) {
        String[]data = s.split(",");

        return categoryService.findById(Long.parseLong(data[0]));
    }
}
