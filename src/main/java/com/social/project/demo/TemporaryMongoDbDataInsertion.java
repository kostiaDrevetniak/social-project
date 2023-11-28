package com.social.project.demo;

import com.social.project.demo.model.UncheckedAnnouncement;
import com.social.project.demo.repository.UncheckedAnnouncementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;

@Configuration
public class TemporaryMongoDbDataInsertion {
    @Bean
    CommandLineRunner commandLineRunner(
            UncheckedAnnouncementRepository uncheckedAnnouncementRepository,
            MongoTemplate mongoTemplate
    ){
        return args -> {
//            mongoTemplate.getDb().
//            mongoTemplate.getDb().drop();
//            UncheckedAnnouncement uncheckedAnnouncement = new UncheckedAnnouncement();
//            uncheckedAnnouncement.setCompanyName("Молодіжний центр Тернополя");
//            uncheckedAnnouncement.setDescription("""
//
//                    Настав час знайти собі роботу!\s
//
//                    І Молодіжний Центр може вам з цим допомогти, адже зовсім скоро відбудеться День Кар'єри!
//
//                    Чого очікувати від заходу?
//
//                    \uD83D\uDD38можливості поспілкуватися з представниками різноманітних підприємств\s
//                    \uD83D\uDD38лекції від спікерів, чиї імена ми незабаром повідомимо\s
//                    \uD83D\uDD38проведення часу в колі однодумців\s
//
//                    \uD83D\uDCC5 27 квітня, 14:00
//                    \uD83D\uDCCDУкраїнський дім "Перемога"
//
//                    Вхід вільний
//
//                    Обов`язкова попередня реєстрація❗️
//
//                    Посилання на форму\uD83D\uDC47\uD83C\uDFFB
//                    https://cutt.ly/a4Huoe6
//
//                    #ДК2023""");
//            uncheckedAnnouncement.setCreationDate(LocalDateTime.parse("2023-05-13T14:00"));
//            uncheckedAnnouncement.setStartDate(LocalDateTime.parse("2023-05-27T14:00"));
//            uncheckedAnnouncementRepository.insert(uncheckedAnnouncement);
        };
    }
}
