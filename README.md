# API Indicadores Económicos (Tipo de Cambio) BCCR
### Web Service · Java · Tipo de Cambio · BCCR

Es un API desarrollado en **Java** para obtener los indicadores económicos del BCCR utilizando el [Web Service][bccr-ws] de la misma entidad.

Fue desarrollado para un proyecto de la universidad, por lo que sólo está disponible la obtención del tipo de cambio (en dólares USD) tanto en compra como en venta, pero sencillo de modificar para implementar los demás indicadores economómicos.

El pequeño programa solicita el XML al Web Service del BCCR mediante una solicitud HTTP GET para posteriormente parsear el documento y obtener el respectivo valor.

### Uso del API

Pueden utilizar el código fuente o también el **.jar** ya listo en **Release/IndicadoresEconomicosBCCR.jar**. Su uso es bastante sencillo:


```sh
import indicadoresEconomicosBCCR.TipoCambio;

public class App{
    public static void main(String[] args) {
        //Crea el servicio del API
        TipoCambio servicioTipoCambio = new TipoCambio();
        
        //Obtiene el valor del precio de compra USD
        servicioTipoCambio.getCompra();
        
        //Obtiene el valor del precio de venta USD
        servicioTipoCambio.getVenta();
  }
}
```

### Version
1.0.0

License
----

Creative Commons


**¡Viva Costa Rica, Viva Saprissa!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [bccr-ws]: http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsindicadoreseconomicos.asmx?op=ObtenerIndicadoresEconomicosXML>

