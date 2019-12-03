package pl.coderslab.charity.category;

import lombok.Data;

@Data
public class CategoryDTO {

    private String name;

    @Override
    public String toString() {
        return  name;
    }
}
