package ru.kai.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kai.services.PathFinder;
import ru.kai.transfer.TaskAnswer;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class RestHorseController {

    @GetMapping("/horse/rest/count")
    public TaskAnswer getMoveCount(HttpServletRequest request, ModelMap model) {

        if (request.getParameter("width")!=null && request.getParameter("height")!=null
                && request.getParameter("start")!=null && request.getParameter("end")!=null) {

            Integer width = Integer.parseInt(request.getParameter("width"));
            Integer height = Integer.parseInt(request.getParameter("height"));

            String start= request.getParameter("start");
            String end= request.getParameter("end");

            int aCode = 65;
            int letter1 = (int) start.charAt(0) - aCode;
            int letter2 = (int) end.charAt(0) - aCode;

            int digit1= Integer.parseInt(start.substring(1));
            int digit2= Integer.parseInt(end.substring(1));

            PathFinder pf = new PathFinder();

            TaskAnswer taskAnswer = TaskAnswer.builder()
                    .moveCount(String.valueOf(pf.findPath(width, height, letter1, digit1, letter2, digit2)))
                    .build();

            return taskAnswer;
        } else {
            TaskAnswer taskAnswer = TaskAnswer.builder()
                    .moveCount("недостаточно данных")
                    .build();

            return taskAnswer;
        }
    }
}
