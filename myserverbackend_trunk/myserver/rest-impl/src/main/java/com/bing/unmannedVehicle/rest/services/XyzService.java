package com.bing.unmannedVehicle.rest.services;


import com.bing.unmannedVehicle.rest.db.XyzDao;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.UpdateResponse;
import nam.e.spa.ce.Xyz;
import nam.e.spa.ce.XyzKey;

/**
 * Created by bingzhang on 8/19/17.
 */
public class XyzService {
    private XyzDao _xyzDao;

    public XyzService(XyzDao xyzDao) {
        _xyzDao = xyzDao;
    }

    public Xyz get(XyzKey key) {
        Xyz xyz = _xyzDao.get(key);
        if (xyz == null) {
            xyz = new Xyz()
                    .setNumA(key.getNumA())
                    .setNumB(key.getNumB())
                    .setSum(key.getNumB() + key.getNumA());
        }
        return xyz;
    }

    public CreateResponse create(Xyz xyz){
        _xyzDao.insert(xyz);
        return new CreateResponse(HttpStatus.S_201_CREATED);
    }

    public UpdateResponse delete(XyzKey key){
        _xyzDao.delete(key);
        return new UpdateResponse(HttpStatus.S_200_OK);
    }

    public UpdateResponse update(XyzKey key, Xyz xyz){
        _xyzDao.update(key, xyz);
        return new UpdateResponse(HttpStatus.S_200_OK);
    }


}