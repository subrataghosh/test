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
    
    private String id;
    private String label;
    private String value;   

    public SourceClass(String id, String label, String value) {
        this.id = id;
        this.label = label;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SourceClass{" + "id=" + id + ", label=" + label + ", value=" + value + '}';
    }
    
    
}
