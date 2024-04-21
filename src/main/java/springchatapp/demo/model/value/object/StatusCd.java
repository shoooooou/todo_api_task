package springchatapp.demo.model.value.object;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class StatusCd {
    private String statusCd;

    public static StatusCd noValidateOf(String statusCd) {
        return Objects.isNull(statusCd) ? new StatusCd("") : new StatusCd(statusCd);
    }

    public String getValue() {
        return this.statusCd;
    }
}
