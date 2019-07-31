package cn.itsource.plat.controller;

import cn.itsource.plat.controller.domain.User;
import cn.itsource.basic.util.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    @PostMapping("/login")
    //@RequestBody 接收json体形式的请求参数封装到实体类对象中
    //@ApiOperation("登录接口")
    //@ApiImplicitParams({
            //@ApiImplicitParam(name = "登录信息",value = "user")
    //})
    public AjaxResult login(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        //假登录
        if("admin".equals(username)&&"admin".equals(password)){
            return AjaxResult.me().setSuccess(true).setMessage("恭喜您登录成功!").setRestObj(user);
        }
        return AjaxResult.me().setSuccess(false).setMessage("哎哟，不好意思登录失败了!");
    }
}
