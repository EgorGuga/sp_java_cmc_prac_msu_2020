package web.controller;

import Entities.Flow;
import Entities.SGroup;
import Entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.controller.util.StudentAndGroupAndFlow;

import java.util.List;

import static dao.src.FlowDao.findFlowAll;
import static dao.src.FlowDao.findFlowById;
import static dao.src.SGroupDao.findSGroupAll;
import static dao.src.SGroupDao.findSGroupById;
import static dao.src.StudentDao.*;

@Controller
@SessionAttributes("student")
@RequestMapping
public class StudentController {

    @RequestMapping(value = "/webapp/courses_and_flow", method = RequestMethod.GET)
    public ModelAndView CoursesAndFlow() {
        List<Flow> FlowList = findFlowAll();
        Student S = new Student();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courses_and_flow");
        mv.addObject("FlowList", FlowList);
        return mv;
    }

    @RequestMapping(value = "/webapp/add_student", method = RequestMethod.GET)
    public ModelAndView addStudent(Model model) {
        ModelAndView mv = new ModelAndView();
        StudentAndGroupAndFlow SGF = new StudentAndGroupAndFlow();
        List<SGroup> SGroupList = findSGroupAll();
        List<Flow> FlowList = findFlowAll();
        mv.addObject("student", SGF);
        model.addAttribute("SGroupList", SGroupList);
        model.addAttribute("FlowList", FlowList);
        mv.setViewName("add_student");
        return mv;
    }

    @RequestMapping(value = "/webapp/add_student", method = RequestMethod.POST)
    public ModelAndView addStudent(@ModelAttribute("student") StudentAndGroupAndFlow SGP) {
        ModelAndView mv = new ModelAndView();
        Student S = new Student();
        S.setFullName(SGP.getFullName());
        S.setYearOfStudy(SGP.getYearOfStudy());
        S.setsGroupByGroupId(findSGroupById(SGP.getGroupId()));
        S.setFlowByFlowId(findFlowById(SGP.getFlowId()));
        if (S.getFullName().length() > 100 || (S.getFullName().equals(""))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задано имя студента. Длина имени может быть > 0 и <= 100");
            return mv;
        }
        if ((S.getYearOfStudy() == null) || (S.getYearOfStudy() <= 0) || (S.getYearOfStudy() >= 10)) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задан курс обучения. Курс может быть > 0 и < 10");
            return mv;
        }
        if (SGP.getGroupId() == 0) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбрана группа");
            return mv;
        }
        if (SGP.getFlowId() == 0) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбран поток");
            return mv;
        }
        if (S.getFlowByFlowId().getFlowNumber() != S.getsGroupByGroupId().getFlowByFlowId().getFlowNumber()) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Группа не соответствует потоку");
            return mv;
        }
        persistStudent(S);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Данные о студенте успешно добавлены");
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_student/{id}", method = RequestMethod.GET)
    public ModelAndView editStudent(Model model, @PathVariable("id") long Id) {
        Student S = findStudentById(Id);
        StudentAndGroupAndFlow SGP = new StudentAndGroupAndFlow();
        SGP.setStudentId(Id);
        SGP.setFullName(S.getFullName());
        SGP.setYearOfStudy(S.getYearOfStudy());
        SGP.setFlowId(S.getFlowByFlowId().getFlowId());
        SGP.setGroupId(S.getsGroupByGroupId().getGroupId());
        List<SGroup> SGroupList = findSGroupAll();
        List<Flow> FlowList = findFlowAll();
        ModelAndView mv = new ModelAndView();
        model.addAttribute("SGroupList", SGroupList);
        model.addAttribute("FlowList", FlowList);
        mv.setViewName("edit_student");
        mv.addObject("student", SGP);
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_student", method = RequestMethod.POST)
    public ModelAndView editStudent(@ModelAttribute("student") StudentAndGroupAndFlow SGP) {
        ModelAndView mv = new ModelAndView();
        Student S = findStudentById(SGP.getStudentId());
        S.setFullName(SGP.getFullName());
        S.setYearOfStudy(SGP.getYearOfStudy());
        S.setsGroupByGroupId(findSGroupById(SGP.getGroupId()));
        S.setFlowByFlowId(findFlowById(SGP.getFlowId()));
        if (S.getFullName().length() > 100 || (S.getFullName().equals(""))) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задано имя студента. Длина имени может быть > 0 и <= 100");
            return mv;
        }
        if ((S.getYearOfStudy() == null) || (S.getYearOfStudy() <= 0) || (S.getYearOfStudy() >= 10)) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Неправильно задан курс обучения. Курс может быть > 0 и < 10");
            return mv;
        }
        if (S.getFlowByFlowId().getFlowNumber() != S.getsGroupByGroupId().getFlowByFlowId().getFlowNumber()) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Группа не соответствует потоку");
            return mv;
        }
        updateStudent(S);
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Данные о студенте успешно изменены");
        return mv;
    }

    @RequestMapping(value = "/webapp/delete_student/{id}", method = RequestMethod.GET)
    public ModelAndView deleteStudent(@PathVariable("id") long Id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/webapp/students");
        deleteStudentById(Id);
        return mv;
    }
}