package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByDeviceId(String deviceId);
    List<Reservation> findByDeviceIdAndReservationTime(String device_id, LocalDateTime reservationTime);
    List<Reservation> findByPatientAndReservationTime(Patient patient, LocalDateTime reservationTime);
}
