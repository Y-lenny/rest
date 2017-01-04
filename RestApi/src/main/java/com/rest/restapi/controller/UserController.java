package com.rest.restapi.controller;

import com.rest.restapi.vo.OrderVo;
import com.rest.restapi.vo.UserVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by lennylv on 2017-1-3.
 * <p>
 * v1版本API
 */
@RestController
@RequestMapping(path = "/v1/users")
public class UserController {

    /**
     * 创建用户
     * 并且资源放在 LocationHeader 中
     *
     * @param userVo
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertUser(@RequestBody(required = true) UserVo userVo) {
        System.out.println(userVo);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(value = "id") int id) {
        System.out.println(id);
    }

    /**
     * 更新用户
     *
     * @param userVo
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateUser(@RequestBody(required = true) UserVo userVo) {
        System.out.println(userVo);
    }

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Object queryUserById(@PathVariable(value = "id") int id) {
        return new UserVo(id, "zhangsan", "zhangsan@tcl.com", "1234567890");
    }

    /**
     * 通过username过滤用户
     * ?username=zhangsan
     *
     * @param username
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Object queryUserByFilter(@PathVariable(value = "username") String username) {
        if ("zhangsan".equalsIgnoreCase(username)) {
            return new UserVo(0, "zhangsan", "zhangsan@tcl.com", "1234567890");
        } else {
            return null;
        }
    }

    /**
     * 通过username过滤用户
     * TODO ?sort=-id,+username
     *
     * @param username
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public Object queryUserSort(@PathVariable(value = "username") String username) {
        if ("zhangsan".equalsIgnoreCase(username)) {
            return new UserVo(0, "zhangsan", "zhangsan@tcl.com", "1234567890");
        } else {
            return null;
        }
    }

    /**
     * 通过username过滤用户
     * TODO ?q=zhangsan
     *
     * @param username
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public Object queryUserSearch(@PathVariable(value = "username") String username) {
        if ("zhangsan".equalsIgnoreCase(username)) {
            return new UserVo(0, "zhangsan", "zhangsan@tcl.com", "1234567890");
        } else {
            return null;
        }
    }

    /**
     * 通过username过滤用户
     * TODO ?fields=userId,username
     *
     * @param username
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public Object queryUserFields(@PathVariable(value = "username") String username) {
        if ("zhangsan".equalsIgnoreCase(username)) {
            return new UserVo(0, "zhangsan", "zhangsan@tcl.com", "1234567890");
        } else {
            return null;
        }
    }

    /**
     * 通过username过滤用户
     * TODO ?page=3&per_page=100
     *
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public Object queryUserPaging() {
        return null;
    }

    /**
     * 通过username过滤用户
     * TODO gzip压缩
     *
     * @param
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public Object queryUserGzip() {
        return null;
    }

    /**
     * 通过用户id查询订单
     *
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}/orders", method = RequestMethod.GET)
    public Object queryOrderByUserId(@PathVariable(value = "id") int id) {
        ArrayList orders = new ArrayList<OrderVo>();
        orders.add(new OrderVo(1, "order", id, null));
        System.out.println(orders);
        return orders;
    }

}