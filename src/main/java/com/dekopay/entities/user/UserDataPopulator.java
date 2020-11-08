package com.dekopay.entities.user;

import java.util.Collection;
import java.util.List;
import java.util.Map;

abstract public class UserDataPopulator {
    abstract public User populate(User object, Map data);
    abstract public List<List<String>> mapUser(Collection<User> collection);
}
