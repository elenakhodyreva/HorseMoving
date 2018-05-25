package ru.kai.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kai.services.PathFinder;
import ru.kai.transfer.TaskAnswer;

@RestController
public class RestHorseController {
    int aCode = 65;

    @GetMapping("/horse/rest/count")
    public TaskAnswer getMoveCount(@RequestParam(name = "width") int width,
                               @RequestParam(name = "height") int height,
                               @RequestParam(name = "start") String start,
                               @RequestParam(name = "end") String end, ModelMap model) {
        int aCode = 65;
        int letter1 = (int) start.charAt(0) - aCode;
        int letter2 = (int) end.charAt(0) - aCode;

        int digit1 = Character.getNumericValue(start.charAt(1));
        int digit2 = Character.getNumericValue(end.charAt(1));

        PathFinder pf = new PathFinder();

        TaskAnswer taskAnswer = TaskAnswer.builder()
                .moveCount(String.valueOf(pf.findPath(width, height, letter1, digit1, letter2, digit2)))
                .build();

        return taskAnswer ;
    }
}
