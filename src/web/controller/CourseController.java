package web.controller;

import Entities.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static dao.src.CourseDao.*;

@Controller
@SessionAttributes("course")
@RequestMapping
public class CourseController {

    @RequestMapping(value = "/webapp/add_course", method = RequestMethod.GET)
    public ModelAndView addCourse(Model model) {
        ModelAndView mv = new ModelAndView();
        Course C = new Course();
        model.addAttribute("course", C);
        mv.setViewName("add_course");
        return mv;
    }

    @RequestMapping(value = "/webapp/add_course", method = RequestMethod.POST)
    public ModelAndView addCourse(@ModelAttribute("course")  Course C) {
        ModelAndView mv = new ModelAndView();
        if (C.getName().length() > 100 || (C.getName().equals(""))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задано название курса. Длина имени может быть > 0 и <= 100");
            return mv;
        }
        if ((C.getYearOfStudy() != null) && ((C.getYearOfStudy() <= 0) || (C.getYearOfStudy() >= 10))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задан год обучения. Год обучения может быть > 0 и < 10");
            return mv;
        }
        if ((C.getYearOfStudy() == null) && (!C.getCoverage().equals("Спец. курс"))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не задан год обучения. Год обучения может быть не задан только для спец. курса");
            return mv;
        }
        if (C.getCoverage().equals("NONE")) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не задан тип курса");
            return mv;
        }
        if ((C.getIntensity() == null) || (C.getIntensity() <= 0) || (C.getIntensity() >= 20)) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задана интенсивность курса. Интенсивность может быть > 0 и < 20");
            return mv;
        }
        if ((C.getYear() == null) || (C.getYear() < 2000) || (C.getYear() > 2100)) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задан год курса. Год может быть >= 2000 и <= 2100");
            return mv;
        }
        persistCourse(C);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Курс успешно добавлен");
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_course/{id}", method = RequestMethod.GET)
    public ModelAndView editCourse(@PathVariable("id") long Id) {
        Course C = findCourseById(Id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit_course");
        mv.addObject("course", C);
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_course", method = RequestMethod.POST)
    public ModelAndView editCourse(@ModelAttribute("course") Course C) {
        ModelAndView mv = new ModelAndView();
        if (C.getName().length() > 100 || (C.getName().equals(""))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задано название курса. Длина имени может быть > 0 и <= 100");
            return mv;
        }
        if ((C.getYearOfStudy() != null) && ((C.getYearOfStudy() <= 0) || (C.getYearOfStudy() >= 10))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задан год обучения. Год обучения может быть > 0 и < 10");
            return mv;
        }
        if ((C.getYearOfStudy() == null) && (!C.getCoverage().equals("Спец. курс"))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не задан год обучения. Год обучения может быть не задан только для спец. курса");
            return mv;
        }
        if ((C.getIntensity() == null) || (C.getIntensity() <= 0) || (C.getIntensity() >= 20)) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задана интенсивность курса. Интенсивность может быть > 0 и < 20");
            return mv;
        }
        if ((C.getYear() == null) || (C.getYear() < 2000) || (C.getYear() > 2100)) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задан год курса. Год может быть >= 2000 и <= 2100");
            return mv;
        }
        updateCourse(C);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Курс успешно изменен");
        return mv;
    }

    @RequestMapping(value = "/webapp/delete_course/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable("id") long Id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/webapp/courses");
        deleteCourseById(Id);
        return mv;
    }
}