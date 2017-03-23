/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springku;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.HandlerMapping;
import pojo.Hallo;

/**
 *
 * @author L
 */
@Controller

public class HelloController {
    @RequestMapping(value = "/cari",method = RequestMethod.GET)
 public String hallo(ModelMap modelMap){
     //modelMap.addAttribute("pesan", "ini spring pertama");
     return "form";
 }
 @RequestMapping(value = "/ambiltanggal/**",method = RequestMethod.GET)
 public String belajar1(ModelMap map,HttpServletRequest request){
     String data =(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
     String[] pecah = data.split("/");
     map.addAttribute("nama", pecah[2]);
     return "learning";
 } 
 @RequestMapping(value = "/belajar/{param:.+}/{pesan:.+}",method = RequestMethod.GET)
 public String belajar(@PathVariable("param")
         String param,@PathVariable("pesan")String pesan,ModelMap map){
     map.addAttribute("nama", param);
    
     map.addAttribute("pesan", pesan);
     return "learning";
 }
 @RequestMapping(value = "/tes")
 public String tes(ModelMap map){
     map.addAttribute("salam", new Hallo());
     return "form";
 }
 @RequestMapping(value = "/hasil")
 public String hasil(@ModelAttribute Hallo hallo){
     return "index";
 }
}
