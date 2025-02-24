package kz.enu.restvt.restexample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException; // Қосымша импорт
import kz.enu.restvt.restexample.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class Myсontroller { // Класс атауы түзетілді

    @Autowired
    private ObjectMapper obMapper;

    @GetMapping("/hello")
    public String printHello() {
        return "Hello WORLD";
    }

    @GetMapping("/studentdatas")
    public String studentListener() { // Метод атауы стандартқа сай өзгертілді
        String jsonText;
        Student stud1 = new Student(1,
                "Abilkasum",
                20,
                "Balnur");

        try {
            jsonText = obMapper.writeValueAsString(stud1);
        } catch (JsonProcessingException e) {
            jsonText = "Error processing JSON: " + e.getMessage(); // Қате хабарламасын қайтарамыз
        }

        return jsonText;
    }

    @PostMapping("/specific_student")
    public String specificStudentListener(@RequestParam int id,
                                          @RequestParam String name,
                                          @RequestParam String secondname,
                                          @RequestParam int a) {
        String jsonText=null;
        Student mystudent = new Student(id, name, secondname, a);
        try {
            jsonText = obMapper.writeValueAsString(mystudent);
        } catch (JsonProcessingException e) {
            jsonText = "Error processing JSON: " + e.getMessage(); // Қате хабарламасын қайтарамыз
        }

        return jsonText;
    }

}
