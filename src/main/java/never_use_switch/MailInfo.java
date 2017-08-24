package never_use_switch;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MailInfo {
    private ClientData clientData;
    private final int mailCode;
}
