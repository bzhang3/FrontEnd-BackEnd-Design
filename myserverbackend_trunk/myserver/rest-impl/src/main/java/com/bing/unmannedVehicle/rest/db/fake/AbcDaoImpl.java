package com.bing.unmannedVehicle.rest.db.fake;

import nam.e.spa.ce.Abc;
import com.bing.unmannedVehicle.rest.db.AbcDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bingzhang on 8/18/17.
 */
public class AbcDaoImpl implements AbcDao{
    private Map<String, Abc> _dataBase;

    public AbcDaoImpl() { _dataBase = new HashMap<>(); }

    @Override
    public Abc get(String longUrl) {return _dataBase.get(longUrl); }

    @Override
    public void insert(Abc abc){
        _dataBase.put(abc.getLongUrl(), abc);
    }
    @Override
    public void delete(String longUrl){
        _dataBase.remove(longUrl);
    }
    @Override
    public void update(String longUrl, Abc abc){
        _dataBase.put(longUrl, abc);
    }

}
