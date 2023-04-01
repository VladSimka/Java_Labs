package by.vladsimonenko.eighthlab.variantC.service;

/**
 * Class that describes Laser Printer
 */
public class LaserPrinter extends Printer {
    private int tonerLevel;

    public LaserPrinter() {
        super();
        this.tonerLevel = 100;
    }

    public LaserPrinter(int tonerLevel) {
        super();
        try {
            if (tonerLevel < 0 || tonerLevel > 100) {
                throw new IllegalArgumentException("Невозможное значение уровня тонера!");
            } else {
                this.tonerLevel = tonerLevel;
            }
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void print(String document) {
        if (tonerLevel > 0) {
            try {
                super.print(document);
                tonerLevel--;
            }
            catch(RuntimeException e){
                logger.error(e.getMessage());
            }
        } else {
            logger.error("Недостаточно тонера");
        }
    }

    public void replaceToner() {
        this.tonerLevel = 100;
        logger.info("Картридж заменен. Уровень тонера: 100%.");
    }

    public void checkTonerLevel() {
        logger.info("Уровень тонера: " + this.tonerLevel + "%.");
    }

}
