package springchatapp.demo.model.value.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Uid {
    private int uid;

    public static Uid noValidateOf(int uid) {
        return Objects.isNull(uid) ? new Uid(0) : new Uid(uid);
    }

    public int getValue() {
        return this.uid;
    }
}
