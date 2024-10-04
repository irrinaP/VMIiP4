package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задание (1-5):");

        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            executeTask(taskNumber);
        } catch (NumberFormatException e) {
            System.out.println("Введите корректный номер.");
        }

        scanner.close();
    }

    private static void executeTask(int taskNumber) {
        switch (taskNumber) {
            case 1 -> taskWithCollections();
            case 2 -> generatePrimes();
            case 3 -> handleHumans();
            case 4 -> countWordFrequenciesTask();
            case 5 -> switchMapKeysValues();
            default -> System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }

    private static void taskWithCollections() {
        int[] randomArray = MyCollections.createRandomArray(10);
        System.out.println("Массив: " + Arrays.toString(randomArray));

        List<Integer> list = MyCollections.arrayToList(randomArray);
        processList(list);
    }

    private static void processList(List<Integer> list) {
        MyCollections.sortListAscending(list);
        System.out.println("По возрастанию: " + list);

        MyCollections.sortListDescending(list);
        System.out.println("По убыванию: " + list);

        MyCollections.shuffleList(list);
        System.out.println("После перемешивания: " + list);

        MyCollections.rotateList(list);
        System.out.println("Циклический сдвиг: " + list);

        System.out.println("Уникальные элементы: " + MyCollections.uniqueElements(list));
        System.out.println("Дублирующиеся элементы: " + MyCollections.duplicateElements(list));
    }

    private static void generatePrimes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько простых чисел сгенерировать?");
        int count = scanner.nextInt();

        PrimesGenerator primes = new PrimesGenerator(count);
        primes.forEach(prime -> System.out.print(prime + " "));
        System.out.println();
    }

    private static void handleHumans() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Иван", "Сусанин", 25));
        humans.add(new Human("Старуха", "Шапокляк", 30));
        humans.add(new Human("Джесси", "Пинкман", 22));
        humans.add(new Human("Крутой", "Перец", 28));

        // a) Используем HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);

        // b) Используем LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // c) Используем TreeSet по умолчанию (сравнение по фамилии)
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet по умолчанию: " + treeSet);

        // d) Используем TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);  // Не забудь добавить список людей
        System.out.println("TreeSet по фамилии: " + treeSetByLastName);

        // e) Используем TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("TreeSet по возрасту: " + treeSetByAge);
    }

    private static void countWordFrequenciesTask() {
        String sampleText = "Hello world! Hello everyone. This is a test. Hello world!";
        Map<String, Integer> frequencies = WordFrequencyCounter.countWordFrequencies(sampleText);

        frequencies.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    private static void switchMapKeysValues() {
        Map<String, Integer> initialMap = Map.of("One", 1, "Two", 2, "Three", 3);
        System.out.println("Исходная карта: " + initialMap);
        Map<Integer, String> swappedMap = MapSwitcher.switchMap(initialMap);
        System.out.println("Поменянная карта: " + swappedMap);
    }
}
