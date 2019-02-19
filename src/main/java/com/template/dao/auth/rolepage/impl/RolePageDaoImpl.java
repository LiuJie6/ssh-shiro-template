package com.template.dao.auth.rolepage.impl;

import com.template.dao.auth.rolepage.api.IRolePageDao;
import com.template.dao.common.api.ICommonDao;
import com.template.model.auth.PageModel;
import com.template.model.auth.RoleModel;
import com.template.model.auth.RolePageModel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name:ssh-shiro-template
 * File Name:RolePageDaoImpl
 * Package Name:com.template.dao.auth.rolepage.impl
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("rolePageDao")
public class RolePageDaoImpl implements IRolePageDao{

    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    /**
     * 查询特定一个角色网页权限
     *
     * @param rolePageModel 查询条件
     * @return 查询结果
     */
    @Override
    public RolePageModel queryModel(RolePageModel rolePageModel) {
        return this.commonDao.queryModel(this.getCondition(rolePageModel), RolePageModel.class);
    }

    /**
     * 查询特定一组网页权限
     *
     * @param rolePageModel 查询条件
     * @return 查询结果
     */
    @Override
    public List<RolePageModel> queryModels(RolePageModel rolePageModel) {
        return this.commonDao.queryModels(this.getCondition(rolePageModel), RolePageModel.class);
    }

    /**
     * 查询特定一组角色网页权限信息
     *
     * @param roleModels 角色列表
     * @return 查询结果
     */
    @Override
    public List<RolePageModel> queryModels(List<RoleModel> roleModels) {
        String hql = "from RolePageModel as model where model.roleModel in :roleModels";

        try {
            Session session = this.commonDao.getSession();

            Query<RolePageModel> query = session.createQuery(hql, RolePageModel.class);
            query.setParameter("roleModels", roleModels);
            return query.list();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private String getCondition(RolePageModel rolePageModel) {
        HashSet<String> conditions = new HashSet<>();
        long id = rolePageModel.getRolePageId();
        RoleModel roleModel = rolePageModel.getRoleModel();
        PageModel pageModel = rolePageModel.getPageModel();
        if (id > 0)
            conditions.add("model.rolePageId=" + id);
        if (roleModel != null && roleModel.getRoleId() > 0) {
            conditions.add("model.roleModel.roleId=" + roleModel.getRoleId());
        }
        if (pageModel != null && pageModel.getPageId() > 0) {
            conditions.add("model.pageModel.pageId=" + pageModel.getPageId());
        }
        return this.commonDao.getAndCondition(conditions);
    }
}
