import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.IT;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JsonTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void JacksonTest() throws IOException {

        File file = new File("src/test/resources/candidate.json");
        IT it = objectMapper.readValue(file, new TypeReference<IT>() {
        });
        Assertions.assertThat(it.getAge()).isEqualTo(38);
        Assertions.assertThat(it.getName()).isEqualTo("Mikle");
        Assertions.assertThat(Arrays.stream(it.getPosition()).findFirst().get()).isEqualTo("Founder");
        Assertions.assertThat(Arrays.stream(it.getSalary().keySet().toArray()).findFirst().get()).isEqualTo("2018");
    }
}
