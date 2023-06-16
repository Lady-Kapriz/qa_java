package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest extends TestCase {
    private Animal animal;
    private static final String ANIMAL_KIND_HERBIVORE = "Травоядное";
    private static final String ANIMAL_KIND_PREDATOR = "Хищник";
    private static final String UNSUPPORTED_ANIMAL_KIND = "unsupported animal kind";
    private static final String TEXT_EXCEPTION = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private static final List<String> FOODS_HERBIVORE = List.of("Трава", "Различные растения");
    private static final List<String> FOODS_PREDATOR = List.of("Животные", "Птицы", "Рыба");
    private static final String family = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private String animalKind;
    private List<String> foods;

    public AnimalTest(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {ANIMAL_KIND_HERBIVORE, FOODS_HERBIVORE},
                {ANIMAL_KIND_PREDATOR, FOODS_PREDATOR},
                {UNSUPPORTED_ANIMAL_KIND, List.of()}
        };
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFood() {

        try {
            List<String> actual = animal.getFood(animalKind);
            assertEquals("Список еды для животных не совпадает с ожидаемым",
                    foods, actual);
        } catch (Exception e) {
            assertEquals(TEXT_EXCEPTION, e.getMessage());
        }
    }

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();

        assertEquals("Ответ не соответствует ожидаемому",
                family, actual);
    }
}