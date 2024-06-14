
package wsCalculadora;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.6.1
 * 2023-12-10T14:47:11.885+01:00
 * Generated source version: 3.6.1
 *
 */
public final class OperacionesCalculadora_OperacionesCalculadoraPort_Client {

    private static final QName SERVICE_NAME = new QName("http://calculadora/", "OperacionesCalculadoraService");

    private OperacionesCalculadora_OperacionesCalculadoraPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = OperacionesCalculadoraService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        OperacionesCalculadoraService ss = new OperacionesCalculadoraService(wsdlURL, SERVICE_NAME);
        OperacionesCalculadora port = ss.getOperacionesCalculadoraPort();

        {
        System.out.println("Invoking implementarRestar...");
        double _implementarRestar_arg0 = 0.03642584828938511;
        double _implementarRestar_arg1 = 0.5053973245052813;
        double _implementarRestar__return = port.implementarRestar(_implementarRestar_arg0, _implementarRestar_arg1);
        System.out.println("implementarRestar.result=" + _implementarRestar__return);


        }
        {
        System.out.println("Invoking implementarMultiplicar...");
        double _implementarMultiplicar_arg0 = 0.8635217669905524;
        double _implementarMultiplicar_arg1 = 0.8968805911439015;
        double _implementarMultiplicar__return = port.implementarMultiplicar(_implementarMultiplicar_arg0, _implementarMultiplicar_arg1);
        System.out.println("implementarMultiplicar.result=" + _implementarMultiplicar__return);


        }
        {
        System.out.println("Invoking operar...");
        int _operar_arg0 = -1115737870;
        double _operar_arg1 = 0.6126417454780925;
        try {
            double _operar__return = port.operar(_operar_arg0, _operar_arg1);
            System.out.println("operar.result=" + _operar__return);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking getOperaciones...");
        int _getOperaciones_arg0 = -233616204;
        java.util.List<java.lang.String> _getOperaciones__return = port.getOperaciones(_getOperaciones_arg0);
        System.out.println("getOperaciones.result=" + _getOperaciones__return);


        }
        {
        System.out.println("Invoking implementarDividir...");
        double _implementarDividir_arg0 = 0.16959088173829695;
        double _implementarDividir_arg1 = 0.11587594999029627;
        try {
            double _implementarDividir__return = port.implementarDividir(_implementarDividir_arg0, _implementarDividir_arg1);
            System.out.println("implementarDividir.result=" + _implementarDividir__return);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking implementacionMA...");
        port.implementacionMA();


        }
        {
        System.out.println("Invoking implementacionMO...");
        double _implementacionMO__return = port.implementacionMO();
        System.out.println("implementacionMO.result=" + _implementacionMO__return);


        }
        {
        System.out.println("Invoking implementacionML...");
        port.implementacionML();


        }
        {
        System.out.println("Invoking implementarSumar...");
        double _implementarSumar_arg0 = 0.33536084591339654;
        double _implementarSumar_arg1 = 0.4046239622908111;
        double _implementarSumar__return = port.implementarSumar(_implementarSumar_arg0, _implementarSumar_arg1);
        System.out.println("implementarSumar.result=" + _implementarSumar__return);


        }
        {
        System.out.println("Invoking implementacionUR...");
        double _implementacionUR__return = port.implementacionUR();
        System.out.println("implementacionUR.result=" + _implementacionUR__return);


        }

        System.exit(0);
    }

}
