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
public class SourceClass {
    
    private int id;
    private String label;
    private double value;

    public SourceClass(int id, String label, double value) {
        this.id = id;
        this.label = label;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SourceClass{" + "id=" + id + ", label=" + label + ", value=" + value + '}';
    }
    
    
}
