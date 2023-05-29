package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.io.IOException;
import java.util.*;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<String> getNames() {
        List<User> users = usersRepository.findAll();
        List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.getFirstName());
        }

        return names;
    }

    @Override
    public String getLastNameOfMostAging() {

        List<User> users = usersRepository.findAll();
        Map<Integer, String> userAge = new HashMap<>();

        for (User user : users) {
            userAge.put(user.getAge(), user.getLastName());
        }

        int maxAge = Collections.max(userAge.keySet());

        return userAge.get(maxAge);
    }

    @Override
    public void saveNewUser() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя нового пользователя: ");
        String firstName;
        while (true) {
            firstName = scanner.nextLine().trim();
            if (!firstName.isEmpty()) {
                firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
                break;
            }
            System.out.println("Данное поле должно содержать имя пользователя. Повторите ввод:");
        }
        while (!UserValidator.isValidFirstName(firstName)) {
            System.out.println("Повторите ввод:");
            firstName = scanner.nextLine();
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        }

        System.out.print("Введите фамилию нового пользователя: ");
        String lastName;
        while (true) {
            lastName = scanner.nextLine().trim();
            if (!lastName.isEmpty()) {
                lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
                break;
            }
            System.out.println("Данное поле должно содержать фамилию пользователя. Повторите ввод.");
        }
        while (!UserValidator.isValidLastName(lastName)) {
            System.out.println("Повторите ввод");
            lastName = scanner.nextLine();
            lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        }

        System.out.print("Введите возраст нового пользователя: ");
        int age = 0;
        age = scanner.nextInt();
        while (!UserValidator.isValidAge(age)) {
            try {
                age = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Повторите ввод: ");
                return;
            }
            scanner.nextLine();
        }
        scanner.nextLine();

        System.out.print("Введите рост нового пользователя: ");
        double height = 0.00;
        boolean isValidHeight = false;
        while (!isValidHeight) {
            try {
                height = scanner.nextDouble();
                if (!UserValidator.isValidHeight(height)) {
                    System.out.print("Повторите ввод: ");
                } else {
                    isValidHeight = true;
                }
            }catch (InputMismatchException e) {
                    System.out.print("Повторите ввод: ");
                    scanner.nextLine();
            }
        }
        scanner.nextLine();

        User newUser = new User(firstName, lastName, age, height);
        try {
            usersRepository.save(newUser);
            System.out.println("\tНовый пользователь сохранен.\n " +
                    "\tВЫБЕРИТЕ СЛЕДУЮЩУЮ КОМАНДУ: ");
        } catch (Exception e) {
            System.out.println("Пользователь с таким именем уже существует");
        }
    }

    @Override
    public Double getAverageAge() {
        List<User> users = usersRepository.findAll();
        if (users.isEmpty()){
            return 0.0;
        }
        int totalAge = 0;
        for (User user : users) {
            totalAge += user.getAge();
        }
        return (double) totalAge / users.size();
    }

    @Override

    public Integer getAgeOfMostHeight() {

        List<User> users = usersRepository.findAll();
        Map<Double, Integer> userHeight = new HashMap<>();
        for (User user : users) {
            userHeight.put(user.getHeight(), user.getAge());
        }
        double maxHeight = Collections.max(userHeight.keySet());
        return userHeight.get(maxHeight);
    }

    @Override
    public String getFirstNameAndLastNameOfLowestHeight() {
        List<User> users = usersRepository.findAll();
        Map<Double, String> userHeight = new HashMap<>();
        for (User user : users) {
            userHeight.put(user.getHeight(), user.getFirstName() + " " + user.getLastName());
        }
        double minHeight = Collections.min(userHeight.keySet());

        return userHeight.get(minHeight);
    }
}
