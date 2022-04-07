package dio.springdatajpa;

import dio.springdatajpa.model.User;
import dio.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//CommandLineRunnuer, semelhante ao método main que é capaz de ao inicializar o container ele já é executado junto.
@Component // Componente - Objeto gerenciado pelo SPRING FRAMEWORK
public class StartApp implements CommandLineRunner {

    // Maneira de criar um objeto no springboot. Instanciando... Autowired - Ingeção de dependências.

    @Autowired
    private UserRepository userRepository;

    // Maneira de sobreescrever um método já existente. @Override: Injetando um método existente. Nesse caso o MAIN.
    @Override
    public void run(String... args) throws Exception {

        insertUser("Romarinho", "roma33", "231&&sd");
        listUserByUsername("P2");
        listUser();

    }

    void insertUser(String nome, String username, String password) {
        User user = new User();
        user.setNome(nome);
        user.setUsername(username);
        user.setPassword(password);

        //Listando os usuários e Salvando-os
        userRepository.save(user);

        for (User usuarios : userRepository.findAll()) {
            System.out.println(usuarios);
        }
    }

    void listUserByUsername(String username) {
        List<User> u = userRepository.findByUsername(username);

        for (User usu : u) {
            System.out.println(usu);
        }

    }

    void listUser() {
        List<User> u = userRepository.findAll();

        for (User usu : u) {
            System.out.println(usu);
        }
    }


}
