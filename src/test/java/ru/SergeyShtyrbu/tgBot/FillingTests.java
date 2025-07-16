package ru.SergeyShtyrbu.tgBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;
import ru.SergeyShtyrbu.tgBot.entity.Category;
import ru.SergeyShtyrbu.tgBot.entity.Product;
import ru.SergeyShtyrbu.tgBot.repository.CategoryRepository;
import ru.SergeyShtyrbu.tgBot.repository.ProductRepository;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

@SpringBootTest
public class FillingTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void fillTestData() {
        // Создание категорий
        Category pizza = new Category();
        pizza.setName("Пицца");
        Category savedPizza = categoryRepository.save(pizza);
        assertNotNull(savedPizza.getId(), "Pizza category should have an ID");
        assertEquals(savedPizza.getName(), "Пицца", "Pizza category name should match");

        Category rolls = new Category();
        rolls.setName("Роллы");
        Category savedRolls = categoryRepository.save(rolls);
        assertNotNull(savedRolls.getId(), "Rolls category should have an ID");

        Category burgers = new Category();
        burgers.setName("Бургеры");
        Category savedBurgers = categoryRepository.save(burgers);
        assertNotNull(savedBurgers.getId(), "Burgers category should have an ID");

        Category drinks = new Category();
        drinks.setName("Напитки");
        Category savedDrinks = categoryRepository.save(drinks);
        assertNotNull(savedDrinks.getId(), "Drinks category should have an ID");

        // Подкатегории для роллов
        Category classicRolls = new Category();
        classicRolls.setName("Классические роллы");
        classicRolls.setParent(savedRolls);
        Category savedClassicRolls = categoryRepository.save(classicRolls);
        assertNotNull(savedClassicRolls.getId(), "Classic Rolls category should have an ID");
        assertEquals(savedClassicRolls.getParent().getId(), savedRolls.getId(), "Classic Rolls parent should match");

        Category bakedRolls = new Category();
        bakedRolls.setName("Запеченные роллы");
        bakedRolls.setParent(savedRolls);
        Category savedBakedRolls = categoryRepository.save(bakedRolls);
        assertNotNull(savedBakedRolls.getId(), "Baked Rolls category should have an ID");

        Category sweetRolls = new Category();
        sweetRolls.setName("Сладкие роллы");
        sweetRolls.setParent(savedRolls);
        Category savedSweetRolls = categoryRepository.save(sweetRolls);
        assertNotNull(savedSweetRolls.getId(), "Sweet Rolls category should have an ID");

        Category rollSets = new Category();
        rollSets.setName("Наборы");
        rollSets.setParent(savedRolls);
        Category savedRollSets = categoryRepository.save(rollSets);
        assertNotNull(savedRollSets.getId(), "Roll Sets category should have an ID");

        // Создание продуктов
        Product p1 = new Product();
        p1.setName("Ролл Филадельфия");
        p1.setDescription("Лосось, сыр, огурец");
        p1.setPrice(390.0);
        p1.setCategory(savedClassicRolls);
        Product savedP1 = productRepository.save(p1);
        assertNotNull(savedP1.getId(), "Product Philadelphia should have an ID");
        assertEquals(savedP1.getName(), "Ролл Филадельфия", "Product name should match");
        assertEquals(savedP1.getPrice(), 390.0, "Product price should match");

        Product p2 = new Product();
        p2.setName("Ролл Калифорния");
        p2.setDescription("Краб, авокадо");
        p2.setPrice(340.0);
        p2.setCategory(savedClassicRolls);
        Product savedP2 = productRepository.save(p2);
        assertNotNull(savedP2.getId(), "Product California should have an ID");

        Product p3 = new Product();
        p3.setName("Ролл Осака");
        p3.setDescription("Тунец, сыр, огурец");
        p3.setPrice(370.0);
        p3.setCategory(savedClassicRolls);
        Product savedP3 = productRepository.save(p3);
        assertNotNull(savedP3.getId(), "Product Osaka should have an ID");
    }
}