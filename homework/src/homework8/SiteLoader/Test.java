package homework8.SiteLoader;

import java.util.List;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        switch (chooseBank()) {
            case 1:
                System.out.println("продажа, НБРБ");
                loadRatesNBRB();
                break;
            case 2:
                System.out.println("продажа, БелАгропромБанк");
                loadRatesBAB();
                break;
            case 3:
                System.out.println("продажа, БПС");
                printRates(new BPSLoader());
                break;
            default:
                break;
        }
    }

    private static void printRates(SiteLoader loader){
        System.out.println(SiteLoader.Currency.EUR.toString() + " "
                + loader.load(SiteLoader.Currency.EUR));
        System.out.println(SiteLoader.Currency.RUB.toString() + " "
                + loader.load(SiteLoader.Currency.RUB));
        System.out.println(SiteLoader.Currency.USD.toString() + " "
                + loader.load(SiteLoader.Currency.USD));
    }

    private static void printRates(BABLoader loader, String date,
                                   String bankDateFormat){
        if (ProcessDate.isWeekend(date, bankDateFormat)) {
            System.out.println("Это выходной день. Актуальные курсы не доступны");
        } else {
            System.out.println(SiteLoader.Currency.EUR.toString() + " "
                    + loader.load(SiteLoader.Currency.EUR, date));
            System.out.println(SiteLoader.Currency.RUB.toString() + " "
                    + loader.load(SiteLoader.Currency.RUB, date));
            System.out.println(SiteLoader.Currency.USD.toString() + " "
                    + loader.load(SiteLoader.Currency.USD, date));
        }
    }

    private static void printRates(NBRBLoader loader, String date,
                                   String bankDateFormat){
            System.out.println(SiteLoader.Currency.EUR.toString() + " "
                    + loader.load(SiteLoader.Currency.EUR, date));
            System.out.println(SiteLoader.Currency.RUB.toString() + " "
                    + loader.load(SiteLoader.Currency.RUB, date));
            System.out.println(SiteLoader.Currency.USD.toString() + " "
                    + loader.load(SiteLoader.Currency.USD, date));
    }

    //1 - подготавливаем даты для запросов курсов в банк.
    //2 - выводим в консоль курс на диапазон дат.
    // Например 13.10.2020-23.10.2020 или 13.10.2020,23.10.2020.
    // Последнее число включительно.
    private static void loadRatesNBRB() {
        String dfsource = "dd.MM.yyyy";
        String dfbank = "yyyy-MM-dd";
        //1
        List<String> allDates = prepareDates(dfsource,
                dfbank);
        //2
        for (String allDate : allDates) {
            ProcessDate.printDate(allDate, dfbank, dfsource);
            printRates(new NBRBLoader(), allDate, dfbank);
        }
    }

    private static void loadRatesBAB() {
        String dfsource = "dd.MM.yyyy";
        String dfbank = "MM/dd/yyyy";
        //1
        List<String> allDates = prepareDates(dfsource,
                dfbank);
        //2
        for (String allDate : allDates) {
            ProcessDate.printDate(allDate, dfbank, dfsource);
            printRates(new BABLoader(), allDate, dfbank);
        }
    }

    //1 - получаем дату старта и окончания просмотра курсов валют
    //2 - получаем лист дат в том же формате, в каком был ввод
    //3 - преобразуем в формат для банка
    private static List<String> prepareDates(String dfsource,
                                             String dfbank) {
        String[] dates = new String[2];
        //1
        ProcessDate.inputStartEndDates(dates, dfsource);
        //2
        List<String> allDates =
                ProcessDate.allDatesInRange(dates, dfsource);
        //3
        for (int i = 0; i < allDates.size(); i++) {
            allDates.set(i, ProcessDate.transformDate(allDates.get(i),
                    dfsource, dfbank));
        }
        return allDates;
    }

    public static int chooseBank() {
        int bankNumber = 0;
        String buffer;
        Scanner scanner = new Scanner(System.in);
        do {
            printBanksList();
            try {
                buffer = scanner.nextLine();
                bankNumber = Integer.parseInt(buffer);
            } catch (NumberFormatException e) {
                System.out.println("Введите число от 1 до 3");
            }
        } while (bankNumber != 1 && bankNumber != 2 && bankNumber != 3);
        return bankNumber;
    }

    private static void printBanksList() {
        System.out.println("1. Национальный Банк - курс по дате или " +
                "диапазону дат. \n Для любых дней недели и года.");
        System.out.println("2. БелАгропромБанк - курс по дате или " +
                "диапазону дат. \n Только для рабочих дней.");
        System.out.println("3. БПС-Банк - только текущий курс, актуальный" +
                "на сегодня.");
        System.out.println("Выберите порядковое число банка для " +
                "запроса курса валют.");
    }
}
