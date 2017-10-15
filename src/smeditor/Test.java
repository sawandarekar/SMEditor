/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smeditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Sawan Darekar
 */
class Employee
    {
        String fName;
        String lName;
        Employee(String f, String l)
        {
            this.fName = f;
            this.lName = l;
        }
        @Override
        public String toString()
        {
            return this.fName+" "+this.lName;
        }
    }
public class Test {
    
    public void swap(Employee arg1, Employee arg2)
    {
        arg1.fName = "myswap";
        Employee temp = arg1;
        arg1 = arg2;
        arg2 = temp;
    }
    
    public static void main(String[] args) {
        Employee e1 = new Employee("raj", "pawar");
        Employee e2 = new Employee("nim", "gad");
        System.out.println("Before swap");
        System.out.println(e1);
        System.out.println(e2);
        new Test().swap(e1, e2);
        System.out.println("After swap");
        System.out.println(e1);
        System.out.println(e2);
        Object o = null;
        System.out.println(o);
        
        List<String> al = new ArrayList<String>();
        al.add("Bighe");
        al.add("CitBighe");
        al.add("alk");
        al.add("lsighe");
        al.add("alk");
        System.out.println(al);
        
        Set<String> st = new TreeSet<String>();
        st.add("Bighe");
        st.add("CitBighe");
        st.add("alk");
        st.add("lsighe");
        st.add("alk");
        System.out.println(st);
        
        Map<String,String> m = new HashMap<String, String>();
        m.put("myk", "myk");
        m.put("dfsk", "dfsk");
        m.put("ask", "ask");
        m.put("ljk", "ljk");
        m.put("sdk", "sdk");
        System.out.println(m);
        
        Map<Integer,String> m1 = new HashMap<Integer, String>();
        m1.put(12, "myk");
        m1.put(2, "dfsk");
        m1.put(56, "ask");
        m1.put(3, "ljk");
        m1.put(33, "sdk");
        m1.put(4, "pyjk");
        m1.put(6, "hmdk");        
        System.out.println(m1);
    }
}
