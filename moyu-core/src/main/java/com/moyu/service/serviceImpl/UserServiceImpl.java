package com.moyu.service.serviceImpl;

import com.moyu.biz.BizResult;
import com.moyu.dal.model.UserDO;
import com.moyu.dal.query.UserQuery;
import com.moyu.enums.UserStatusEnum;
import com.moyu.manager.UserManager;
import com.moyu.service.IUserService;
import com.moyu.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by XianGuo
 * Date: 2017-07-23 01:03
 * 用户相关接口实现
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserManager userManager;


    @Override
    public BizResult<Long> login(UserDO userDO) {
        return null;
    }

    @Override
    public BizResult<Long> insertUser(UserDO userDO) {
        return null;
    }

    @Override
    public BizResult<Long> updateUser(UserDO userDO) {
        return null;
    }

    @Override
    public BizResult<UserDO> register(UserDO userDO) {
        BizResult<UserDO> bizResult = new BizResult<>();
        BizResult<UserDO> queryResult = selectByQuery(userDO);
        if(queryResult.isSuccess()){
            bizResult.setMessage("用户已存在");
            bizResult.setSuccess(false);
            return bizResult;
        }
        Long userId = userManager.insertSelective(userDO);
        bizResult.setData(userManager.selectByPrimaryKey(userId));
        bizResult.setSuccess(true);
        return bizResult;
    }

    @Override
    public BizResult<UserDO> selectByQuery(UserDO userDO) {
        BizResult<UserDO> bizResult = new BizResult<>();
        UserQuery userQuery = new UserQuery();
        UserQuery.Criteria criteria = userQuery.createCriteria();
        if (userDO.getUserId() != null) {
            criteria.andUserIdEqualTo(userDO.getUserId());
        }
        if (StringUtil.isEmpty(userDO.getUserName())) {
            criteria.andUserNameLike(userDO.getUserName());
        }
        if (StringUtil.isEmpty(userDO.getLoginName())) {
            criteria.andLoginNameEqualTo(userDO.getLoginName());
        }
        if (userDO.getUserStatus() != null) {
            criteria.andUserStatusEqualTo(userDO.getUserStatus());
        }
        if (StringUtil.isEmpty(userDO.getUserMobile())) {
            criteria.andUserMobileEqualTo(userDO.getUserMobile());
        }
        List<UserDO> userDOS = userManager.selectByQuery(userQuery);
        if (CollectionUtils.isEmpty(userDOS)) {
            bizResult.setSuccess(false);
            bizResult.setMessage("没有找到相关用户信息");
            return bizResult;
        }
        bizResult.setData(userDOS.get(0));
        bizResult.setSuccess(true);
        return bizResult;
    }

    @Override
    public BizResult validUser(UserDO userDO) {
        BizResult bizResult = new BizResult();
        if (userDO == null) {
            bizResult.setSuccess(false);
            bizResult.setMessage("用户不存在");
            return bizResult;
        }

        UserStatusEnum statusEnum = UserStatusEnum.valueOf(userDO.getUserStatus());
        switch (statusEnum) {
            case BLACKLIST:
                bizResult.setMessage("用户已被拉黑");
                return bizResult;
            case DELETE:
                bizResult.setMessage("用户已被删除");
                return bizResult;
        }
        bizResult.setSuccess(true);
        return bizResult;
    }
}
