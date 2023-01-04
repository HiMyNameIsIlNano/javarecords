package hi.mynameisilnano.javarecord;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class IntervalPojoTest {

    private static final String BASE_PATH = "src/test/java/hi/mynameisilnano/javarecord";

    @Test
    @Disabled
    void createInvalidIntervalPojo() throws IOException {
        IntervalPojo intervalPojo = new IntervalPojo.IntervalPojoBuilder()
                .from(10)
                .to(0)
                .build();

        OutputStream outputStream = Files.newOutputStream(Path.of(BASE_PATH, "interval.invalid.pojo"));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(intervalPojo);
    }

    @Test
    void deserialize_shouldReturnInvalidInterval() throws IOException, ClassNotFoundException {
        InputStream inputStream = Files.newInputStream(Path.of(BASE_PATH, "interval.invalid.pojo"));

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        IntervalPojo interval = (IntervalPojo) objectInputStream.readObject();

        assertEquals( 10, interval.getFrom());
        assertEquals(0, interval.getTo());
    }

}
