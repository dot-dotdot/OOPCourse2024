package ru.academits.ertel.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (this.from == range.from && this.to == range.to) {
            return new Range(this.from, this.to);
        }

        if (range.from >= this.to || this.from >= range.to) {
            return null;
        }

        double intersectionFrom = Math.max(this.from, range.from);
        double intersectionTo = Math.min(this.to, range.to);

        return new Range(intersectionFrom, intersectionTo);
    }

    public Range[] getUnion(Range range) {
        if (this.from == range.from && this.to == range.to) {
            return new Range[] {new Range(this.from, this.to)};
        }

        if (range.from > this.to || this.from > range.to) {
            return new Range[] {new Range(this.from, this.to), new Range(range.from, range.to)};
        }

        double unionFrom = Math.min(this.from, range.from);
        double unionTo = Math.max(this.to, range.to);

        return new Range[] {new Range(unionFrom, unionTo)};
    }

    public Range[] getComplement(Range range) {
        if (this.from >= range.from && this.to <= range.to) {
            return new Range[0];
        }

        if (range.from >= this.to || this.from >= range.to) {
            return new Range[] {new Range(this.from, this.to)};
        }

        if (this.from < range.from && this.to > range.to) {
            return new Range[] {new Range(this.from, range.from), new Range(range.to, this.to)};
        }

        return (this.from < range.to && this.to > range.to) ?
                new Range[] {new Range(range.to, this.to)} : new Range[] {new Range(this.from, range.from)};
    }
}