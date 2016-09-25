package com.example.allen.delta;

/**
 * Created by allam on 9/24/2016.
 */

public class Flight_States_Class {
    private FlightStatusResponse flightStatusResponse;

    public String getDepartureAirportCode() {
        return getFlightStatusResponse().getStatusResponse().getFlightStatusTO().getFlightStatusLegTOList().getDepartureAirportCode();
    }

    public String getDepartureTime(){
        return getFlightStatusResponse().getStatusResponse().getFlightStatusTO().getFlightStatusLegTOList().getDepartureLocalTimeScheduled();
    }

    public FlightStatusResponse getFlightStatusResponse() {
        return flightStatusResponse;
    }

    public class FlightStatusResponse {
        private StatusResponse statusResponse;

        public StatusResponse getStatusResponse() {
            return statusResponse;
        }
    }

    public class StatusResponse {
        private FlightStatusTO flightStatusTO;

        public FlightStatusTO getFlightStatusTO() {
            return flightStatusTO;
        }
    }

    public class FlightStatusTO {
        private FlightStatusLegTOList flightStatusLegTOList;

        public FlightStatusLegTOList getFlightStatusLegTOList() {
            return flightStatusLegTOList;
        }
    }

    public class FlightStatusLegTOList {
        private String departureAirportCode;
        private String departureLocalTimeScheduled;
        public String getDepartureAirportCode() {
            return departureAirportCode;
        }
        public String getDepartureLocalTimeScheduled(){return departureLocalTimeScheduled; }
    }
}

