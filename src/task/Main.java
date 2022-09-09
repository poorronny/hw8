package task;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println(isLeap(2020) ? "Год високосный" : "Год не високосный");
        //System.out.println(generateInstallationMassage(0, 2020));
        //System.out.println("Потребуется для доставки дней: " + calculateDeliveryDays(10));
        ;

    }

    private static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static String generateInstallationMassage(int os, int productionYear) {
        var allowedOs = new int[]{0, 1};
        if (!(os == 0 || os == 1)) {
            throw new RuntimeException("Устройство не поддерживается");
        }
        var currentYear = LocalDate.now().getYear();
        String versionMessage = productionYear < currentYear ? "облегченную " : "";
        String osMassage = os == 0 ? "iOS" : "Android";

        return String.format("Установите %s версию приложения для %s по ссылке", versionMessage, osMassage);
    }

    private static int calculateDeliveryDays(int distance) {
        int start = 20;
        int step = 40;
        int result = 1;
        if (distance >= start) {
            result = (Math.abs((distance - start) / step) + 2);
        }
        return result;
    }

}