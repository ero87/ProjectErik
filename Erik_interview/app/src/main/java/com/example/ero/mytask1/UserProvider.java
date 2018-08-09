package com.example.ero.mytask1;

import java.util.ArrayList;
import java.util.List;

public class UserProvider {

    public static int position;

    static List<UserModel> list = new ArrayList<>();

    public static List<UserModel> getUserList() {

        if (!list.isEmpty()) {
            list.clear();
        }
        return list;
    }

    public static UserModel getUserPosition() {
        return list.get(position);
    }
}
