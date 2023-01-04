package hi.mynameisilnano.javarecord;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class IntervalRecordTest {

    private static final String BASE_PATH = "src/test/java/hi/mynameisilnano/javarecord";

    @Test
    @Disabled
    void createInvalidIntervalRecord() throws IOException {
        IntervalRecord intervalRecord = new IntervalRecord(10, 0);

        OutputStream outputStream = Files.newOutputStream(Path.of(BASE_PATH, "interval.invalid.record"));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(intervalRecord);
    }

    @Test
    void deserialize_shouldThrowException() throws IOException {
        InputStream inputStream = Files.newInputStream(Path.of(BASE_PATH, "interval.invalid.record"));

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Assertions.assertThrows(InvalidObjectException.class, objectInputStream::readObject);
    }

}