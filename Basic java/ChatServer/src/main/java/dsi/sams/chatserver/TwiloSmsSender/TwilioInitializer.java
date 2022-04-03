package dsi.sams.chatserver.TwiloSmsSender;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class TwilioInitializer {

    private final Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        String Sid=twilioConfiguration.getAccountSid();
        if(Objects.equals(twilioConfiguration.getAccountSid(), "AC900be5514a86042a0f98815f16f7360e"))
            Sid="MyID";
        LOGGER.info("Twilio initialized.... Account ID:{} {}",Sid,twilioConfiguration.getAccountSid()

        );
    }
}
