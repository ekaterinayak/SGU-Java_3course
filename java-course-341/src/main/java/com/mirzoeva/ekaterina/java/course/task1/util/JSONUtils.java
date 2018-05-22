package com.mirzoeva.ekaterina.java.course.task1.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mirzoeva.ekaterina.java.course.task1.model.BankUser;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * @author mirzoeva.ekaterina
 */
public class JSONUtils {

    @SneakyThrows
    public static void write(final String fileName, List<BankUser> users){
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        Files.write(filePath, getGson().toJson(users).getBytes());
    }

    @SneakyThrows
    public static List<BankUser> read(final String fileName) {
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            return Collections.EMPTY_LIST;
        }
        String data = new String(Files.readAllBytes(filePath));
        return getGson().fromJson(data, new TypeToken<List<BankUser>>(){}.getType());
    }

    private static Gson getGson() {
        return new GsonBuilder().create();
    }
}
