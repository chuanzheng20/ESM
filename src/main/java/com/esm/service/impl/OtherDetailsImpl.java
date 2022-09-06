package com.esm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.esm.dao.OtherDetailsDao;
import com.esm.dao.OtherDetailsQueryDao;
import com.esm.dao.OtherTypeDao;
import com.esm.domain.OtherDetails;
import com.esm.domain.OtherType;
import com.esm.domain.User;
import com.esm.domain.query.OtherDetailsQuery;
import com.esm.service.OtherDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/8/30 15:41
 * @Version 1.0
 */
@Service
public class OtherDetailsImpl implements OtherDetailsService {
    @Autowired
    private OtherDetailsQueryDao otherDetailsQueryDao;
    @Autowired
    private OtherDetailsDao otherDetailsDao;

    @Override
    public List<OtherDetailsQuery> select(String userId,Integer yMId) {
        QueryWrapper<OtherDetailsQuery> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("tb_wages.user_id",userId).in("tb_wages.y_m_id",yMId);
        queryWrapper.apply("tb_wages.user_id=tb_other_details.user_id")
                .apply("tb_wages.y_m_id=tb_other_details.y_m_id")
                .apply("tb_wages.y_m_id=tb_other_type.y_m_id")
                .apply("tb_other_details.other_type_id=tb_other_type.other_type_id");
        return otherDetailsQueryDao.findselect(queryWrapper);
    }

    @Override
    public boolean save(OtherDetails otherDetails) {
        int insert = otherDetailsDao.insert(otherDetails);
        if (insert > 0) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean delete(Integer otherDetailsId) {
        return false;
    }

    @Override
    public boolean update(OtherDetails otherDetails) {
        return false;
    }

    @Override
    public OtherDetails getById(Integer otherDetailsId) {
        return null;
    }

    @Override
    public List<OtherDetails> getAll() {
        return null;
    }
}
