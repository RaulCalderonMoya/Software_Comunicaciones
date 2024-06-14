
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package wsCalculadora;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.6.1
 * 2023-12-10T14:47:11.970+01:00
 * Generated source version: 3.6.1
 *
 */

@javax.jws.WebService(
                      serviceName = "OperacionesCalculadoraService",
                      portName = "OperacionesCalculadoraPort",
                      targetNamespace = "http://calculadora/",
                      wsdlLocation = "file:/C:/Users/Raúl_PC/Desktop/PrincipalWorkSpace/p3-servidor/src/main/webapp/wsdl/operacionescalculadora.wsdl",
                      endpointInterface = "wsCalculadora.OperacionesCalculadora")

public class OperacionesCalculadoraPortImpl implements OperacionesCalculadora {

    private static final Logger LOG = Logger.getLogger(OperacionesCalculadoraPortImpl.class.getName());

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#implementarRestar(double arg0, double arg1)*
     */
    public double implementarRestar(double arg0, double arg1) {
        LOG.info("Executing operation implementarRestar");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            double _return = 0.3288015707248019;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#implementarMultiplicar(double arg0, double arg1)*
     */
    public double implementarMultiplicar(double arg0, double arg1) {
        LOG.info("Executing operation implementarMultiplicar");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            double _return = 0.21420983104568558;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#operar(int arg0, double arg1)*
     */
    public double operar(int arg0, double arg1) throws Exception_Exception   {
        LOG.info("Executing operation operar");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            double _return = 0.58261479048942;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#getOperaciones(int arg0)*
     */
    public java.util.List<java.lang.String> getOperaciones(int arg0) {
        LOG.info("Executing operation getOperaciones");
        System.out.println(arg0);
        try {
            java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnVal1 = "_returnVal248480299";
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#implementarDividir(double arg0, double arg1)*
     */
    public double implementarDividir(double arg0, double arg1) throws Exception_Exception   {
        LOG.info("Executing operation implementarDividir");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            double _return = 0.4337075510374008;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#implementacionMA()*
     */
    public void implementacionMA() {
        LOG.info("Executing operation implementacionMA");
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#implementacionMO()*
     */
    public double implementacionMO() {
        LOG.info("Executing operation implementacionMO");
        try {
            double _return = 0.5351322481601746;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#implementacionML()*
     */
    public void implementacionML() {
        LOG.info("Executing operation implementacionML");
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#implementarSumar(double arg0, double arg1)*
     */
    public double implementarSumar(double arg0, double arg1) {
        LOG.info("Executing operation implementarSumar");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            double _return = 0.7312745855444095;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see wsCalculadora.OperacionesCalculadora#implementacionUR()*
     */
    public double implementacionUR() {
        LOG.info("Executing operation implementacionUR");
        try {
            double _return = 0.41881351683193613;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
