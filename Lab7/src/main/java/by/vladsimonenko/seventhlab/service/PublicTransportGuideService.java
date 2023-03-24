package by.vladsimonenko.seventhlab.service;

import java.util.ArrayList;
import java.util.List;

public class PublicTransportGuideService {
    private String city;
    protected List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public PublicTransportGuideService(String city) {
        this.city = city;
        this.routes = new ArrayList<>();
    }


    public void addRoute(String number, Time time, double cost) {
        Route route = new Route(number, time, cost);
        routes.add(route);
    }

    public void getInformation() {
        System.out.println("Справочная служба общественного транспорта : " + city);
        for (Route route : routes) {
            System.out.println("Номер маршрута: " + route.number);
            System.out.println("Время отправления : " + route.departureTime.hour + ":" + route.departureTime.minute);
            System.out.println("Цена: " + route.cost);
            System.out.println();
        }
    }

    /**
     * Inner class route
     */
    protected class Route {
        private String number;
        private Time departureTime;
        private double cost;

        public Route(String number, Time time, double cost) {
            this.number = number;
            this.departureTime = time;
            this.cost = cost;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Time getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(Time departureTime) {
            this.departureTime = departureTime;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
    }


    /**
     * Nested class Time
     */
    public static class Time {
        private int hour;
        private int minute;

        public Time(int hour, int minute) {
            if (hour < 0 || hour > 59 || minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Некоректные  данные!");
            }
            this.hour = hour;
            this.minute = minute;
        }

    }
}
