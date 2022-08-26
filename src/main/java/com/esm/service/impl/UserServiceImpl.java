package com.esm.service.impl;

import com.esm.dao.GradedWagesDao;
import com.esm.dao.SectorDao;
import com.esm.domain.GradedWages;
import com.esm.domain.Level;
import com.esm.domain.Sector;
import com.esm.domain.User;
import com.esm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public SectorDao sectorDao;

    @Autowired
    public GradedWagesDao gradedWagesDao;


    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public List<Level> getLevel() {
        List<Sector> sectorList = sectorDao.getAll();
        List<GradedWages> gradedWagesList = gradedWagesDao.getAll();

        // {
        //     value: 'yiB',
        //             label: '1部门',
        //         children: [{
        //     value: 'sheji',
        //             label: '设计1',
        //             children: [{
        //         value: 'yiJ',
        //                 label: '1级别'
        //     }, {
        //         value: 'erJ',
        //                 label: '2级别'
        //     }, {
        //         value: 'sanJ',
        //                 label: '3级别'
        //     }, {
        //         value: 'siJ',
        //                 label: '4级别'
        //     }],
        //
        // }],
        List<Level> levelList = new ArrayList<>();
        for (Sector sector: sectorList) {
            List<Level> levels = new ArrayList<>();
            for (GradedWages gradedWages : gradedWagesList) {
                if(gradedWages.getSectorId().equals(sector.getSectorId())){
                    Level level = new Level();
                    level.setValue(gradedWages.getGradedId());
                    level.setLabel(gradedWages.getGradedName());
                }
            }
            if (levels.size()>0){
                Level level = new Level();
                level.setValue(sector.getSectorId());
                level.setLabel(sector.getSectorName());
                levelList.add(level);
            }
        }


        return levelList;
    }
}
