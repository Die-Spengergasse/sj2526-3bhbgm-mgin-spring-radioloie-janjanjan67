package at.spengergasse.spring_thymeleaf;

import at.spengergasse.spring_thymeleaf.entities.Device;
import at.spengergasse.spring_thymeleaf.entities.DeviceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(DeviceRepository deviceRepository) {
        return args -> {
            if (deviceRepository.count() == 0) {
                Device mri = new Device();
                mri.setId("MR1");
                mri.setType("MR");
                mri.setLocation("101");

                Device ct = new Device();
                ct.setId("CT1");
                ct.setType("CT");
                ct.setLocation("102");

                Device xray = new Device();
                xray.setId("RX1");
                xray.setType("Röntgen");
                xray.setLocation("103");

                deviceRepository.saveAll(List.of(mri, ct, xray));
            }
        };
    }
}
