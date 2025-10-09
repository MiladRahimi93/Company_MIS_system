package com.yrmpt.MIS.Task.Controller;

import com.yrmpt.MIS.Task.Model.EmailRequest;
import com.yrmpt.MIS.Task.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // Allow frontend (React) to connect
public class TaskController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/home")
    public String View(){
        return "this is the test";
    }

    @PostMapping("/send-mail")
    public String sendTasksByEmail(@RequestBody EmailRequest request) {
        try {
            // Build HTML email body
            StringBuilder html = new StringBuilder();
            html.append("<p>Dear Supervisor,</p>");
            html.append("<p>Please find below my daily task report:</p>");
            html.append("<p><strong>Date/Time:</strong> ").append(request.getDateTime()).append("</p>");
            html.append("<table border='1' cellpadding='8' cellspacing='0' style='border-collapse: collapse; font-family: Arial, sans-serif; font-size: 14px;'>");
            html.append("<tr style='background-color:#f2f2f2;'><th>Task</th><th>Status</th><th>Tomorrow Task</th></tr>");

            List<Task> tasks = request.getTasks();
            if (tasks != null && !tasks.isEmpty()) {
                for (Task task : tasks) {
                    html.append("<tr>")
                            .append("<td>").append(task.getTask() != null ? task.getTask() : "").append("</td>")
                            .append("<td>").append(task.getStatus() != null ? task.getStatus() : "").append("</td>")
                            .append("<td>").append(task.getTommorowTask() != null ? task.getTommorowTask() : "").append("</td>")
                            .append("</tr>");
                }
            } else {
                html.append("<tr><td colspan='3'>No tasks provided.</td></tr>");
            }

            html.append("</table>");
            html.append("<br><p>Best regards,<br><strong>Milad</strong></p>");

            // Send Email
            sendEmail(request.getEmail(), request.getCc(), request.getSubject(), html.toString());

            return "Email sent successfully!";
        } catch (Exception e) {

            e.printStackTrace();

            return "Failed to send email: " + e.getMessage();
        }
    }

    private void sendEmail(String to, String cc, String subject, String htmlContent) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);

        // ✅ Allow multiple comma-separated CCs
        if (cc != null && !cc.isEmpty()) {
            String[] ccList = cc.split(",");
            helper.setCc(ccList);
        }

        helper.setSubject(subject != null && !subject.isEmpty() ? subject : "Daily Task Report");
        helper.setText(htmlContent, true); // true = HTML content

        mailSender.send(message);
    }
}
