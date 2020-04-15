package com.Utils;

import org.apache.poi.ss.formula.functions.T;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class XmlUtils {

    public static void convertXmlToObject(File file){
        SAXReader reader = new SAXReader();

        try {
            Document document = reader.read(file);
            Element root = document.getRootElement();
            Iterator it = root.elementIterator();
            int i =0;
            while (it.hasNext()){

                Element parent = (Element) it.next();
                Iterator iterator1 = parent.attributeIterator();
                System.out.println(i++);
                System.out.println(parent.attribute(0).getValue());
                System.out.println(parent.element("status").getText());
         /*       while (iterator1.hasNext()){
                    org.dom4j.Attribute attribute = (org.dom4j.Attribute) iterator1.next();
                    System.out.println(attribute.getValue());
                }
                Iterator iterator = parent.elementIterator();
                while (iterator.hasNext()){
                    Element child = (Element) iterator.next();
                    System.out.println(child.getName()+ "------" +child.getText());
                }*/
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static <T> void convertListToXml(List<T> items, Class<T> clz){
        FileOutputStream out = null;

        try {
            String filePath = "/FTP/GZ/Request/";
            String fileName = "request" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xml";


                File file = new File(filePath);
                if (!file.exists()) {
                    file.mkdirs();
                }

                File file2 = new File(filePath + fileName);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();


            Document document = DocumentHelper.createDocument();

            if (clz.isAnnotationPresent(XmlRootName.class)){
                XmlRootName rootName = (XmlRootName)clz.getAnnotation(XmlRootName.class);
                Element root = document.addElement(rootName.rootName());
                convertListToXml(items, root, clz);

                out = new FileOutputStream( file2 );  //写入文件
                OutputFormat format = OutputFormat.createPrettyPrint();  //转换成字符串
                format.setEncoding("UTF-8");
                XMLWriter writer = new XMLWriter( out, format );
                writer.write(root);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static<T> Element convertListToXml(List<T> items, Element element, Class<T> clz){
        try{
            Element root = element;
            Field[] fields = clz.getDeclaredFields();

            Element parent;
            for (T t : items) {
                parent = root.addElement(clz.getSimpleName());
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(Attribute.class)){
                        parent.addAttribute(field.getName(),field.get(t).toString());
                    }else {

                        if (field.getType().isAssignableFrom(List.class)){
                            if (field.getGenericType() instanceof ParameterizedType){
                                ParameterizedType pt = (ParameterizedType) field.getGenericType();
                                Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0];
                                convertListToXml((List) field.get(t), parent, genericClazz);
                            }

                        }else {
                            Element child = parent.addElement(field.getName());
                            String value = field.get(t) == null ? "  " : field.get(t).toString();
                            child.addText(value);
                        }
                    }
                }

            }
            return root;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
