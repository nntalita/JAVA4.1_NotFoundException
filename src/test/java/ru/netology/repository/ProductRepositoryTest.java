package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Product first = new Product(1111, "стол", 1000);
    private Book second = new Book(11112, "Синяя", 100, "Папа Карло", 158, 2021);
    private TShirt third = new TShirt(44569, "Abibas", 5000, "Yellow", "M");
    private TShirt fourth = new TShirt(4589, "Puma", 1200, "Red", "XL");
    private Book fifth = new Book(5512555, "Букварь", 190, "Папа Карло", 200, 1999);


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }


    @Test
    public void shouldRemoveById() {
        repository.removeById(5512555);
        Product[] actual = repository.findAll();
        Product[] expected = {first, second, third, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldDeleteByMissingId() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-2);
        });
    }
}
