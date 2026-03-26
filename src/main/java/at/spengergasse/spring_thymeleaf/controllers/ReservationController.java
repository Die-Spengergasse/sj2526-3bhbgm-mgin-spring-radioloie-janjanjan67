package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final DeviceRepository deviceRepository;

    public ReservationController(ReservationRepository reservationRepository, 
                                 PatientRepository patientRepository, 
                                 DeviceRepository deviceRepository) {
        this.reservationRepository = reservationRepository;
        this.patientRepository = patientRepository;
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("devices", deviceRepository.findAll());
        return "add_reservation";
    }

    @PostMapping("/add")
    public String addReservation(@ModelAttribute Reservation reservation) {
        reservationRepository.save(reservation);
        return "redirect:/";
    }

    @GetMapping("/select-device")
    public String selectDevice(Model model) {
        model.addAttribute("devices", deviceRepository.findAll());
        return "select_device";
    }

    @GetMapping("/list/{deviceId}")
    public String listByDevice(@PathVariable String deviceId, Model model) {
        model.addAttribute("reservations", reservationRepository.findByDeviceId(deviceId));
        deviceRepository.findById(deviceId).ifPresent(device -> model.addAttribute("device", device));
        return "reservation_list";
    }
}
