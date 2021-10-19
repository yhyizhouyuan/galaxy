package com.galaxy.common.utils.security;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * <p>对称密钥密码算法工具类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/17 23:01
 */
public class CipherUtils {
    /**
     * 生成随机秘钥
     *
     * @param keyBitSize 字节大小
     * @param algorithmName 算法名称
     * @return 创建密匙
     */
    public static Key generateNewKey(int keyBitSize, String algorithmName)
    {
        KeyGenerator kg;
        try
        {
            kg = KeyGenerator.getInstance(algorithmName);
        }
        catch (NoSuchAlgorithmException e)
        {
            String msg = "Unable to acquire " + algorithmName + " algorithm.  This is required to function.";
            throw new IllegalStateException(msg, e);
        }
        kg.init(keyBitSize);
        return kg.generateKey();
    }
}
