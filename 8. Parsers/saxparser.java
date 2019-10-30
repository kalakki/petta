import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class saxparser{
    public static void main(String args[]){
        if(args.length!=1){
            System.err.println("Enter the xml file name");
            System.exit(0);
        }

        try{
            SAXParserFactory spf=SAXParserFactory.newInstance();
            SAXParser sp= spf.newSAXParser();

            DefaultHandler handler =new DefaultHandler(){
                boolean title=false,author=false;
                public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException{
                    if(qName.equalsIgnoreCase("title")){
                        title=true;
                    }
                    if(qName.equalsIgnoreCase("author")){
                        author=true;
                    }
                }

                public void characters(char ch[],int start,  int length) throws SAXException{
                    if(title){
                        System.out.println(new String(ch ,start,length));
                        title=false;
                    }
                    if(author){
                        System.out.println(new String(ch,start,length));
                        author=false;
                    }
                }
            };
            sp.parse(args[0],handler);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}