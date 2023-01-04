package hi.mynameisilnano.javarecord;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class Loopback {

    private static final Logger LOG = Logger.getLogger(Loopback.class.toString());

    @PostMapping("/pojo")
    public void testValidationNoRecord(@RequestBody IntervalPojo intervalPojo) {
        LOG.info("Received: %s".formatted(intervalPojo));
    }

    @PostMapping("/record")
    public void testValidationWithRecord(@RequestBody IntervalRecord intervalRecord) {
        LOG.info("Received: %s".formatted(intervalRecord));
    }
}