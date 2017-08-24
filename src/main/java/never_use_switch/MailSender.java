package never_use_switch;

public class MailSender {
    public void sendMail(MailInfo mailInfo) throws Exception {
        MailCodeEnum.findByCode(mailInfo.getMailCode()).generator();
    }
}
