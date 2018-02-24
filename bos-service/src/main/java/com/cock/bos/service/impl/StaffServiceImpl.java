package com.cock.bos.service.impl;

import com.cock.bos.dao.IStaffDao;
import com.cock.bos.domain.Staff;
import com.cock.bos.service.IStaffService;
import com.cock.bos.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private IStaffDao staffDao;

    /**
     * 取派员保存实现
     *
     * @param mModel
     */
    @Override
    public void save(Staff mModel) {
        staffDao.save(mModel);
    }

    /**
     * 取派员查询实现
     *
     * @param pageBean
     */
    @Override
    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);
    }

    /**
     * 取派员批量删除实现
     * 逻辑删除，将deltag改为1，为已经废除
     *
     * @param ids
     */
    @Override
    public void deleteBatch(String ids) {
        if (StringUtils.isNoneBlank(ids)) {
            String[] staffIds = ids.split(",");
            for (String id : staffIds) {
                staffDao.executeUpdate("staff.delete",id);
            }
        }
    }
}
