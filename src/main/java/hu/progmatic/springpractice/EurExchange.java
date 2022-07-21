package hu.progmatic.springpractice;

import org.springframework.stereotype.Component;

@Component
public class EurExchange implements Exchange {

    @Override
    public double fromHUF(int huf) {
        return huf / 400.0;
    }
}
