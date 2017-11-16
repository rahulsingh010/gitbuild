package com;

import java.util.Scanner;

public class FindDayBeasedOnYearMonthAndDate {

	public static void main(String[] args) {
        int y, sm, sd;
        int[] m = new int[12];
        m[0] = 31;
        m[1] = 28;
        m[2] = 31;
        m[3] = 30;
        m[4] = 31;
        m[5] = 30;
        m[6] = 31;
        m[7] = 31;
        m[8] = 30;
        m[9] = 31;
        m[10] = 30;
        m[11] = 31;
        //{31,28,31,30,31,30,31,31,30,31,30,31};

        String[] mo = new String[12];
        mo[0] = "January";
        mo[1] = "February";
        mo[2] = "March";
        mo[3] = "April";
        mo[4] = "May";
        mo[5] = "June";
        mo[6] = "July";
        mo[7] = "August";
        mo[8] = "September";
        mo[9] = "October";
        mo[10] = "November";
        mo[11] = "December";

        String[] we = new String[7];
        we[0] = "Sunday";
        we[1] = "Monday";
        we[2] = "Tuesday";
        we[3] = "Wednesday";
        we[4] = "Thursday";
        we[5] = "Friday";
        we[6] = "Saturday";

        Scanner ip = new Scanner(System.in);
        System.out.print("\nEnter year ");
        y = ip.nextInt();
        System.out.print("\nEnter month ");
        sm = ip.nextInt();
        System.out.print("\nEnter day ");
        sd = ip.nextInt();

        // Using the method Evgeniy Dorofeev kindly shared with us:
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            m[1] = m[1] + 1;
            System.out.print(y + " is a Leap Year.... ");
        } else {
            System.out.print(y + " is an Ordinary year.... ");
        }

        System.out.println(mo[sm - 1] + " month " + "has " + m[sm - 1] + " days");

        int dow = dayOfWeek(y, sm, sd);
        System.out.println("Day " + sd + " is a " + we[dow]);
    }

    //https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week#Implementation-dependent_methods_of_Sakamoto.2C_Lachman.2C_Keith_and_Craver
    public static int dayOfWeek(int y, int m, int d) {
        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        y -= (m < 3 ? 1 : 0);
        return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
        // 0 is Sunday, 1 is monday, ...
    }
}
