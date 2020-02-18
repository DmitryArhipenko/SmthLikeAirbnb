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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationService;

    @Autowired
    private AdvertismentService advertismentService;

    @Autowired
    private UserService userService;


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


}
