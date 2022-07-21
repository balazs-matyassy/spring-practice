package hu.progmatic.springpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RezsiExchangeFactory {
    @Bean
    @Primary
    public Exchange rezsiExchange() {
        return new Exchange() {
            @Override
            public double fromHUF(int huf) {
                if (huf <= 100000) {
                    return huf / 200.0;
                }

                return 500.0 + (huf - 100000) / 400.0;
            }
        };
    }
}
