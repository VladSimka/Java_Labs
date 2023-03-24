package by.vladsimonenko.seventhlab._main;

import by.vladsimonenko.seventhlab.service.PublicTransportGuideService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.routing.Route;

import java.util.ArrayList;
import java.util.List;

public class PTGSAnonymousMain {

    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {


        var guide = new PublicTransportGuideService("Витебск") {
            public boolean isSuchRoute(String number) {
                boolean flag = false;
                for (Route route : routes) {
                    if (route.getNumber().equals(number)) {
                        flag = true;
                        break;
                    }
                }
                return flag;
            }
        };

        PublicTransportGuideService.Time time1 = new PublicTransportGuideService.Time(8, 30);
        PublicTransportGuideService.Time time2 = new PublicTransportGuideService.Time(14, 25);
        PublicTransportGuideService.Time time3 = new PublicTransportGuideService.Time(7, 44);
        PublicTransportGuideService.Time time4 = new PublicTransportGuideService.Time(6, 18);

        guide.addRoute("101", time1, 1.50);
        guide.addRoute("102", time2, 1.75);
        guide.addRoute("103", time3, 2.00);
        guide.addRoute("104", time4, 1.75);

        String number = "101fds";

        if (guide.isSuchRoute(number)) {

            System.out.println("Маршрут " + number + " существует");
        } else {
            System.out.println("Маршрута  " + number + " не существует");
        }


    }
}
