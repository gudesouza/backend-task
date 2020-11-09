package com.dekopay.entities.user;

import java.util.Collection;
import java.util.Map;

/**
 * The UserDataPopulator class is responsible  to populate the User entity with values collected by different type of files
 * also responsible to map the data from a collection of user objects into different type of files.
 * Each file type have it's on implementation because of the data format are different for every file type, and the header/key/element
 * have different names but representing the same thing. i.e. "User Type" / "user_type" / "type"
 */
abstract public class UserDataPopulator {
    //abstract methods

    /**
     * Responsible to populate User data entity object
     * @param object
     * @param data
     * @return
     */
    abstract public User populate(User object, Map data);

    /**
     * Responsible to map the data from a collection of user objects
     * @param collection
     * @return
     */
    abstract public Object mapUser(Collection<User> collection);
}
