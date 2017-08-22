package com.bing.myserver.rest.services;

import com.bing.myserver.rest.r2Client.R2Client;

/**
 * Created by bingzhang on 8/21/17.
 */
public class R2ClientServiceFactory {
    private static R2ClientService _abcService;
    private static Object _lock = new Object();

    private R2ClientServiceFactory() {}

    public static R2ClientService createInstance() {
        if (_abcService == null) {
            synchronized (_lock) {
                if (_abcService == null) {
                    _abcService = new R2ClientService(new R2Client());
                }
            }
        }
        return _abcService;
    }
}
