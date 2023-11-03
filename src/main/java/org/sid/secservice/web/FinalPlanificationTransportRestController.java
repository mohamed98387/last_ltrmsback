package org.sid.secservice.web;

import org.sid.secservice.entities.*;
import org.sid.secservice.service.AgenceService;
import org.sid.secservice.service.EmailService;
import org.sid.secservice.service.FinalPlanificationTransportService;
import org.sid.secservice.service.PlanificationTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
public class FinalPlanificationTransportRestController {
    private EmailService emailService;
    private FinalPlanificationTransportService finalPlanificationTransportService;
    private AgenceService agenceService;

    public FinalPlanificationTransportRestController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    public FinalPlanificationTransportRestController(EmailService emailService) {
        this.emailService = emailService;
    }

    public FinalPlanificationTransportRestController(FinalPlanificationTransportService finalPlanificationTransportService) {
        this.finalPlanificationTransportService = finalPlanificationTransportService;
    }
    @Autowired
    public FinalPlanificationTransportRestController(EmailService emailService, FinalPlanificationTransportService finalPlanificationTransportService, AgenceService agenceService) {
        this.emailService = emailService;
        this.finalPlanificationTransportService = finalPlanificationTransportService;
        this.agenceService = agenceService;
    }







    @GetMapping(path = "/newlPlanificationTransport/{agence}")
    public List<FinalPlanificationTransport> newlPlanificationTransport (@PathVariable("agence") String agence) {
        return this.finalPlanificationTransportService.newlPlanificationTransport(agence);
    }
    @GetMapping(path = "/lisFinalPlanificationTransports")
    public List<FinalPlanificationTransport> lisFinalPlanificationTransports() {
        return finalPlanificationTransportService.lisFinalPlanificationTransports();
    }
    @DeleteMapping("/clear-table-finalPlanfication")
    public void clearTable() {
        finalPlanificationTransportService.deleteAllData();
    }
    @PostMapping("/send-email-with-attachment/{agence}")
    public ResponseEntity<String> sendEmailWithAttachment(@PathVariable("agence") String agence
                                                         ,
                                                          @RequestPart("file") MultipartFile file) {

        try {
            Agence agencefind = this.agenceService.findAgenceBynom(agence);
            AuthMail authMail = new AuthMail(null,null,null);
            authMail.setTo(agencefind.getEmail());

            // You may need to configure the authMail object as needed.

            // Ensure that you pass the InputStream and the original file name from the MultipartFile
            InputStream fileInputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();

            // Call your service method to send the email with the attachment
            emailService.sendfileByMail(authMail, fileInputStream, fileName);

            return ResponseEntity.ok("Email sent successfully with attachment");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email with attachment");
        }
    }
}
