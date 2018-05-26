package ru.kai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kai.services.PathFinder;
import ru.kai.transfer.TaskAnswer;

import javax.servlet.ServletRequest;
import java.util.Map;

@Controller
public class HorseController {

    int aCode = 65;

    @GetMapping("/horse/servlet/count")
    public String getMoveCountPage(ServletRequest request, ModelMap model) {

        Map<String, String[]> paramMap = request.getParameterMap();

        if (paramMap.containsKey("width") && paramMap.containsKey("height")
                && paramMap.containsKey("start") && paramMap.containsKey("end")) {

            Integer width = Integer.parseInt(paramMap.get("width")[0]);
            Integer height = Integer.parseInt(paramMap.get("height")[0]);

            String start = paramMap.get("start")[0];
            String end = paramMap.get("end")[0];

            int aCode = 65;
            int letter1 = (int) start.charAt(0) - aCode;
            int letter2 = (int) end.charAt(0) - aCode;

            int digit1 = Character.getNumericValue(start.charAt(1));
            int digit2 = Character.getNumericValue(end.charAt(1));

            PathFinder pf = new PathFinder();

            TaskAnswer taskAnswer = TaskAnswer.builder()
                    .moveCount(String.valueOf(pf.findPath(width, height, letter1, digit1, letter2, digit2)))
                    .build();

            model.addAttribute("count", taskAnswer.getMoveCount());
        } else {
            model.addAttribute("count", "недостаточно данных");
        }

        //ftl
        return "horse";
    }
}