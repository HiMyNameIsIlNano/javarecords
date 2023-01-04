package hi.mynameisilnano.javarecord;

import java.io.Serializable;

public final class IntervalPojo implements Serializable {

    private int from;

    private int to;

    private IntervalPojo(int from, int to) {
        if (to < from) {
            throw new IllegalArgumentException("From before to");
        }

        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    public static class IntervalPojoBuilder {

        private int from;

        private int to;

        public IntervalPojoBuilder from(int from) {
            this.from = from;
            return this;
        }

        public IntervalPojoBuilder to(int to) {
            this.to = to;
            return this;
        }

        public IntervalPojo build() {
            return new IntervalPojo(from, to);
        }
    }
}
