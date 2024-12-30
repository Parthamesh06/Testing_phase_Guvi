package com.example.healthcare.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   // Endpoint to show the login page
   @GetMapping("/")
   public String defaultPage() {
       return "redirect:/Signin"; // This will render sign-in.html from src/main/resources/templates/
   }
  

   // Endpoint to show the appointment booking page for the patient
   @GetMapping("/patient")
   public String patientPage() {
       return "AppointmentBooking"; // This will render AppointmentBooking.html
   }

   @GetMapping("/doctor")
   public String doctorpage(){
        return "DoctorDashboard";
   }
}

