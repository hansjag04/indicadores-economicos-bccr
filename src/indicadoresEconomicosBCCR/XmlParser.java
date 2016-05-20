package indicadoresEconomicosBCCR;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

/**
 * <code>XmlParser</code> realiza parseado de un documento <code>XML</code>.
 * @author Hans Araya
 * @version 1.0
 */
public class XmlParser {
  
  private String xml;
  private Element rootElement;
  
  /**
   * Constructor del <code>XmlParser</code> encargado de definir las herramientas para parseo de XML
   * @param data Documento XML
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   */
  public XmlParser(String data) throws SAXException, IOException, ParserConfigurationException{
    //Reemplaza caracteres especiales
    data =  replaceChars(data);
    this.xml = data;
    
    //Creador de Builder/Parser XML
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new InputSource(new StringReader(this.xml)));
    this.rootElement = document.getDocumentElement();
  }
  
  /**
   * Obtiene el valor de una etiqueta en un documento XML
   * @param tag La etiqueta del cual extraer el valor
   * @return <code>String</code> con el valor de la etiqueta enviada por parámetro
   */
  public String getValue(String tag){
    try {
      NodeList list = this.rootElement.getElementsByTagName(tag);
      if (list != null && list.getLength() > 0) {
          NodeList subList = list.item(0).getChildNodes();

          if (subList != null && subList.getLength() > 0) {
              return subList.item(0).getNodeValue();
          }
      }
      
    } catch (Exception e) {
      return "0";
    }
    return "0";
  }
  
  private String replaceChars(String string){
    string = string.replace("&lt;", "<");
    string = string.replace("&gt;", ">");
    return string;
  }
}
