import org.omg.CORBA.TIMEOUT;

import java.net.*;
import java.io.*;
import java.util.Arrays;


/**
 * This class is used to provide information about multiple hostnames using the <code>InetAddress</code> library.
 * @author Dominik Hackl
 */
public class InternetData {

        private InetAddress inet = null;
        private TIMEOUT appTimeOut;
        private int timeout;
        private String[] ipsplits;
        private String ipaddress;

        public void resolve(String host) {
            try {

                inet = InetAddress.getByName( host );


                getHostInfo();
            }
            catch( UnknownHostException e ){ 		// If an exception was thrown, echo to stdout.
                e.printStackTrace();
            }
        }

        /**
         * This method provides all of the information regarding what information is being output such as:
         * <ul>
         *     <li>The Host Name</li>
         *     <li>The Host Address</li>
         *     <li>The Canonical Host Name</li>
         *     <li>Whether it is reachable</li>
         *     <li>Whether it is an <code>IPv4</code> or <code>IPv6</code> address</li>
         *
         * </ul>
         */

        private void splitIP(){
            ipaddress = inet.getHostAddress();
            System.out.println(Arrays.toString(ipaddress.split("\\.")));
        }
        private void getHostInfo() {
                System.out.println("***********************************************" + inet.getHostName() + "***********************************************");
                System.out.println( "The IP Address of the host is: " + inet.getHostAddress() );
                System.out.println("The canonical hostname is: " + inet.getCanonicalHostName());
                System.out.println("The hash code is " + inet.hashCode());
                if (inet instanceof Inet6Address){
                    System.out.println("This is an IPv6 address");
                }
                if (inet instanceof Inet4Address){
                    System.out.println("This is an IPv4 address");
            }

                System.out.println("The host is reachable:" + isReachable(500));
                splitIP();
            }

        /**
         *
         * @param timeout It is the time in miliseconds before the application throws a runtime error and quits. It is used to make sure it doesn't stay open forever
         * @return normally false
         */
            private boolean isReachable(int timeout){
                return false;

            }
/*
            private String whichIPV(){
                if (inet instanceof Inet6Address)
            }
*/

        public static void main( String[] args ) {
            InternetData lookup = new InternetData();
            for (int i = 0; i < args.length; i++) {
                lookup.resolve(args[i]);
            }// The first command line argument is args[0].
        }
    }




