package org.test.wubflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.test.wubflux.student.Student;
import org.test.wubflux.student.StudentRepository;

@SpringBootApplication
public class WubfluxTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WubfluxTestApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            for (int i = 0; i < 3000; i++) {
                repository.save(
                        Student.builder()
                                .firstname("Test" + i)
                                .lastname("test" + i)
                                .age(i)
                                .build()
                ).subscribe();
            }
        };
    }
}
