package com.cock.bos.service;

import com.cock.bos.domain.Staff;
import com.cock.bos.utils.PageBean;

public interface IStaffService {
    /**
     * 取派员保存
     *
     * @param mModel
     */
    void save(Staff mModel);

    /**
     * 取派员查询
     *
     * @param pageBean
     */
    void pageQuery(PageBean pageBean);

    /**
     * 取派员批量删除
     *
     * @param ids
     */
    void deleteBatch(String ids);
}
