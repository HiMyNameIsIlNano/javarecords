package hi.mynameisilnano.javarecord;

import java.io.Serializable;

public record IntervalRecord(int from, int to) implements Serializable {

    public IntervalRecord {
        if (to < from) {
            throw new IllegalArgumentException("From before to");
        }
    }

}
