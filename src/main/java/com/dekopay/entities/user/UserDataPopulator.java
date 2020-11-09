package com.dekopay.entities.user;

import java.util.Collection;
import java.util.Map;

abstract public class UserDataPopulator {
    //abstract methods

    /**
     * Responsible to populate User data object
     * @param object
     * @param data
     * @return
     */
    abstract public User populate(User object, Map data);

    /**
     * Responsible to map the data from a collection of users
     * @param collection
     * @return
     */
    abstract public Object mapUser(Collection<User> collection);
}
