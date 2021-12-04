package com.example.restapi.models;

import org.aspectj.weaver.ast.Or;

public class View {
    public static interface Orders {
    }

    public static interface OrdersWithCustomerName extends Orders {
    }

    public static interface OrdersWithRestaurantName extends Orders {
    }
}
