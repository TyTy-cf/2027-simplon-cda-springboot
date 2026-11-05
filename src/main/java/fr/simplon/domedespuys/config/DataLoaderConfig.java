package fr.simplon.domedespuys.config;

import com.github.javafaker.Faker;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.repository.BrandRepository;
import fr.simplon.domedespuys.repository.UserRepository;
import fr.simplon.domedespuys.utils.Slugger;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@Component
@AllArgsConstructor
public class DataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private BrandRepository brandRepository;
    private Slugger slugger;

    @Override
    public void run(String @NonNull ... args) {
        createUsers();
        createAddress();
        createBrand();
    }

    private void createBrand() {
        if (0 == brandRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 50; i++) {
                Brand brand = new Brand();
                brand.setLabel(faker.company().name());
                brand.setLogo(faker.company().logo());
                brand.setSlug(slugger.slugify(brand.getLabel()));
                brandRepository.save(brand);
            }

            brandRepository.flush();
        }
    }

    private void createAddress() {
        if (0 == addressRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 150; i++) {
                Address address = new Address();
                address.setCity(faker.address().city());
                address.setCountry("France");
                address.setZipCode(faker.address().zipCode());
                address.setLine(faker.address().streetAddress());

                if (hasProbability(1, 4)) {
                    address.setExtraLine(faker.address().buildingNumber());
                }

                Random random = new Random();
                Long userId = random.nextLong(1, 100);
                Optional<User> optionalUser = userRepository.findById(userId);
                // Si l'objet attendu via notre "Optional" est présent (ifPresent),
                // alors on appelle la fonction "setUser" depuis l'objet "address" avec l'objet présent dans l'optional
                optionalUser.ifPresent(address::setUser);

                if (hasProbability(2, 4)) {
                    address.setFirstName(address.getUser().getFirstName());
                    address.setLastName(address.getUser().getLastName());
                    address.setPhone(address.getUser().getPhone());
                } else {
                    address.setFirstName(faker.name().firstName());
                    address.setLastName(faker.name().lastName());
                    address.setPhone(faker.phoneNumber().phoneNumber());
                }

                int year = address.getUser().getCreatedAt().getYear();
                int currentYear = LocalDate.now().getYear();
                address.setCreatedAt(getRandomDate(faker, 0, currentYear - year));

                addressRepository.save(address);
            }

            addressRepository.flush();
        }
    }

    private void createUsers() {
        if (0 == userRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 100; i++) {
                User user = new User();
                user.setFirstName(faker.name().firstName());
                user.setLastName(faker.name().lastName());
                String email = faker.internet().emailAddress((user.getFirstName() + "." + user.getLastName()).toLowerCase());
                user.setEmail(email);
                user.setPassword(faker.internet().password(12, 20));
                if (hasProbability(2, 3)) {
                    user.setPhone(faker.phoneNumber().phoneNumber());
                }
                user.setCreatedAt(getRandomDate(faker, 0, 5));
                userRepository.save(user);
            }

            userRepository.flush();
        }
    }

    private LocalDateTime getRandomDate(Faker faker, int min, int max) {
        return new java.sql.Date(faker.date().birthday(min, max).getTime()).toLocalDate().atTime(0, 0);
    }

    private boolean hasProbability(int expected, int max) {
       Random random = new Random();
        // random.nextInt(max) = génère un entier aléatoire entre 0 et MAX
        // expected = la proba attendue
        // Si le random est inférieure ou égale à la prob, alors on renvoie true
       return random.nextInt(max) < expected;
    }

}
