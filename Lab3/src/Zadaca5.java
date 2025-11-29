import java.util.Arrays;
import java.util.Scanner;

public class Zadaca5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int taskNum = input.nextInt();
        int[] tasks = new int[taskNum];
        int timeNeeded = 0;
        int employeeNum = input.nextInt();

        for(int i = 0; i < taskNum; i++) {
            tasks[i] = input.nextInt();
            timeNeeded += tasks[i];
        }

        Arrays.sort(tasks);
        int daysTaken = 0;
        int freeTime = 0;

        while (timeNeeded > 0){
            int hoursWorked = 0;

            for(int i = 0; i < employeeNum; i++){
                for(int j = 0; j < taskNum; j++){
                    if(hoursWorked + tasks[j] <= 8){
                        hoursWorked += tasks[j];
                        timeNeeded -= tasks[j];
                        tasks[j] = 0;
                    }

                    if(hoursWorked == 8)
                        break;
                }

                freeTime += (8 - hoursWorked);
                hoursWorked = 0;
            }
            daysTaken++;
        }

        System.out.println(daysTaken + " " + freeTime);

    }
}