import java.util.Scanner;

public class CalculateDeposit {
    double calculateComplexPercentAmount(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercentAmount(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    void makeProcess() {
        int period;
        int action;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = userInput.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = userInput.nextInt();
        double finalAmount = 0;
        if (action == 1) {
            finalAmount = calculateSimplePercentAmount(amount, 0.06, period);
        } else if (action == 2) {
            finalAmount = calculateComplexPercentAmount(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        CalculateDeposit calcDeposit = new CalculateDeposit();
        calcDeposit.makeProcess();
    }


}
