package com.imhui.common.util.redis;

import java.io.*;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
public class SerializeUtil {

    static final Class<?> CLAZZ = SerializeUtil.class;

    public static byte[] serialize(Object object) {
        if (null == object) {
            throw new NullPointerException("obj == null");
        }
        byte[] res = null;
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.close();
            baos.close();
            res = baos.toByteArray();
        }catch (Exception e) {

        }finally {
            close(oos);
            close(baos);
        }
        return res;
    }

    public static <T> T deserialize(byte[] in, Class<T>...requiredType) {
        Object object = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            if (in != null) {
                bais = new ByteArrayInputStream(in);
                ois = new ObjectInputStream(bais);
                object = ois.readObject();
            }
        }catch (Exception e) {

        } finally {
            close(ois);
            close(bais);
        }
        return (T) object;
    }

    public static Object deserialize(byte[] in) {
        return deserialize(in, Object.class);
    }



    private static void close(Closeable closeable) {
        if (closeable != null)
            try {
                closeable.close();
            }catch (IOException e) {

            }
    }
}
