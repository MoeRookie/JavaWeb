import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 把xml文档信息封装到对象中
 */
public class Demo4 {
    public static void main(String[] args) throws Exception {
        List<Contact> contacts = new LinkedList<>();
        // 实例化reader并读取为document
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("./src/contact.xml"));
        // 读取contact标签
        Iterator<Element> it = document.getRootElement().elementIterator("contact");
        while (it.hasNext()) {
            Element elem = it.next();
            Contact contact = new Contact(); // 实例化contact对象
            contact.setId(elem.attributeValue("id"));
            contact.setName(elem.elementText("name"));
            contact.setAge(elem.elementText("age"));
            contact.setPhone(elem.elementText("phone"));
            contact.setEmail(elem.elementText("email"));
            contact.setQq(elem.elementText("qq"));
            contacts.add(contact); // 添加到contacts中
        }
        System.out.println(contacts);
    }
}
