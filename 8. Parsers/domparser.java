import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import org.w3c.dom.*;
import java.util.*;

public class domparser{
    
    public static void main(String args[]){
        int ch=0;
        while(ch!=5){
            System.out.println("1.insert \n2.delete \n3. update \n4.display \n5.exit");
            System.out.println("\nEnter your choice\n");
            Scanner sc= new Scanner(System.in);
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    insert();
                    break;
                case 2:
                    dlete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.exit(0);

            }
        }
        
    }

    static void display(){
        try{
            DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document d= db.parse("book.xml");
            d.getDocumentElement().normalize();
            
            System.out.println("Root element :" +d.getDocumentElement().getNodeName());
            NodeList list= d.getElementsByTagName("book");

            for( int i=0; i<list.getLength();i++){
                Node n= list.item(i);

                System.out.println("sub element :"+n.getNodeName());

                if(n.getNodeType()==Node.ELEMENT_NODE && n!=null){
                    Element ele=(Element) n;
                    if(ele.getAttribute("id")!=null){
                        System.out.println("book id :"+ele.getAttribute("id"));
                    }
                    if(ele.getElementsByTagName("title").item(0)!=null){
                        System.out.println(ele.getElementsByTagName("title").item(0).getTextContent());
                    }
                    if(ele.getElementsByTagName("author").item(0)!=null){
                        System.out.println(ele.getElementsByTagName("author").item(0).getTextContent());
                    }
                    
                    if(ele.getElementsByTagName("price").item(0)!=null){
                        System.out.println(ele.getElementsByTagName("price").item(0).getTextContent());
                    }
                }
                System.out.println("\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    static void insert(){
        try{
            File file=new File("book.xml");
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document d= db.parse(file);
            d.getDocumentElement().normalize();

            Scanner sc=new Scanner(System.in);
       
          System.out.println("Enter the book id ");
            int id=sc.nextInt();
            
            System.out.println("Enter the node name ");
            String price=sc.next();
            System.out.println("Enter the value ");
            String rs=sc.next();

            Node book=d.getElementsByTagName("book").item(id-1);
            Element ele= d.createElement(price);
            ele.appendChild(d.createTextNode(rs));
            book.appendChild(ele);

           TransformerFactory tf=TransformerFactory.newInstance();
           Transformer t= tf.newTransformer();
           DOMSource src=new DOMSource(d);
           StreamResult result= new StreamResult(new File("book.xml"));
           t.transform(src, result);
           System.out.println("\ninserted\n");


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    static void dlete(){
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db= dbf.newDocumentBuilder();
            Document d=db.parse("book.xml");
                
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the id of the book ");
            int id=sc.nextInt();
            System.out.println("Enter the node name to be deleted ");
            String name=sc.next();
            
            Node book=d.getElementsByTagName("book").item(id-1);

            NodeList list=book.getChildNodes();
            for(int v=0;v<list.getLength();v++){
                
                    Node node=list.item(v);
                    if(name.equals(node.getNodeName())){
                        book.removeChild(node);
                    }
                
            }

            TransformerFactory tf= TransformerFactory.newInstance();
            Transformer t= tf.newTransformer();
            DOMSource src=new DOMSource(d);
            StreamResult result=new StreamResult(new File("book.xml"));
            t.transform(src, result);
            System.out.println("\ndeleted\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    static void update(){
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document d=db.parse(new File("book.xml"));
            d.getDocumentElement().normalize();

            Scanner sc=new Scanner(System.in);

            System.out.println("Enter the book id to modify ");
            int id=sc.nextInt();
            System.out.println("Enter the node name to modify ");
            String name=sc.next();
            System.out.println("Enter the value for the node ");
            String neu=sc.next();

            Node book=d.getElementsByTagName("book").item(id-1);
            NodeList list=book.getChildNodes();
            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                if(name.equals(node.getNodeName())){
                    node.setTextContent(neu);
                }
            }

            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer t= tf.newTransformer();
            DOMSource src=new DOMSource(d);
            StreamResult result= new StreamResult(new File("book.xml"));
            t.transform(src,result);

            System.out.println("\nupdated\n");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    


}