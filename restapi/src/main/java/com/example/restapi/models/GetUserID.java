package com.example.restapi.models;

import java.util.UUID;

public class GetUserID {
    private UUID user_id;

    public GetUserID(UUID user_id) {
        this.user_id = user_id;
    }

    public UUID getUser_id() {
        return user_id;
    }
}
