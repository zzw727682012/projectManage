package com.Utils;

import java.util.List;

@XmlRootName(rootName = "Picking")
public class Order {

    @Attribute
    public String code;
    public String customercode;
    public List<Orderentry> orderentries;

}
