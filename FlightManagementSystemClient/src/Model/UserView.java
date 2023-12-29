/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author ericbuturo
 */
public class UserView implements Serializable{
    private Integer flightid;
    private String firstname;
    private String lastname;
    private String airline;
    private String destination;
    private String seattype;
    private String seatnumber;
    private String paymentstatus;
    private String bookingdate;
    
    
    

    public UserView() {
    }

    public UserView(String firstname, String lastname, Integer flightid, String airline, String destination, String seattype, String seatnumber, String paymentstatus, String bookingdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.flightid = flightid;
        this.airline = airline;
        this.destination = destination;
        this.seattype = seattype;
        this.seatnumber = seatnumber;
        this.paymentstatus = paymentstatus;
        this.bookingdate = bookingdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getFlightid() {
        return flightid;
    }

    public void setFlightid(Integer flightid) {
        this.flightid = flightid;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSeattype() {
        return seattype;
    }

    public void setSeattype(String seattype) {
        this.seattype = seattype;
    }

    public String getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(String seatnumber) {
        this.seatnumber = seatnumber;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }
    
    @Override
    public String toString() {
        return "Userview: Flight id:" + flightid + ", Airline:" + airline + ", Booking Date:" +bookingdate+ ", Destination:" +destination+ ", First Name:" +firstname+ ", Last Name:" +lastname+ ", Payment Status:" +paymentstatus+ ", Seat Number:" +seatnumber+ ", Seat Type:" +seattype+"";
    }
    
}
