import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import models.Book;

public class App {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("El Quijote", "Cervantes", 39.99),
                new Book("Cien años de soledad", "Gabriel García Márquez", 45.50),
                new Book("Clean Code", "Robert C. Martin", 55.00),
                new Book("Effective Java", "Joshua Bloch", 70.00),
                new Book("The Pragmatic Programmer", "Andy Hunt", 65.00),
                new Book("Design Patterns", "Erich Gamma", 80.00),
                new Book("Introduction to Algorithms", "Thomas H. Cormen", 90.00),
                new Book("The Art of Computer Programming", "Donald E. Knuth", 120.00),
                new Book("Artificial Intelligence: A Modern Approach", "Stuart Russell", 100.00),
                new Book("Refactoring", "Martin Fowler", 60.00),
                new Book("Structure and Interpretation of Computer Programs", "Harold Abelson", 85.00),
                new Book("Code Complete", "Steve McConnell", 58.00),
                new Book("Patterns of Enterprise Application Architecture", "Martin Fowler", 75.00),
                new Book("Domain-Driven Design", "Eric Evans", 68.00),
                new Book("Working Effectively with Legacy Code", "Michael Feathers", 62.00),
                new Book("Head First Design Patterns", "Eric Freeman", 54.00),
                new Book("Programming Pearls", "Jon Bentley", 47.00),
                new Book("Algorithms", "Robert Sedgewick", 73.00),
                new Book("Java Concurrency in Practice", "Brian Goetz", 66.00),
                new Book("The Mythical Man-Month", "Frederick P. Brooks Jr.", 52.00),
                new Book("The Clean Coder", "Robert C. Martin", 53.00),
                new Book("Continuous Delivery", "Jez Humble", 77.00),
                new Book("Test Driven Development", "Kent Beck", 49.00),
                new Book("Agile Software Development", "Alistair Cockburn", 61.00),
                new Book("The Phoenix Project", "Gene Kim", 59.00),
                new Book("You Don't Know JS", "Kyle Simpson", 42.00),
                new Book("Cracking the Coding Interview", "Gayle Laakmann McDowell", 65.00),
                new Book("Soft Skills", "John Sonmez", 56.00),
                new Book("Don't Make Me Think", "Steve Krug", 44.00),
                new Book("The DevOps Handbook", "Gene Kim", 74.00),
                new Book("Refactoring to Patterns", "Joshua Kerievsky", 63.00),
                new Book("The Passionate Programmer", "Chad Fowler", 48.00),
                new Book("The Pragmatic Programmer: 20th Anniversary Edition", "Andy Hunt", 68.00),
                new Book("Extreme Programming Explained", "Kent Beck", 51.00),
                new Book("The Software Craftsman", "Sandro Mancuso", 57.00),
                new Book("Growing Object-Oriented Software", "Steve Freeman", 69.00),
                new Book("The Manager's Path", "Camille Fournier", 55.00),
                new Book("Building Microservices", "Sam Newman", 72.00),
                new Book("Release It!", "Michael T. Nygard", 64.00),
                new Book("Peopleware", "Tom DeMarco", 50.00));

        // mostrar todos los libros
        System.out.println("Lista de libros:");
        books.stream()
                .forEach(book -> System.out.println(book));

        // books.stream()
        // .forEach(System.out::println);

        // Filtrar libros que cuesten más de $50 (filter + Predicate)
        System.out.println("\nLibros que cuestan más de $50:");
        books.stream()
                .filter(book -> book.getPrice() > 50)
                .forEach(System.out::println);

        // Obtener solo los títulos en mayúsculas (map + Function)
        System.out.println("\nTítulos de libros en mayúsculas:");
        books.stream()
                .filter(book -> book.getPrice() > 50)
                .forEach(System.out::println);

        // Recopilar libros baratos (collect + Predicate + Collectors)
        System.out.println("\nLibros que cuestan $50 o menos:");
        List<Book> cheapBooks = books.stream()
                .filter(book -> book.getPrice() < 50)
                .collect(Collectors.toList());

        cheapBooks.forEach(System.out::println);

        // Obtener el precio total de todos los libros (reduce + BinaryOperator)
        System.out.println("\nPrecio total de todos los libros:");
        double totalPrice = books.stream()
                .map(Book::getPrice)
                .reduce(0.0, (a, b) -> a + b);

        System.out.println("Total: $" + totalPrice);

        // ¿Hay algún libro de “Robert C. Martin”? (anyMatch + Predicate)
        System.out.println("\n¿Hay algún libro de 'Robert C. Martin'?");
        boolean hasMartin = books.stream()
                .anyMatch(book -> book.getAuthor().equals("Robert C. Martin"));

        System.out.println("¿Hay libro de Martin? " + hasMartin);

        // Eliminar duplicados por título (distinct + Comparator)
        System.out.println("\nLibros sin duplicados por título:");
        List<String> titles = books.stream()
                .map(Book::getTitle)
                .distinct()
                .collect(Collectors.toList());

        titles.forEach(System.out::println);

        // Limitar y saltar libros (limit + skip)
        System.out.println("\nPrimeros 5 libros:");
        // Mostrar los dos primeros libros
        books.stream()
                .limit(2)
                .forEach(System.out::println);

        // Omitir los dos primeros libros
        books.stream()
                .skip(2)
                .forEach(System.out::println);

        // Ordenar por precio (sorted + Comparator)
        System.out.println("\nLibros ordenados por precio:");
        books.stream()
                .sorted(Comparator.comparing(Book::getPrice))
                .forEach(System.out::println);

        // Evaluación
        // 1. ¿Qué operador usarías para transformar una lista de títulos a mayúsculas?
        System.out.println("\n--- Evaluación ---\n");
        System.out.println("--- 1. Títulos en Mayúsculas (map) ---\n");
        List<String> titulosEnMayusculas = books.stream()
                .map(Book::getTitle)
                .map(String::toUpperCase)
                .toList();

        titulosEnMayusculas.forEach(System.out::println);

        // 2. ¿Cómo verificarías si todos los libros cuestan menos de $100?
        System.out.println("\n--- 2. ¿Todos los libros cuestan menos de $100? (allMatch) ---\n");
        boolean todosMenosDe100 = books.stream()
                .allMatch(book -> book.getPrice() < 100.00);

        System.out
                .println(todosMenosDe100 ? "Sí, todos cuestan menos de $100." : "No, no todos cuestan menos de $100.");

        // 3. Escribe una expresión lambda que retorne true si el autor es "Gabriel García Márquez".
        System.out.println("\n--- 3. Libros de Gabriel García Márquez (filter) ---\n");
        List<Book> librosDeGabo = books.stream()
                .filter(book -> book.getAuthor().equals("Gabriel García Márquez"))
                .toList();

        librosDeGabo.forEach(System.out::println);
    }

}

