//etimport org.omg.CORBA.TIMEOUT;

import java.net.*;
import java.io.*;
import java.util.*;


/**
 * This class is used to provide information about multiple hostnames using the <code>InetAddress</code> library.
 * @author Dominik Hackl
 */
public class InternetData {

        private InetAddress inet = null;
        //private TIMEOUT appTimeOut;
        private static ArrayList<InetAddress> addresses = new ArrayList<InetAddress>();
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
            //ArrayList<String> inputs = new ArrayList<String>();
            
            ipaddress = inet.getHostAddress();
            String[] printSplit = ipaddress.split("\\.");
            //String printSplit = Arrays.toString(ipaddress.split("\\."));
            //System.out.println(printSplit[0]);
            for(int i = 0; i < 4; i++){
                 System.out.println(printSplit[i]);
            }
           
            //System.out.println(printSplit.length());
           //inputs.add(printSplit);
           //System.out.println(inputs.get(0));
            //firstInput.add
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
                /*if (multipleParameters == true){
                    splitIP();
                }*/
                System.out.println("The host is reachable: " + isReachable());
                //splitIP();
            }

        /**
         *
         * @param timeout It is the time in miliseconds before the application throws a runtime error and quits. It is used to make sure it doesn't stay open forever
         * @return normally false
         */
            private boolean isReachable(){
                try{
               return inet.isReachable(500);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                return true;
            }

        public static void main( String[] args ) {
            InternetData lookup = new InternetData();
            
            if (args.length > 1){
                System.out.println("Multiple arguments");
            
            }
            else if(args.length == 0){
                System.out.println("Please rerun the program with an argument");
            }

            else{
                System.out.println("Single argument");
            }
            for (int i = 0; i < args.length; i++) {
                lookup.resolve(args[i]);
                try{
                InetAddress aAddress = InetAddress.getByName(args[i]);
                addresses.add(aAddress);

                String allAddresses = addresses.get(i).getHostAddress();
                String[] printSplit = allAddresses.split("\\.");
                System.out.println("address: " + aAddress.getHostAddress());

                //for(int x = 0; x < 4; x++) {
                    /*if(Integer.parseInt(printSplit[i]) >= Integer.parseInt(printSplit [i+1])){
                        System.out.println(printSplit[x]);*/

                if(Integer.parseInt(printSplit[i]) == Integer.parseInt(printSplit[i + 1])){
                    printSplit[i] = printSplit[i].replace('2', '*');
                    System.out.println(printSplit[i]);
                }
                    System.out.println(printSplit[0]);
                    System.out.println(printSplit[1]);
                    System.out.println(printSplit[2]);
                    System.out.println(printSplit[3]);


                    
                }
                //System.out.println(aAddress);
                
                catch(UnknownHostException e){
                    System.out.println("Hostname not found");
                }

                //inputs.add(printSplit[i]);
            }

              
            
        }
    }





