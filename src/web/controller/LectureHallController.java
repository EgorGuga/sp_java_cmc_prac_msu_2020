package web.controller;

import Entities.LectureHall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static dao.src.LectureHallDao.*;

@Controller
@SessionAttributes("lecture_hall")
@RequestMapping
public class LectureHallController {

    @RequestMapping(value = "/webapp/add_lecture_hall", method = RequestMethod.GET)
    public ModelAndView addLectureHall(Model model) {
        ModelAndView mv = new ModelAndView();
        LectureHall LH = new LectureHall();
        model.addAttribute("lectureHall", LH);
        mv.setViewName("add_lecture_hall");
        return mv;
    }

    @RequestMapping(value = "/webapp/add_lecture_hall", method = RequestMethod.POST)
    public ModelAndView addLectureHall(@ModelAttribute("professor") LectureHall LH) {
        ModelAndView mv = new ModelAndView();
        if (LH.getNumber().length() > 20 || (LH.getNumber().equals(""))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задан номер аудитории. Длина номера может быть > 0 и <= 20");
            return mv;
        }
        if ((LH.getCapacity() == null) || (LH.getCapacity() <= 0) || (LH.getCapacity() >= 2000)) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задана вместимость аудитории. Вместимость может быть > 0 и < 2000");
            return mv;
        }
        persistLectureHall(LH);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Аудитория успешно добавлена");
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_lecture_hall/{id}", method = RequestMethod.GET)
    public ModelAndView editLectureHall(@PathVariable("id") long Id) {
        LectureHall LH = findLectureHallById(Id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit_lecture_hall");
        mv.addObject("lecture_hall", LH);
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_lecture_hall", method = RequestMethod.POST)
    public ModelAndView editLectureHall(@ModelAttribute("lecture_hall") LectureHall LH) {
        ModelAndView mv = new ModelAndView();
        if (LH.getNumber().length() > 20 || (LH.getNumber().equals(""))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задан номер аудитории. Длина номера может быть > 0 и <= 20");
            return mv;
        }
        if ((LH.getCapacity() == null) || (LH.getCapacity() <= 0) || (LH.getCapacity() >= 2000)) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задана вместимость аудитории. Вместимость может быть > 0 и < 2000");
            return mv;
        }
        updateLectureHall(LH);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Аудитория успешно изменена");
        return mv;
    }

    @RequestMapping(value = "/webapp/delete_lecture_hall/{id}", method = RequestMethod.GET)
    public ModelAndView deleteLectureHall(@PathVariable("id") long Id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/webapp/lecture_halls");
        deleteLectureHallById(Id);
        return mv;
    }
}