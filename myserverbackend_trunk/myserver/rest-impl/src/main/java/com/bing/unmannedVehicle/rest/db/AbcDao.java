package com.bing.unmannedVehicle.rest.db;


import nam.e.spa.ce.Abc;

/**
 * Created by bingzhang on 8/18/17.
 */
public interface AbcDao {
    Abc get(String longUrl);
    // new stuff
    void insert(Abc abc);
    void delete(String longUrl);
    void update(String longUrl, Abc abc);
}
