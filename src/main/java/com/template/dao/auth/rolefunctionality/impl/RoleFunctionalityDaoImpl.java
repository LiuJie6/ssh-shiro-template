package com.template.dao.auth.rolefunctionality.impl;

import com.template.dao.auth.rolefunctionality.api.IRoleFunctionalityDao;
import com.template.dao.common.api.ICommonDao;
import com.template.model.auth.FunctionalityModel;
import com.template.model.auth.RoleFunctionalityModel;
import com.template.model.auth.RoleModel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name:ssh-shiro-template
 * File Name:RoleFunctionalityDaoImpl
 * Package Name:com.template.dao.auth.rolefunctionality.impl
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("roleFunctionalityDao")
public class RoleFunctionalityDaoImpl implements IRoleFunctionalityDao{

    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    /**
     * 查询一个特定角色功能权限信息
     *
     * @param roleFunctionalityModel 查询条件
     * @return 查询结果
     */
    @Override
    public RoleFunctionalityModel queryModel(RoleFunctionalityModel roleFunctionalityModel) {
        return this.commonDao.queryModel(this.getCondition(roleFunctionalityModel), RoleFunctionalityModel.class);
    }

    /**
     * 查询特定一组角色功能权限信息
     *
     * @param roleFunctionalityModel 查询条件
     * @return 查询结果
     */
    @Override
    public List<RoleFunctionalityModel> queryModels(RoleFunctionalityModel roleFunctionalityModel) {
        return this.commonDao.queryModels(this.getCondition(roleFunctionalityModel), RoleFunctionalityModel.class);
    }

    /**
     * 查询特定一组角色功能权限信息
     *
     * @param roleModels 角色列表
     * @return 查询结果
     */
    @Override
    public List<RoleFunctionalityModel> queryModels(List<RoleModel> roleModels) {

        String hql = "from RoleFunctionalityModel as model where model.roleModel in :roleModels";

        try {
            Session session = this.commonDao.getSession();

            Query<RoleFunctionalityModel> query = session.createQuery(hql, RoleFunctionalityModel.class);
            query.setParameter("roleModels", roleModels);
            return query.list();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private String getCondition(RoleFunctionalityModel roleFunctionalityModel) {
        HashSet<String> conditions = new HashSet<>();
        long id = roleFunctionalityModel.getRoleFunctionalityId();
        RoleModel roleModel = roleFunctionalityModel.getRoleModel();
        FunctionalityModel functionalityModel = roleFunctionalityModel.getFunctionalityModel();
        if (id > 0)
            conditions.add("model.roleFunctionalityId=" + id);
        if (roleModel != null && roleModel.getRoleId() > 0) {
            conditions.add("model.roleModel.roleId=" + roleModel.getRoleId());
        }
        if (functionalityModel != null && functionalityModel.getFunctionId() > 0) {
            conditions.add("model.functionalityModel.functionId=" + functionalityModel.getFunctionId());
        }
        return this.commonDao.getAndCondition(conditions);
    }
}
