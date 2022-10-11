package com.np.biblioteka.mvc.controller;

import com.np.biblioteka.Biblioteka;
import com.np.biblioteka.mvc.view.View;

import java.lang.reflect.Constructor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Controller {

    public void view(String viewName, Object... parameters) {
        if(parameters == null) {
            parameters = new Object[0];
        }
        String className = getViewClassName(viewName);

        try {
            Constructor[] constructors = Class.forName(className).getConstructors();
            for(Constructor constructor : constructors) {
                if(constructor.getParameterCount() == parameters.length) {
                    View view = (View) constructor.newInstance(parameters);
                    view.render();
                }
            }
        } catch(ClassNotFoundException e) {
            Biblioteka.getLogger().severe("View " + viewName + "not found (searched in " + className + ")");
            e.printStackTrace();
            System.exit(1);
        } catch (InstantiationException e) {
            Biblioteka.getLogger().severe("Could not instantinate view " + className);
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void view(String viewName) {
        view(viewName, null);
    }

    public void view() {
        String viewName = "Index";
        view(viewName);
    }


    private String getName() {
        String className = this.getClass().getName();
        String regex = this.getClass().getPackageName() + "\\.(.*)Controller";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(className);

        if(matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private String getViewClassName(String viewName) {
        String name = getName();
        String viewPackage = View.class.getPackageName() + "." + name.toLowerCase();
        String className = viewPackage + "." + viewName + "View";
        return className;
    }
}
