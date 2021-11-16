import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

/**
 * 课堂练习:
 * 01.使用dom4j的api生成以下xml文件
     <Students>
        <Student id="1">
            <name>张三</name>
            <gender>男</gender>
            <grade>计算机1班</grade>
            <address>广州天河</address>
        </Student>
        <Student id="2">
            <name>李四</name>
            <gender>女</gender>
            <grade>计算机2班</grade>
            <address>广州越秀</address>
        </Student>
     </Students>
 * 02.修改id为2的学生的姓名, 改为"王丽"
 * 03.删除id为2的学生
 */
public class Demo4 {
    public static void main(String[] args) throws Exception {
        test03();
    }

    /**
     * 01.生成指定xml文档
     */
    public static void test01() throws Exception{
        // 1.内存创建xml文档
        Document doc = DocumentHelper.createDocument();
        // 2.写入内容
        Element rootElem = doc.addElement("Students");
        // 2.1.增加标签
        Element studentElem01 = rootElem.addElement("Student");
        // 2.2.增加属性
        studentElem01.addAttribute("id","1");
        // 2.3.增加标签,同时设置文本
        studentElem01.addElement("name").setText("张三");
        studentElem01.addElement("gender").setText("男");
        studentElem01.addElement("grade").setText("计算机1班");
        studentElem01.addElement("address").setText("广州天河");

        // 2.1.增加标签
        Element studentElem02 = rootElem.addElement("Student");
        // 2.2.增加属性
        studentElem02.addAttribute("id","2");
        // 2.3.增加标签,同时设置文本
        studentElem02.addElement("name").setText("李四");
        studentElem02.addElement("gender").setText("女");
        studentElem02.addElement("grade").setText("计算机2班");
        studentElem02.addElement("address").setText("广州越秀");

        // 3.内容写出到xml文件
        // 3.1.指定输出位置
        FileOutputStream fos = new FileOutputStream("E:/Desktop/students.xml");
        // 3.2.指定输出格式
        OutputFormat of = OutputFormat.createPrettyPrint();
        // 设置编码
        of.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(fos, of);
        // 3.3.写出内容
        writer.write(doc);
        // 3.4.关闭资源
        writer.close();
    }

    /**
     * 02.修改id为2的学生的姓名, 改为"王丽"
     */
    private static void test02() throws Exception {
        // 1.查询到id位2的学生
        Document doc = new SAXReader().read(new File("E:/Desktop/students.xml"));
        // 1.1.找到所有的student标签
        Iterator<Element> it = doc.getRootElement().elementIterator("Student");
        while (it.hasNext()) {
            Element elem = it.next();
            // 1.2.查询到id为2的学生标签
            if ("2".equals(elem.attributeValue("id"))) {
                elem.element("name").setText("王丽");
                break;
            }
        }
        //3.1 输出位置
        FileOutputStream out = new FileOutputStream("E:/Desktop/students.xml");
        //3.2 指定格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out,format);
        //3.3 写出内容
        writer.write(doc);
        //3.4关闭资源
        writer.close();
    }

    /**
     * 03.删除id为2的学生
     */
    private static void test03() throws Exception{
        // 1.查询到id位2的学生
        Document doc = new SAXReader().read(new File("E:/Desktop/students.xml"));
        // 1.1.找到所有的student标签
        Iterator<Element> it = doc.getRootElement().elementIterator("Student");
        while (it.hasNext()) {
            Element elem = it.next();
            // 1.2.查询到id为2的学生标签
            if ("2".equals(elem.attributeValue("id"))) {
                elem.detach();
                break;
            }
        }
        //3.1 输出位置
        FileOutputStream out = new FileOutputStream("E:/Desktop/students.xml");
        //3.2 指定格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out,format);
        //3.3 写出内容
        writer.write(doc);
        //3.4关闭资源
        writer.close();
    }
}