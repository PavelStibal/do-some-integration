package cz.pavelstibal.process;

import cz.pavelstibal.domain.Account;
import cz.pavelstibal.mapper.CommonModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class AccountProcess implements Processor {

    @Override
    public void process(Exchange exchange) {
        final Account account = exchange.getMessage().getBody(Account.class);
        exchange.getMessage().setBody(CommonModelMapper.toCommonModel(account));
    }
}
