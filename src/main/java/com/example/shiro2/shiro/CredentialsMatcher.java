package com.example.shiro2.shiro;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;


public class CredentialsMatcher extends SimpleCredentialsMatcher {
    /**
     * 自定义的密码比较器
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
     UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
     /**获取用户输入的密码
      * */
        String inpassword = new String(usernamePasswordToken.getPassword());
        /**从数据库中查询出来的密码
         *
         * */
        String password = (String) info.getCredentials();
     return this.equals(inpassword,password);
    }
}
