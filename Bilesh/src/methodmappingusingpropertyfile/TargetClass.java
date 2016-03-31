/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodmappingusingpropertyfile;

/**
 *
 * @author bilesh
 */
public class TargetClass {
    
    private int roll;
    private String name;
    private double marks;

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    @Override
    public String toString() {
        return "TargetClass{" + "roll=" + roll + ", name=" + name + ", marks=" + marks + '}';
    }
    
}
