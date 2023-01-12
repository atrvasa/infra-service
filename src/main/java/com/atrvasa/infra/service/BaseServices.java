/*
 * MIT License (https://github.com/atrvasa/infra-service/blob/main/LICENSE)
 * Repository (https://github.com/atrvasa/infra-service)
 */

package com.atrvasa.infra.service;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Defines a set of delegates and services.
 *
 * <p>The implementation-created instance of a Services should
 * implement getServices method to add services and delegates.</p>
 *
 * @author  Keykhosrow
 *
 * {@link javax.ws.rs.core.Application}.
 */
public abstract class BaseServices extends Application {


    /**
     * Add all classes that returned from getServices method to classes field.
     */
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        List<Class<?>> types = getServices();
        for (Class<?> type : types)
            classes.add(type);
        return classes;
    }

    /**
     * Implemented classes must add services and delegates to property and return.
     *
     * <p>Implementations should warn about and ignore classes for which
     * {@link #getSingletons()} returns an instance. Implementations MUST
     * NOT modify the returned set.</p>
     *
     * <p>The default implementation returns an empty set.</p>
     *
     * @return a set of root resource and provider classes. Returning null
     *         is equivalent to returning an empty set.
     */
    public abstract List<Class<?>> getServices();
}