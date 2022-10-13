package com.np.biblioteka.mvc;

import com.np.biblioteka.mvc.controller.Controller;
import com.np.biblioteka.mvc.controller.UserController;

import java.lang.reflect.Method;

public class MVC {

    public static final Class<? extends Controller> defaultController = UserController.class;
    public static final String DEFAULT_METHOD = "Index";


    public static void controller(Class<? extends Controller> controller, String methodName, Object... parameters) {
        try {
            Method m = controller.getMethod(methodName);
            Controller c = controller.getDeclaredConstructor().newInstance();
            m.invoke(c, parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void controller(Class<? extends Controller> controller) {
        controller(controller, DEFAULT_METHOD);
    }

    public static void controller() {
        controller(defaultController, DEFAULT_METHOD);
    }
}
