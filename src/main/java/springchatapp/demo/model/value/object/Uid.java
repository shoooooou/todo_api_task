package springchatapp.demo.model.value.object;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uid uid = (Uid) o;
        return Objects.equals(this.uid, uid.uid);
    }

}
