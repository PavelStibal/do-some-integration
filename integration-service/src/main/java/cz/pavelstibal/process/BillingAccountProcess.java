package cz.pavelstibal.process;

import cz.pavelstibal.domain.Account;
import cz.pavelstibal.domain.CommonModel;
import cz.pavelstibal.mapper.BillingAccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class BillingAccountProcess implements Processor {

    @Override
    public void process(Exchange exchange) {
        final Object body = exchange.getMessage().getBody();
        if (body instanceof CommonModel commonModel && (commonModel.getApiModel() instanceof Account account)) {
            exchange.getMessage().setBody(BillingAccountMapper.toBillingAccount(account));
        }
    }
}
