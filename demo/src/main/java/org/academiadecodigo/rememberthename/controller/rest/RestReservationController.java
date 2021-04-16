package org.academiadecodigo.rememberthename.controller.rest;

import org.academiadecodigo.rememberthename.command.ReservationDto;
import org.academiadecodigo.rememberthename.converters.ReservationDtoToReservation;
import org.academiadecodigo.rememberthename.converters.ReservationToReservationDto;
import org.academiadecodigo.rememberthename.persistence.model.Customer;
import org.academiadecodigo.rememberthename.persistence.model.Reservation;
import org.academiadecodigo.rememberthename.service.mock.CustomerServiceMockImpl;
import org.academiadecodigo.rememberthename.service.mock.ReservationServiceMockImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller responsible for {@link Reservation} related CRUD operations
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class RestReservationController {

    private CustomerServiceMockImpl customerService;
    private ReservationServiceMockImpl reservationService;
    private ReservationToReservationDto reservationToReservationDto;
    private ReservationDtoToReservation reservationDtoToReservation;


    @Autowired
    public void setCustomerService(CustomerServiceMockImpl customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setAccountService(ReservationServiceMockImpl reservationService) {
        this.reservationService = reservationService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/reservations")
    public ResponseEntity<List<ReservationDto>> listCustomerReservations(@PathVariable Integer cid) {

        Customer customer = customerService.get(cid);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<ReservationDto> reservationDtos = customer.getReservations().stream()
                .map(reservation -> reservationToReservationDto.convert(reservation))
                .collect(Collectors.toList());


        return new ResponseEntity<>(reservationDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/reservation/{rid}")
    public ResponseEntity<ReservationDto> showCustomerAccount(@PathVariable Integer cid, @PathVariable Integer rid) {

        Reservation reservation = reservationService.get(rid);

        if (reservation == null || reservation.getCustomer() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!reservation.getCustomer().getId().equals(cid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reservationToReservationDto.convert(reservation), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/{cid}/reservation")
    public ResponseEntity<?> addAccount(@PathVariable Integer cid, @Valid @RequestBody ReservationDto reservationDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || reservationDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

            Reservation reservation = customerService.addReservation(cid, reservationDtoToReservation.convert(reservationDto));

            UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + cid + "/account/" + reservation.getId()).build();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/reservation/{rid}/close")
    public ResponseEntity<?> closeAccount(@PathVariable Integer cid, @PathVariable Integer rid) {

        customerService.deleteReservation(cid, rid);

        return new ResponseEntity<>(HttpStatus.OK);


    }

    @Autowired
    public void setReservationToReservationDto(ReservationToReservationDto reservationToReservationDto) {
        this.reservationToReservationDto = reservationToReservationDto;
    }

    @Autowired
    public void setReservationDtoToReservation(ReservationDtoToReservation reservationDtoToReservation) {
        this.reservationDtoToReservation = reservationDtoToReservation;
    }
}


