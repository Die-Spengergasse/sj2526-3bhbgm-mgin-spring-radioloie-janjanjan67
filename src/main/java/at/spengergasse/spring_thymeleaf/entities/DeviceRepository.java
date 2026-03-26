package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, String> {
}
