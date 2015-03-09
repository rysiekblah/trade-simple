package com.rysiekblah.engine;

import quickfix.field.OrdType;

import java.util.function.Function;

/**
 * Created by tomek on 2/18/15.
 */
public class Order {
    private long time;
    private String sender;
    private String target;
    private String clientOrderId;
    private double price;
    private long quantity;
    private char type;
    private char side;
    private String symbol;
    OrdType t;

    private Function<Order, String> orderString = o -> "\n" +
            "Time: " + time + "\n" +
            "Sender: " + sender + "\n" +
            "Target: " + target + "\n" +
            "orderID: " + clientOrderId + "\n" +
            "Price: " + price + "\n" +
            "Quantity: " + quantity + "\n" +
            "Type: " + type + "\n";

    public Order(long time, String sender, String target, String clientOrderId, double price, long quantity, char type, char side, String symbol) {
        this.time = time;
        this.sender = sender;
        this.target = target;
        this.clientOrderId = clientOrderId;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.side = side;
        this.symbol = symbol;

    }

    public long getTime() {
        return time;
    }

    public String getSender() {
        return sender;
    }

    public String getTarget() {
        return target;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public double getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public char getType() {
        return type;
    }

    public char getSide() {
        return side;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Order{" +
                "time=" + time +
                ", sender='" + sender + '\'' +
                ", target='" + target + '\'' +
                ", clientOrderId='" + clientOrderId + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", type=" + type +
                ", side=" + side +
                ", symbol='" + symbol + '\'' +
                ", t=" + t +
                ", orderString=" + orderString +
                '}';
    }
}
