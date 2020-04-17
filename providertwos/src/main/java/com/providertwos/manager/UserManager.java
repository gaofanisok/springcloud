package com.providertwos.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.providertwos.dao.CommunalDao;

import com.providertwos.util.PageRequest;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auther: gaofan
 * @Date: 2020/4/17 0017 14 17
 * @Description:user逻辑层
 */
@Service
public class UserManager {
    @Resource
    CommunalDao communalDao;
    /**
     *<pre>
     * Description  : 查询  <br/>
     * ChangeLog    : 1. 创建 (2019/12/13 0013 10:38 [gaofan]);
     * @author gaofan
     * @date 2019/12/13 0013 10:38
     * @param pkid 用户ID
     * @return java.lang.String
     *</pre>
     */
    public String seleuser(String pkid,int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        JSONObject js=new JSONObject();
        String sql="select * from user ";
        List<Map<String,Object>> list=communalDao.query(sql);
        if (list.size()>0){
            js.put("username",list.get(0).getOrDefault("name",""));
            return js.toString();
        }

        return js.toString();
    }
    /**
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    private String getPageInfo(int pageIndex,int pageSize) {
        String sql="select * from user ";
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<Map<String,Object>> sysMenus = new PageInfo<>(communalDao.queryPage(sql));

        return "";
    }
}
