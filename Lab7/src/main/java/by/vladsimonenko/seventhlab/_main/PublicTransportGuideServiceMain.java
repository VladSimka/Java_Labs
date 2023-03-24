package by.vladsimonenko.seventhlab._main;

import by.vladsimonenko.seventhlab.service.PublicTransportGuideService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PublicTransportGuideServiceMain {
    static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        PublicTransportGuideService guideService = new PublicTransportGuideService("Минск");

        PublicTransportGuideService.Time time1 = null;
        PublicTransportGuideService.Time time2 = null;
        PublicTransportGuideService.Time time3 = null;
        PublicTransportGuideService.Time time4 = null;
        try {

            time1 = new PublicTransportGuideService.Time(8, 30);
            time2 = new PublicTransportGuideService.Time(14, 25);
            time3 = new PublicTransportGuideService.Time(7, 44);
            time4 = new PublicTransportGuideService.Time(6, 18);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }

        guideService.addRoute("101", time1, 1.50);
        guideService.addRoute("102", time2, 1.75);
        guideService.addRoute("103", time3, 2.00);
        guideService.addRoute("104", time4, 1.75);

        guideService.getInformation();


    }
}
