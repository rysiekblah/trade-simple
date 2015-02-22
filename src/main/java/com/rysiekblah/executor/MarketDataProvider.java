package com.rysiekblah.executor;

/**
 * Created by tomek on 2/21/15.
 */
public interface MarketDataProvider {
    double getBid(String symbol);
    double getAsk(String symbol);
}
