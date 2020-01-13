package com.example.springjpa.controller;


import com.example.springjpa.Mapper.BossUserMapper;
import com.example.springjpa.entity.BossUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test/")
public class BossUserController {

    @Autowired
    private BossUserMapper bossUserMapper;

    @Autowired
    private AsyncTest asyncTest;

    /**
     * 添加
     * @return
     */
    @RequestMapping("insert")
    public String insert(){
        BossUser bossUser = new BossUser();
        bossUser.setId("77");
        bossUser.setUsername("测试");
        bossUserMapper.save(bossUser);

        asyncTest.test();
        return "SUCCESS";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(String id){
        bossUserMapper.deleteById(id);
        return "SUCCESS";
    }

    /**
     * 修改
     * 修改跟添加调用的是同一个方法如果id相同就改变数据没有就创建数据
     * @param student
     * @return
     */
    @RequestMapping("update")
    public String update(BossUser student){
        student.setUsername("123");
        bossUserMapper.save(student);
        return "SUCCESS";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("getStudent")
    public List<BossUser> getStudent(){
        return (List<BossUser>)bossUserMapper.findAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("studentId")
    public BossUser getStudentById(String id){
        return bossUserMapper.findById(id).get();
    }

}
