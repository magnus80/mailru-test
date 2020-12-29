package helpers;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:common.properties"})
public interface TestConfig extends Config {

    @DefaultValue("10000")
    long timeout();

    @Key("test.url")
    String url();

    @Key("mail.login")
    String login();

    @Key("mail.pass")
    String password();

    @Key("mail.receiver")
    String receiver();

}
