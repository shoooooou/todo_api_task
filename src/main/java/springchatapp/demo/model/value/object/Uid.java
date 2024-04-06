package springchatapp.demo.model.value.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Uid {
    private String uid;

    public static Uid noValidateOf(String uid) {
        return Objects.isNull(uid) ? new Uid("") : new Uid(uid);
    }

    public String getValue() {
        return this.uid;
    }
}
