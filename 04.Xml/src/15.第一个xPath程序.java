import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 第一个xPath程序
 *
 * 需求: 删除id为2的学生
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        Document doc = new SAXReader().read(new File("E:/Desktop/students.xml"));
        // 查询id为2的学生标签
        Element stuElem = (Element) doc.selectSingleNode("//Student[@id='2']");
        // 删除标签
        stuElem.detach();
        // 写出xml文件
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