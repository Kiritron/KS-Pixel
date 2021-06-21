/*
 * Copyright 2021 Kiritron's Space
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package space.kiritron.pixel;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Киритрон Стэйблкор
 */

public class GDate {

    private static String CurDaySTR() {
        String A = Integer.toString(new GregorianCalendar().get(Calendar.DAY_OF_MONTH));
        int B = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);

        if (B == 1) {
            A = "01";
        }

        if (B == 2) {
            A = "02";
        }

        if (B == 3) {
            A = "03";
        }

        if (B == 4) {
            A = "04";
        }

        if (B == 5) {
            A = "05";
        }

        if (B == 6) {
            A = "06";
        }

        if (B == 7) {
            A = "07";
        }

        if (B == 8) {
            A = "08";
        }

        if (B == 9) {
            A = "09";
        }

        return A;
    }

    private static String CurHourSTR() {
        String A = Integer.toString(new GregorianCalendar().get(Calendar.HOUR_OF_DAY));
        int B = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);

        if (B == 0) {
            A = "00";
        }

        if (B == 1) {
            A = "01";
        }

        if (B == 2) {
            A = "02";
        }

        if (B == 3) {
            A = "03";
        }

        if (B == 4) {
            A = "04";
        }

        if (B == 5) {
            A = "05";
        }

        if (B == 6) {
            A = "06";
        }

        if (B == 7) {
            A = "07";
        }

        if (B == 8) {
            A = "08";
        }

        if (B == 9) {
            A = "09";
        }

        return A;
    }

    private static String CurMinutesSTR() {
        String A = Integer.toString(new GregorianCalendar().get(Calendar.MINUTE));
        int B = new GregorianCalendar().get(Calendar.MINUTE);

        if (B == 0) {
            A = "00";
        }

        if (B == 1) {
            A = "01";
        }

        if (B == 2) {
            A = "02";
        }

        if (B == 3) {
            A = "03";
        }

        if (B == 4) {
            A = "04";
        }

        if (B == 5) {
            A = "05";
        }

        if (B == 6) {
            A = "06";
        }

        if (B == 7) {
            A = "07";
        }

        if (B == 8) {
            A = "08";
        }

        if (B == 9) {
            A = "09";
        }

        return A;
    }

    private static String CurSecondsSTR() {
        String A = Integer.toString(new GregorianCalendar().get(Calendar.SECOND));
        int B = new GregorianCalendar().get(Calendar.SECOND);

        if (B == 0) {
            A = "00";
        }

        if (B == 1) {
            A = "01";
        }

        if (B == 2) {
            A = "02";
        }

        if (B == 3) {
            A = "03";
        }

        if (B == 4) {
            A = "04";
        }

        if (B == 5) {
            A = "05";
        }

        if (B == 6) {
            A = "06";
        }

        if (B == 7) {
            A = "07";
        }

        if (B == 8) {
            A = "08";
        }

        if (B == 9) {
            A = "09";
        }

        return A;
    }

    private static String CurMonthSTR() {
        String A = Integer.toString(new GregorianCalendar().get(Calendar.MONTH) + 1);
        int B = new GregorianCalendar().get(Calendar.MONTH) + 1;

        if (B == 1) {
            A = "01";
        }

        if (B == 2) {
            A = "02";
        }

        if (B == 3) {
            A = "03";
        }

        if (B == 4) {
            A = "04";
        }

        if (B == 5) {
            A = "05";
        }

        if (B == 6) {
            A = "06";
        }

        if (B == 7) {
            A = "07";
        }

        if (B == 8) {
            A = "08";
        }

        if (B == 9) {
            A = "09";
        }

        return A;
    }

    public static String GetCurDateAndTimeWithSeconds() {
        return CurDaySTR() + "." + CurMonthSTR() + "." + new GregorianCalendar().get(Calendar.YEAR) + " " + CurHourSTR() + ":" + CurMinutesSTR() + ":" + CurSecondsSTR();
    }
    public static String GetCurDateAndTime() {
        return CurDaySTR() + "." + CurMonthSTR() + "." + new GregorianCalendar().get(Calendar.YEAR) + " " + CurHourSTR() + ":" + CurMinutesSTR();
    }
    public static String GetDate() {
        return CurDaySTR() + "-" + CurMonthSTR() + "-" + new GregorianCalendar().get(Calendar.YEAR);
    }
    public static String GetTime() {
        return CurHourSTR() + ":" + CurMinutesSTR();
    }
    public static String GetTimeWithSeconds() {
        return CurHourSTR() + ":" + CurMinutesSTR() + ":" + CurSecondsSTR();
    }
    public static String GetDateNoDay() {
        return CurMonthSTR() + "-" + new GregorianCalendar().get(Calendar.YEAR);
    }
}

