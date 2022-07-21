package hu.progmatic.springpractice;

import org.springframework.stereotype.Component;

@Component
public class UsdExchange implements Exchange {
    public UsdExchange() {
        System.out.println("Instantiating UsdExchange...");
    }

    @Override
    public double fromHUF(int huf) {
        return huf / 390.0;
    }
}
