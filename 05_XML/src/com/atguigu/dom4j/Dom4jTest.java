package com.atguigu.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.atguigu.pojo.Book;
import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
    public void getElement() throws DocumentException {
        //第一步，通过创建SAXReader对象。来读取xml文件，获取Document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        //第二步，通过Document对象。拿到XML的根元素对象
        Element rootElement = document.getRootElement();
        //第三步，通过根元素对象。获取所有的book 标签对象
        List<Element> books = rootElement.elements();
        //第四步，遍历每个book标签对象。然后获取到book标签对象内的每一个元素，再通过getText() 方法拿到起始标签和结束标签之间的文本内容
        for (Element book: books) {
            //获取book标签内的每一个元素
            Element nameElement = book.element("name");
            Element authorElement = book.element("author");
            Element priceElement = book.element("price");

            //通过getText() 方法拿到起始标签和结束标签之间的文本内容
           /* System.out.println("书名：" + nameElement.getText() + "，作者：" +
                    authorElement.getText() + "，价格：" + priceElement.getText());*/
           String name = nameElement.getText();
           String author = authorElement.getText();
           String price = priceElement.getText();
           String sn = book.attributeValue("sn");

           System.out.println(new Book(sn,name,new BigDecimal (price),author));
        }

    }
}
