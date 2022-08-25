package com.esm.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.esm.dao.RoleDao;
import com.esm.dao.RootDao;
import com.esm.domain.NavData;
import com.esm.domain.NavDataItem;
import com.esm.domain.Role;
import com.esm.domain.Root;
import com.esm.service.NavService;
import jdk.nashorn.internal.runtime.ListAdapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class NavServiceImpl implements NavService {

    @Autowired
    private RootDao rootDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<NavData> getNavByRoleId(Integer RoleId){
        Role role = roleDao.selectById(RoleId);
        String power = role.getPower();
        String[] ids = power.split(",");
        ArrayList<Integer> roleIds = new ArrayList<>();
        for (String id : ids) {
            try {
                roleIds.add(Integer.valueOf(id));

            }catch (Exception ignored){

            }
        }
        List<NavData> data = new ArrayList<>();
        if (roleIds!=null){
            System.out.println(roleIds);
            List<Root> roots = rootDao.selectBatchIds(roleIds);
            List<ArrayList<Root>> listListRoot = new ArrayList<>();
            for (Root root: roots){
                if(listListRoot.size()==0){
                    ArrayList<Root> arrays = new ArrayList<Root>();
                    arrays.add(root);
                    listListRoot.add(arrays);
                }else {
                    boolean T=false;
                    for (List<Root> r: listListRoot) {
                        for (Root root1 :r){
                            if (root.getFatherId().equals(root1.getFatherId())){
                                r.add(root);
                                T=true;
                                break;
                            }
                        }
                    }
                    if (!T){
                        ArrayList<Root> arrays = new ArrayList<Root>();
                        arrays.add(root);
                        listListRoot.add(arrays);
                    }
                }
            }
            // System.out.println("--------------------------------------");
            System.out.println(listListRoot);

            List<Root> fatherRoots = rootDao.selectByFatherId(0);
            // System.out.println(fatherRoots);
            for (ArrayList<Root> arrayList: listListRoot) {
                ArrayList<NavDataItem> navDataItems = new ArrayList<>();
                for (Root root:arrayList){

                    NavDataItem navDataItem = new NavDataItem(root.getIdx(),root.getName(),root.getPath());
                    navDataItems.add(navDataItem);
                }
                for (Root r: fatherRoots) {
                    if (r.getRootId().equals(arrayList.get(0).getFatherId())){
                        // Root fatherRoot = rootDao.selectById(arrayList.get(0).getFatherId());
                        NavData navData = new NavData(r.getIdx(),r.getName(),r.getIcon(),navDataItems);
                        data.add(navData);
                    }
                }

            }
        }
        return data;
    }

}
