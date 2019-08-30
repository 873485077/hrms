package org.java.md5;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;


/**
 * @Author: 马果
 * @Date: 2019/7/22 16:38
 * @Description:
 */
public class MD5Demo {

    private String pwd ="123";//原始密码



    /**
     * 074fdaff74a3fd7bcc109532ab5a9bed
     */
    @Test
    public void first(){

        Md5Hash md5 = new Md5Hash(pwd,"hr",3);
        System.out.println("加密后的结果是:"+md5.toString());

    }
    @Test
    public void second(){
        SimpleHash hash = new SimpleHash("md5",pwd,"d102",3);
        System.out.println("加密后的结果是:"+hash.toString());
    }
}
