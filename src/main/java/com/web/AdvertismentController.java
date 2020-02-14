package com.web;

import com.model.Advertisment;
import com.model.Reservation;
import com.model.User;
import com.repository.ReservationRepository;
import com.service.AdvertismentService;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;


@Controller
public class AdvertismentController {

    @Autowired
    private AdvertismentService advertismentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationRepository reservationService;

    @RequestMapping(value = "/advertisment_list", method = RequestMethod.GET)
    public ModelAndView listAdvertisments(ModelAndView model) throws IOException {

        List<Advertisment> listAdv = advertismentService.listAll();
        model.addObject("listAdvertisment", listAdv);
        model.setViewName("advertisment_list");

        return model;
    }


    @RequestMapping(value = "/get_city_to_search", method = RequestMethod.GET)
    public ModelAndView insertTheCityToSearch(@ModelAttribute("city") String city) throws IOException {

        return new ModelAndView("search", "city", new String());
    }

    @RequestMapping(value = "/advertisment_list_by_city", method = RequestMethod.POST)
    public ModelAndView listAdvertismentsByCity(ModelAndView modelAndView, @RequestParam(value = "city") String city) throws IOException {

        List<Advertisment> listAdvByTheCity = advertismentService.listByTheCity(city);
        modelAndView.addObject("list_by_city", listAdvByTheCity);
        modelAndView.setViewName("advertisment_list_by_city");

        return modelAndView;
    }

    @RequestMapping(value = "/book_advertisment", method = RequestMethod.GET)
    public ModelAndView bookAdvertisment(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("/book_advertisment");
        Advertisment advertisment = advertismentService.get(id);
        modelAndView.addObject("advertisment", advertisment);
        modelAndView.addObject("reservation", new Reservation());
        return modelAndView;
    }


    @RequestMapping(value = "/book_advertisment", method = RequestMethod.POST)
    public String createReservForApartment(@ModelAttribute("reservation") Reservation reservation, @ModelAttribute("advertisment") Advertisment advertisment) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String clientName = ((UserDetails) principal).getUsername();
        User client = userService.findByUsername(clientName);
        reservation.setClient(client);

        reservationService.save(reservation);

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/add_new_adv", method = RequestMethod.GET)
    public ModelAndView openAddNewAdv() {

        return new ModelAndView("new_adv", "adv", new Advertisment());
    }

    @RequestMapping(value = "/add_new_adv", method = RequestMethod.POST)
    public String addNewAdv(@ModelAttribute("adv") Advertisment advertisment) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.findByUsername(username);
        advertisment.setUser(user);

        advertismentService.save(advertisment);

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/edit_advertisment", method = RequestMethod.GET)
    public ModelAndView getEditAdvertismentForm(@RequestParam long id) {

        return new ModelAndView("/edit_advertisment_form", "current_advertisment", advertismentService.get(id));
    }

    @RequestMapping(value = "/edit_advertisment", method = RequestMethod.PUT)
    public String postEditedAdvertismentForm(@ModelAttribute("current_advertisment") Advertisment advertisment) {

        advertismentService.update(advertisment);

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/delete_advertisment", method = RequestMethod.DELETE)
    public String deleteAdvertismentForm(@RequestParam long id) {
        advertismentService.delete(id);
        return "redirect:/welcome";
    }

}