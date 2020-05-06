package web.controller;

import Entities.Professor;
import Entities.WJournal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static dao.src.ProfessorDao.*;
import static dao.src.WJournalDao.findWJournalByProfessorId;

@Controller
@SessionAttributes("professor")
@RequestMapping
public class ProfessorsController {

    @RequestMapping(value = "/webapp/add_professor", method = RequestMethod.GET)
    public ModelAndView addProfessor(Model model) {
        ModelAndView mv = new ModelAndView();
        Professor P = new Professor();
        model.addAttribute("professor", P);
        mv.setViewName("add_professor");
        return mv;
    }

    @RequestMapping(value = "/webapp/add_professor", method = RequestMethod.POST)
    public ModelAndView addProfessor(@ModelAttribute("professor") Professor P) {
        ModelAndView mv = new ModelAndView();
        if (P.getFullName().length() > 100 || (P.getFullName().equals(""))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задано имя преподавателя. Длина имени может быть > 0 и <= 100");
            return mv;
        }
        persistProfessor(P);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Данные о преподавателе успешно добавлены");
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_professor/{id}", method = RequestMethod.GET)
    public ModelAndView editProfessor(@PathVariable("id") long Id) {
        Professor professor = findProfessorById(Id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit_professor");
        mv.addObject("professor", professor);
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_professor", method = RequestMethod.POST)
    public ModelAndView editProfessor(@ModelAttribute("professor") Professor P) {
        ModelAndView mv = new ModelAndView();
        if (P.getFullName().length() > 100 || (P.getFullName().equals(""))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задано имя преподавателя. Длина имени может быть > 0 и <= 100");
            return mv;
        }
        updateProfessor(P);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Данные о преподавателе успешно изменены");
        return mv;
    }

    @RequestMapping(value="/webapp/delete_professor/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProfessor(@PathVariable("id") long Id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/webapp/professors");
        deleteProfessorById(Id);
        return mv;
    }

    @RequestMapping(value = "/webapp/professor_courses/{id}", method = RequestMethod.GET)
    public ModelAndView ProfessorCourses(@PathVariable("id") long Id) {
        List<WJournal> WJL = findWJournalByProfessorId(Id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("professor_courses");
        mv.addObject("pId", Id);
        mv.addObject("WJournalList", WJL);
        return mv;
    }
}