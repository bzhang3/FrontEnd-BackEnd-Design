package com.bing.unmannedVehicle.rest.services;

import com.bing.unmannedVehicle.rest.db.fake.XyzKeyImpl;
import nam.e.spa.ce.Xyz;

/**
 * Created by bingzhang on 8/19/17.
 */
public class XyzServiceFactory {

    private static XyzService _xyzService;
    private static Object _lock = new Object();

    private XyzServiceFactory() {}

    public static XyzService createInstance() {
        if (_xyzService == null) {
            synchronized (_lock) {
                if (_xyzService == null) {
                    _xyzService = new XyzService(new XyzKeyImpl());
                }
            }
        }
        return _xyzService;
    }

}
