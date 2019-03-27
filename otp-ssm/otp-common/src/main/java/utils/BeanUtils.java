package utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author: jingtiancai
 * @date: 2018/9/17 19:01
 * @desc:
 */
public final class BeanUtils {
    public static void copyAttr(Object src, Object dest) throws Exception {
        // 获取属性
        BeanInfo srcBean = Introspector.getBeanInfo(src.getClass(), Object.class);
        PropertyDescriptor[] srcProperty = srcBean.getPropertyDescriptors();
        BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), Object.class);
        PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();
        try {
            for (int i = 0; i < srcProperty.length; i++) {
                for (int j = 0; j < destProperty.length; j++) {
                    if (srcProperty[i].getName().equals(destProperty[j].getName()) && srcProperty[i].getPropertyType() == destProperty[j].getPropertyType()) {
                        // 调用src的getter方法和dest的setter方法
                        destProperty[j].getWriteMethod().invoke(dest, srcProperty[i].getReadMethod().invoke(src));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("copy attribute fail : " + e.getMessage());
        }
    }
}
