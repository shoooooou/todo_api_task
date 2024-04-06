package springchatapp.demo.model.value.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserName {
    private String userName;

    public static UserName noValidateOf(String username) {
        return Objects.isNull(username) ? new UserName("") : new UserName(username);
    }

    public String getValue() {
        return this.userName;
    }
}
