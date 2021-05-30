package com.behsazan.util;

/**
 * Created by ${Eftekharnejad} on Apr, 2021
 **/

public class TradeNumberSingleton {
    private static TradeNumberSingleton singleton = null;
    private final String x;

    private TradeNumberSingleton(String x) {
        this.x = x;
    }

    public synchronized static TradeNumberSingleton getInstance() {
        if(singleton == null) {
            throw new AssertionError("You have to call init first");
        }

        return singleton;
    }

    public synchronized static TradeNumberSingleton init(String x) {
        if (singleton != null)
        {
            // in my opinion this is optional, but for the purists it ensures
            // that you only ever get the same instance when you call getInstance
            throw new AssertionError("You already initialized me");
        }

        singleton = new TradeNumberSingleton(x);
        return singleton;
    }


    public String getTradeNumberSingleton(){
        return x;
    }
}


