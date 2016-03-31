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
        SourceClass source = new SourceClass(10, "Vikram", 76.4);
        TargetClass target = new TargetClass();

        runMapper(source, target);

        System.out.println(source);
        System.out.println(target);
    }

    private static void runMapper(SourceClass sc, TargetClass tc) {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src/methodmappingusingpropertyfile/mapper.properties");

            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String[] values = prop.getProperty(key).split(";");

                Method getter = SourceClass.class.getDeclaredMethod(values[0], new Class<?>[0]);
                Method setter = TargetClass.class.getDeclaredMethod(key, new Class<?>[]{});
                
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
