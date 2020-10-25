package com.atguigu.dom4j;

import com.atguigu.pojo.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest1 {
    @Test
    public void getBook() throws DocumentException {
//        第一步： 先加载xml文件创建Document对象
        SAXReader reader = new SAXReader();
        Document documents = reader.read("xml/books1.xml");
        //System.out.println(books);
//        第二步：通过Document对象拿到根元素对象
        Element rootElement = documents.getRootElement();
//        第三步：通过根元素.elelemts(标签名); 可以返回一个集合，这个集合里放着。所有你指定的标签名的元素对象
        List<Element> elements = rootElement.elements();
//        第四步：找到你想要修改、删除的子元素，进行相应的操作
        for (Element book : elements) {
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");

            System.out.println(new Book(sn,name,new BigDecimal(price),author));
        }
    }
}
