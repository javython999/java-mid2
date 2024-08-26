package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료: 0)");
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            numbers.add(input);
        }

        System.out.println("출력");

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        double average = (double) sum / numbers.size();

        System.out.println("합계: " + sum);
        System.out.println("평균: " + average);
    }
}
