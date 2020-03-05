package com.web;

import com.model.Advertisment;
import com.model.Reservation;
import com.model.User;
import com.repository.ReservationRepository;
import com.service.AdvertismentService;
import com.service.ReservationService;
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

import java.io.IOException;
import java.util.List;


@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AdvertismentService advertismentService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/book/advertisment", method = RequestMethod.GET)
    public ModelAndView bookAdvertisment(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("/book_advertisment");
        Advertisment advertisment = advertismentService.get(id);
        modelAndView.addObject("advertisment", advertisment);
        modelAndView.addObject("reservation", new Reservation());
        return modelAndView;
    }

    @RequestMapping(value = "/book/advertisment", method = RequestMethod.POST)
    public String createReservForApartment(@ModelAttribute("reservation") Reservation reservation, @ModelAttribute("advertisment") Advertisment advertisment) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String clientName = ((UserDetails) principal).getUsername();
        User client = userService.findByUsername(clientName);
        reservation.setClient(client);
        reservationService.save(reservation);
        return "redirect:/welcome";
    }


    @RequestMapping(value = "/reservations/list", method = RequestMethod.GET)
    public ModelAndView listAllReservations(ModelAndView model) throws IOException {
        List<Reservation> reservationList = reservationService.listAll();
        model.addObject("reservationList", reservationList);
        model.setViewName("reservation_list");
        return model;
    }


    @RequestMapping(value = "/user/reservations/list", method = RequestMethod.GET)
    public ModelAndView listReservationsOfCurrentUser(@ModelAttribute("client_id") Long id) throws IOException {
        return new ModelAndView("reservation_list_for_current_user", "reservationList", reservationService.findReservationsByClient(id));
    }


    @RequestMapping(value = "/reservation/edit", method = RequestMethod.GET)
    public ModelAndView getEditReservationForm(@RequestParam long id) {
        return new ModelAndView("/edit_resrvation_form", "current_reservation", reservationService.get(id));
    }

    @RequestMapping(value = "/reservation/edit", method = RequestMethod.PUT)
    public String postEditedReservationForm(@ModelAttribute("current_reservation") Reservation reservation) {
        reservationService.update(reservation);
        return "redirect:/welcome";
    }


    @RequestMapping(value = "/reservation/delete", method = RequestMethod.DELETE)
    public String deleteCurrentReservation (@RequestParam long id) {
        reservationService.delete(id);
        return "redirect:/welcome";
    }
}
