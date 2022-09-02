package com.esm.service.impl;

import com.esm.dao.RootDao;
import com.esm.domain.NavData;
import com.esm.domain.NavDataItem;
import com.esm.domain.Root;
import com.esm.domain.query.RootQuery;
import com.esm.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    private RootDao rootDao;

    @Override
    public boolean save(Root root) {
        return false;
    }

    @Override
    public boolean delete(Integer rootId) {
        return false;
    }

    @Override
    public boolean update(Root root) {
        return false;
    }

    @Override
    public Root getById(Integer rootId) {
        return null;
    }

    @Override
    public List<Root> getAll() {
        List<Root> roots = rootDao.selectList(null);
        return roots;

    }

    @Override
    public List<RootQuery> getToLevelAll() {
        List<Root> rootList = this.getAll();

        List<RootQuery> rootQueryList = new ArrayList<>();
        for (Root root: rootList){
            if (root.getFatherId().equals(0)){
                RootQuery rootQuery = root2RootQuery(root);
                rootQuery.setChildren(new ArrayList<>());
                rootQueryList.add(rootQuery);
            }else {
                for (RootQuery rootQuery1:rootQueryList){

                    if (rootQuery1.getRootId().equals(root.getFatherId())){

                        RootQuery rootQuery = root2RootQuery(root);
                        rootQuery1.getChildren().add(rootQuery);
                    }
                }
            }
        }
        return rootQueryList;
    }

    private RootQuery root2RootQuery(Root root) {
        RootQuery rootQuery = new RootQuery();
        rootQuery.setRootId(root.getRootId());
        rootQuery.setIdx(root.getIdx());
        rootQuery.setName(root.getName());
        rootQuery.setIcon(root.getIcon());
        rootQuery.setPath(root.getPath());
        rootQuery.setFatherId(root.getFatherId());
        return rootQuery;
    }


}
