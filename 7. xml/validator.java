import java.io.*;
import java.util.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import javax.xml.parsers.*;
import org.xml.sax.*;

public class validator{
    public static void main(String[] args){
        if(args.length!=2){
            System.out.println("requires xsd and xml file");

        }
        else{
            boolean isvalid=validateXml(args[0],args[1]);
            if(isvalid){
                System.out.println(args[1]+"is valid against "+args[0]);
            }
            else{
                System.out.println(args[1]+"is not valid against "+args[0]);
            }
        }
    }

    public static boolean validateXml(String xsd, String xml){
        try{
            SchemaFactory factory= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema=factory.newSchema(new File(xsd));
            Validator validtor= schema.newValidator();
            validtor.validate(new StreamSource(new File(xml)));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}

