package com.bing.unmannedVehicle.rest.db.fake;

import com.bing.unmannedVehicle.rest.db.XyzDao;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import nam.e.spa.ce.Abc;
import nam.e.spa.ce.Xyz;
import nam.e.spa.ce.XyzKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bingzhang on 8/19/17.
 */
public class XyzKeyImpl implements XyzDao{

    private Map<String, Xyz> _dataBase;

    public XyzKeyImpl(){ _dataBase = new HashMap<>(); }

    @Override
    public Xyz get(XyzKey complexKey) {
        return _dataBase.get(complexKey.getNumA() + "_" + complexKey.getNumB());
    }

    @Override
    public void insert(Xyz xyzKey) {

         _dataBase.put(xyzKey.getNumA() + "_" + xyzKey.getNumB(), xyzKey);
    }

    @Override
    public void delete(XyzKey complexKey) {

         _dataBase.remove(complexKey.getNumA() + "_" + complexKey.getNumB());
    }

    @Override
    public void update(XyzKey complexKey, Xyz xyz) {

        _dataBase.put(complexKey.getNumA() + "_" +complexKey.getNumB(), xyz);
    }


}
