package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            // Инициализация Gson и чтение данных
            Gson gson = new Gson();
            FileReader reader = new FileReader("src/main/resources/books.json");
            Type visitorListType = new TypeToken<List<Visitor>>() {}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);

            // 1. Список посетителей и их количество
            System.out.println("Задание 1: Список всех посетителей библиотеки");
            visitors.stream()
                    .map(visitor -> visitor.getName() + " " + visitor.getSurname())
                    .forEach(System.out::println);
            System.out.println("Общее количество посетителей: " + visitors.size());

            // 2. Уникальные книги и их количество
            System.out.println("\nЗадание 2: Уникальные книги, добавленные в избранное");
            Set<Book> favoriteBooks = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .collect(Collectors.toSet());
            favoriteBooks.forEach(book -> System.out.println(book.getName()));
            System.out.println("Количество уникальных книг: " + favoriteBooks.size());

            // 3. Сортировка книг по году публикации
            System.out.println("\nЗадание 3: Список книг, отсортированный по году выпуска");
            favoriteBooks.stream()
                    .sorted(Comparator.comparing(Book::getPublishingYear))
                    .forEach(book -> System.out.println(book.getName() + " (" + book.getPublishingYear() + ")"));

            // 4. Проверка наличия книги Jane Austen
            boolean hasBookByJaneAusten = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .anyMatch(book -> "Jane Austen".equalsIgnoreCase(book.getAuthor()));
            System.out.println("\nЗадание 4: Есть ли книги Jane Austen в избранном: " + (hasBookByJaneAusten ? "Да" : "Нет"));

            // 5. Максимальное количество избранных книг
            int maxFavorites = visitors.stream()
                    .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                    .max()
                    .orElse(0);
            System.out.println("\nЗадание 5: Максимальное количество избранных книг у одного посетителя: " + maxFavorites);

            // 6. Создание SMS-сообщений для подписчиков
            System.out.println("\nЗадание 6: SMS-сообщения для подписчиков");
            double averageBooks = visitors.stream()
                    .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                    .average()
                    .orElse(0);
            visitors.stream()
                    .filter(Visitor::isSubscribed)
                    .map(visitor -> {
                        String message;
                        int bookCount = visitor.getFavoriteBooks().size();
                        if (bookCount > averageBooks) {
                            message = "you are a bookworm";
                        } else if (bookCount < averageBooks) {
                            message = "read more";
                        } else {
                            message = "fine";
                        }
                        return new SmsMessage(visitor.getPhone(), message);
                    })
                    .forEach(sms -> System.out.println("To: " + sms.getPhoneNumber() + " - " + sms.getMessage()));

        } catch (Exception e) {
            System.err.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }
}




