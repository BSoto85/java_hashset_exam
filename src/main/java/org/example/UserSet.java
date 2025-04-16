package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSet {
    HashSet<String> users = new HashSet<>();

    public Boolean addUser(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null");
        } else if (users.contains(username)) {
            return false;
        } else {
            users.add(username);
            return containsUser(username);
        }
    }

    public Boolean containsUser(String username) {
        return users.contains(username);
    }

    public int getUserCount() {
        return users.size();
    }

    public Boolean removeUser(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        } else {
            return users.remove(username);
        }
    }

    public HashSet<String> getUsersWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        return users.stream()
                .filter(user -> String.valueOf(user).startsWith(prefix))
                .collect(Collectors.toCollection(HashSet::new));
    }

    public Boolean areAllUsersUnique(String[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        return Arrays.stream(arr).distinct().count() == arr.length;
    }
}
