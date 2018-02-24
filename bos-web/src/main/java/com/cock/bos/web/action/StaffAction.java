package com.cock.bos.web.action;

import com.cock.bos.domain.Staff;
import com.cock.bos.service.IStaffService;
import com.cock.bos.utils.PageBean;
import com.cock.bos.web.action.base.BaseAction;
import com.hazelcast.client.impl.protocol.task.list.ListSetMessageTask;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 取派员管理
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

    @Autowired
    private IStaffService staffService;

    //属性驱动，接收页面提交的分页参数
    private int page;
    private int rows;
    //属性驱动，接收页面提交的ids参数
    private String ids;

    /**
     * 添加取派员
     *
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        staffService.save(mModel);
        return LIST;
    }

    /**
     * 取派员批量删除
     *
     * @return
     * @throws Exception
     */
    public String deleteBatch() throws Exception {
        staffService.deleteBatch(ids);
        return LIST;
    }

    /**
     * 分页查询
     *
     * @return
     * @throws Exception
     */
    public String pageQuery() throws Exception {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        //创建离线提交查询对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
        pageBean.setDetachedCriteria(detachedCriteria);
        staffService.pageQuery(pageBean);
        //使用json-lib将PageBean对象转为json，通过输出流写回页面中
        //JSONObject---将单一对象转为json
        //JSONArray----将数组或者集合对象转为json
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"currentPage", "detachedCriteria", "pageSize"});
        String json = JSONObject.fromObject(pageBean, jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);
        return NONE;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
