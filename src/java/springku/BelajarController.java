/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springku;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Hallo;

/**
 *
 * @author L
 */
@Controller
public class BelajarController {
@RequestMapping("/learn")
public ModelAndView belajar(HttpServletRequest request,HttpServletResponse response){
    String pesan = "Ini ";
    Map<String,String> map = new HashMap<>();
    map.put("nama", request.getParameter("nama"));
    map.put("nim", request.getParameter("nim"));
    return new ModelAndView("belajar", "pesan", map);
}
@RequestMapping(value = "/formlogin",method = RequestMethod.GET)
public ModelAndView formlogin(HttpServletRequest request,HttpServletResponse hsr){
    return new ModelAndView("form","command",new Hallo());
}

@RequestMapping(value = "/simpan")
public String simpan(@ModelAttribute("hallo")Hallo h,ModelMap map,HttpServletRequest request){
    HttpSession  session= request.getSession();
    map.addAttribute("pesan",session.getAttribute("username"));
    return "learning";
}
@RequestMapping(value = "/formlogin",method = RequestMethod.POST)
public ModelAndView formloginPost(@ModelAttribute("login")Hallo h,
                                   HttpServletRequest request,HttpServletResponse response){
    if(h.getNama().equals("admin") && h.getNim().equals("admin")){
        Map<String,String> m = new HashMap<>();
        HttpSession hs = request.getSession();
        hs.setAttribute("username", h.getNama());
        return new ModelAndView("redirect:simpan");
    }else{
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("command",new Hallo());
        request.setAttribute("error", "username dan password masih salah");
        return modelAndView;
    }
}
@RequestMapping("/keluar")
public String keluar(HttpServletRequest request){
    HttpSession httpSession = request.getSession();
    if(httpSession.getAttribute("username") != null){
        httpSession.invalidate();;
    }
    return "redirect:formlogin";
}
@RequestMapping(value = "/css")
public ModelAndView css(){
    ModelAndView view = new ModelAndView("learning");
    view.addObject("pesan", "emi");
    return view;
}
}
