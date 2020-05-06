package web.controller;

import Entities.Course;
import Entities.Professor;
import Entities.WJournal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static dao.src.CourseDao.findCourseAll;
import static dao.src.ProfessorDao.findProfessorById;
import static dao.src.WJournalDao.*;

@Controller
@SessionAttributes("professor_course")
@RequestMapping
public class ProfessorCoursesController {

    @RequestMapping(value = "/webapp/add_professor_course/{id}", method = RequestMethod.GET)
    public ModelAndView addProfessorCourse(@PathVariable("id") long id, Model model) {
        Professor P = findProfessorById(id);
        List<Course> CourseList = findCourseAll();
        ModelAndView mv = new ModelAndView();
        WJournal WJ = new WJournal();
        model.addAttribute("professor_course", WJ);
        mv.addObject("professor", P);
        mv.addObject("CourseList", CourseList);
        mv.setViewName("add_professor_course");
        return mv;
    }

    @RequestMapping(value = "/webapp/add_professor_course", method = RequestMethod.POST)
    public ModelAndView addProfessorCourse(@ModelAttribute("professor_course") WJournal WJ) {
        ModelAndView mv = new ModelAndView();
        if (findWJournalById(WJ.getCourseId(), WJ.getProfessorId()) != null) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Запись о данном курсе уже имеется и преподавателя");
            return mv;
        }
        persistWJournal(WJ);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Запись о курсе успешно добавлена");
        return mv;
    }

    @RequestMapping(value="/webapp/delete_professor_course/{id}/{id2}", method = RequestMethod.GET)
    public ModelAndView deleteProfessorCourse(@PathVariable("id") long Pid, @PathVariable("id2") long Cid) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/webapp/professors");
        deleteWJournalById(Cid, Pid);
        return mv;
    }
}