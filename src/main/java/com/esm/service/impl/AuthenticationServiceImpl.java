package com.esm.service.impl;

import com.esm.dao.RoleDao;
import com.esm.dao.RootDao;
import com.esm.domain.NavData;
import com.esm.domain.NavDataItem;
import com.esm.domain.Role;
import com.esm.domain.Root;
import com.esm.service.AuthenticationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private RootDao rootDao;

    @Autowired
    private RoleDao roleDao;


    @Override
    public boolean Authentication(Integer roleId,String path) {

        Role role = roleDao.selectById(roleId);
        String power = role.getPower();
        String[] ids = power.split(",");
        ArrayList<Integer> roleIds = new ArrayList<>();
        for (String id : ids) {
            try {
                roleIds.add(Integer.valueOf(id));
            }catch (Exception ignored){

            }
        }
        System.out.println(roleIds);
        List<Root> rootList = rootDao.selectBatchIds(roleIds);
        System.out.println(rootList);

        String rootPath = path2RootPath(path.trim());

        for (Root r : rootList) {
            if (r.getApiPaths()!=null){
                System.out.println(r.getApiPaths());
                String[] split = r.getApiPaths().replace("[", "").replace("]", "").split(",");
                for (String s:split) {
                    if(s.trim().equals(rootPath.trim())||path.trim().equals("/pages/ESM.html")){
                        return true;
                    }
                }
            }
        }
        return false;
    }



    private String path2RootPath(String path){
        String[] split = path.split("/");
        System.out.println(Arrays.toString(split));
        if (StringUtils.isNumeric(split[split.length-1].split(",")[0])){
            return path.replace("/"+split[split.length-1],"");
        }
        return path;
    }
}
