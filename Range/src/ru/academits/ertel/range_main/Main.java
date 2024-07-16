package ru.academits.ertel.range_main;

import ru.academits.ertel.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(4, 8);
        Range range2 = new Range(2, 6);

        Range intersection = range1.getIntersection(range2);

        System.out.println("Пересечение:");

        if (intersection == null) {
            System.out.println("Нет пересечений");
        } else {
            System.out.println(intersection.getFrom() + ", " + intersection.getTo());
        }

        System.out.println();

        Range[] union = range1.getUnion(range2);

        System.out.println("Объединение:");

        for (Range range : union) {
            double from = range.getFrom();
            double to = range.getTo();
            System.out.println(from + ", " + to);
        }

        System.out.println();

        Range[] complement = range1.getComplement(range2);

        System.out.println("Разность:");

        if (complement.length == 0) {
            System.out.println("Интервал находится внутри вычитаемого интервала.");
        } else {
            for (Range range : complement) {
                double from = range.getFrom();
                double to = range.getTo();
                System.out.println(from + ", " + to);
            }
        }
    }
}