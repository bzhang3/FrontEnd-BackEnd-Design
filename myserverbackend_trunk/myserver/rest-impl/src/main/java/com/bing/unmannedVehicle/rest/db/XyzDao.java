package com.bing.unmannedVehicle.rest.db;

import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import nam.e.spa.ce.Xyz;
import nam.e.spa.ce.XyzKey;

/**
 * Created by bingzhang on 8/19/17.
 */
public interface XyzDao {
    Xyz get(XyzKey xyzkey);
    void insert(Xyz xyz);
    void delete(XyzKey key);
    void update(XyzKey key, Xyz xyz );
}
