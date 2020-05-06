package web.controller;

import Entities.Clazz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static dao.src.ClazzDao.*;
import static dao.src.LectureHallDao.findLectureHallById;
import static dao.src.ProfessorDao.findProfessorById;
import static dao.src.SGroupDao.findSGroupById;
import static dao.src.StudentDao.findStudentById;

@Controller
@RequestMapping
public class TimetableController {

    @RequestMapping(value = "/webapp/timetable/lecture_hall/{id}", method = RequestMethod.GET)
    public ModelAndView LectureHallTimeTable(Model model, @PathVariable("id") int Id) {
        List<Clazz> ClazzList = findClazzByLectureHall(Id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("timetable_editor");
        mv.addObject("ClazzList", ClazzList);
        model.addAttribute("message", "Расписание для аудитории " + findLectureHallById(Id).getNumber());
        model.addAttribute("type", 0);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/professor/{id}", method = RequestMethod.GET)
    public ModelAndView ProfessorTimetable(Model model, @PathVariable("id") int Id) {
        List<Clazz> ClazzList = findClazzByProfessor(Id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("timetable_editor");
        mv.addObject("ClazzList", ClazzList);
        model.addAttribute("message", "Расписание профессора \"" + findProfessorById(Id).getFullName() + "\"");
        model.addAttribute("type", 0);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/student/{id}", method = RequestMethod.GET)
    public ModelAndView StudentTimetable(Model model, @PathVariable("id") int Id) {
        List<Clazz> ClazzList = findClazzByStudent(Id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("timetable_editor");
        mv.addObject("ClazzList", ClazzList);
        model.addAttribute("message", "Расписание студента \"" + findStudentById(Id).getFullName() + "\"");
        model.addAttribute("type", 1);
        model.addAttribute("studentId", Id);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/group/{id}", method = RequestMethod.GET)
    public ModelAndView GroupTimetable(Model model, @PathVariable("id") int Id) {
        List<Clazz> ClazzList = findClazzByGroup(findSGroupById(Id).getGroupNumber());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("timetable_editor");
        mv.addObject("ClazzList", ClazzList);
        model.addAttribute("message", "Расписание " + findSGroupById(Id).getGroupNumber() + " группы");
        model.addAttribute("type", 2);
        model.addAttribute("groupId", Id);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/course/{course}/flow/{flow}", method = RequestMethod.GET)
    public ModelAndView FlowTimetable(Model model, @PathVariable("course") int c, @PathVariable("flow") int f) {
        List<Clazz> ClazzList = findClazzByYosAndFlow(f, c);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("timetable_editor");
        mv.addObject("ClazzList", ClazzList);
        model.addAttribute("message", "Расписание " + c + " курса " + f + " потока");
        model.addAttribute("type", 3);
        model.addAttribute("course", c);
        model.addAttribute("flow", f);
        return mv;
    }
}
