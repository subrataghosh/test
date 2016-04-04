/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodmappingusingpropertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author bilesh
 */
public class MethodMappingUsingPropertyFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SourceClass source = new SourceClass("10", "Vikram", "76.4");
        TargetClass target = new TargetClass();

        runMapper(source, target);

        System.out.println(source);
        System.out.println(target);
    }

    private static void runMapper(SourceClass sc, TargetClass tc) {

        //no paramater
        Class noparams[] = {};

        //String parameter
        Class[] paramString = new Class[1];
        paramString[0] = String.class;

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src/methodmappingusingpropertyfile/mapper.properties");

            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);

                Method getter = SourceClass.class.getDeclaredMethod(key, noparams);
                Method setter = TargetClass.class.getDeclaredMethod(value, paramString);
                
                String temp = (String) getter.invoke(sc);
                setter.invoke(tc, temp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
