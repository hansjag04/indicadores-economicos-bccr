package indicadoresEconomicosBCCR;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <code>TipoCambio</code> es una clase que se comunica con el WebService del BCCR para obtener
 * el tipo de cambio en tiempo real. Se comunica mediante el protocolo <code>HTTP GET</code>.
 * Sólo funciona con la moneda <strong>USD</strong>.
 * @author Hans Araya
 * @version 1.0
 */
public class TipoCambio {

  private int indicador = 0; //317: Compra, 318: Venta
  private String tcFechaInicio;
  private String tcFechaFinal;
  private final String tcNombre = "TEC";
  private final String tnSubNiveles = "N";
  private final String HOST = "http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML";
  private String url;
  private final String VALUE_TAG = "NUM_VALOR";
  
  public TipoCambio(){
    setFecha();
  }
  
  /**
   * Devuelve el valor de <strong>COMPRA</strong> USD del BCCR
   * @return <code>Double</code> con el valor del precio de compra.
   */
  public double getCompra(){
    setCompra();
    
    double valor = Double.parseDouble(getValue());
    return valor;
  }
  
  /**
   * Devuelve el valor de <strong>VENTA</strong> USD del BCCR
   * @return <code>Double</code> con el valor del precio de venta.
   */
  public double getVenta(){
    setVenta();
    
    double valor = Double.parseDouble(getValue());
    return valor;
  }
  
  /**
   * Obtiene el XML del WebService del BCCR y parsea el documento para obtener el valor (dado por VALUE_TAG)
   * @return String
   */
  private String getValue(){
    try {
      setUrl(); //Set del Url con los Parámetros
      
      //Obtiene y Parsea el XML
      String data = GetMethod.getHTML(url);
      XmlParser xml = new XmlParser(data);
      
      //Retorna el valor del tag
      return xml.getValue(VALUE_TAG);
    } catch (Exception e) {
      System.out.println("Error al obtener el valor del BCCR.");
      return "0";
    }
  }
  
  private void setUrl(){
    String params = "tcIndicador="+indicador+"&tcFechaInicio="+tcFechaInicio+"&tcFechaFinal="+tcFechaFinal+"&tcNombre="+tcNombre+"&tnSubNiveles="+tnSubNiveles;
    this.url = HOST+"?"+params;
  }
  
  private void setFecha(){
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    this.tcFechaInicio = sdf.format(date);
    this.tcFechaFinal = tcFechaInicio;
  }
  
  private void setCompra(){
    this.indicador = 317;
  }
  
  private void setVenta(){
    this.indicador = 318;
  }
  
}
