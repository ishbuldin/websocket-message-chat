package ru.ishbuldin.andrei.websocketmessagechat;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class AuthUtil {
    public static boolean checkUser(File file, String username) {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return properties.containsKey(username);
    }
}