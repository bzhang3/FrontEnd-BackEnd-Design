package com.bing.unmannedVehicle.rest.services;

import com.bing.unmannedVehicle.rest.db.fake.AbcDaoImpl;
import nam.e.spa.ce.Abc;

/**
 * Created by bingzhang on 8/19/17.
 */
public class AbcServiceFactory {

    private static AbcService _abcService;
    private static Object _lock = new Object();

    private AbcServiceFactory() {}

    public static AbcService createInstance() {
        if (_abcService == null) {
            synchronized (_lock) {
                if (_abcService == null) {
                    _abcService = new AbcService(new AbcDaoImpl());
                }
            }
        }
        return _abcService;
    }

}


