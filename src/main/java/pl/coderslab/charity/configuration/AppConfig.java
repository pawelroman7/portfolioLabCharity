package pl.coderslab.charity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.coderslab.charity.category.CategoriesConverter;
import pl.coderslab.charity.institution.InstitutionsConverter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    private final InstitutionsConverter institutionsConverter;
    private final CategoriesConverter categoriesConverter;

    public AppConfig(InstitutionsConverter institutionsConverter, CategoriesConverter categoriesConverter) {
        this.institutionsConverter = institutionsConverter;
        this.categoriesConverter = categoriesConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(institutionsConverter);
        registry.addConverter(categoriesConverter);
        super.addFormatters(registry);
    }
}
