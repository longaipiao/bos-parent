package com.cock.bos.web.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 表现层通用实现
 *
 * @param <T>
 */
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    public static final String HOME = "home";
    public static final String LIST = "list";

    //模型对象
    protected T mModel;

    /**
     * 在构造方法中动态获取实体类型，通过反射创建model对象
     *
     * @return
     */
    public BaseAction() {
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        Class<T> entityClass = (Class<T>) actualTypeArguments[0];
        try {
            //通过反射创建对象
            mModel = entityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public T getModel() {
        return mModel;
    }
}
