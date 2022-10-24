package com.fifi.observer.demo;

/**
 * P2P投资理财系统
 * UserController
 *
 * @author Alicia
 * @description
 * @date 2022/10/24
 */
public class UserController {
    private UserService userService;
    private PromotionService promotionService;

    /**
     * 注册用户发放投资体验金
     * @param telephone
     * @param password
     * @return
     */
    public Long register(String telephone, String password){
        //省略输入参数的校验代码
        //省略userservice.register 异常的 try-catch 代码
        long userId = userService.register(telephone, password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
}
