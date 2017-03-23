/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pojo.Hallo;
import source.Config;
/**
 *
 * @author L
 */
@Controller
public class Crud extends WebMvcConfigurerAdapter{
    @Autowired
    Config config;

    @RequestMapping(method = RequestMethod.GET,value = "/show")
    public ModelAndView show(){
        List<Hallo> hallos = config.tampilSemua();
        return new ModelAndView("crud/index","isi",hallos);
    }
    
    @RequestMapping(value = "/tambahdata", method = RequestMethod.GET)
    public ModelAndView tambah(){
        return new ModelAndView("crud/tambah","command",new Hallo());
    }
    
    @RequestMapping(value = "/tambahdata", method = RequestMethod.POST)
    public ModelAndView simpan(@Valid @ModelAttribute("hallo")Hallo hallo,
            BindingResult result){
        if(result.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("crud/tambah");
            modelAndView.addObject("command", new Hallo());
            modelAndView.addObject("error",result.getAllErrors());
            return modelAndView;
        }else{
            config.tambahData(hallo);
            return new ModelAndView("redirect:show");
        }
    }
    @RequestMapping(value = "/hapus/{id}",method = RequestMethod.GET)
    public ModelAndView hapus(@PathVariable("id") String id){
        config.hapus(id);
        return new ModelAndView("redirect:/show");
    }
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id")String id){
        Hallo h = config.mahasiswa(id);
        ModelAndView andView = new ModelAndView("crud/edit");
                    andView.addObject("command", h);
                    andView.addObject("id", id);
        return andView;
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
     public ModelAndView update(@Valid @ModelAttribute("hallo")Hallo hallo,
            BindingResult result,@PathVariable("id")String id){
        if(result.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("crud/edit");
            modelAndView.addObject("command", hallo);
            modelAndView.addObject("id", id);
            modelAndView.addObject("error",result.getAllErrors());
            return modelAndView;
        }else{
            config.simpanUpdate(hallo);
            return new ModelAndView("redirect:/show");
        }
    }
}   
