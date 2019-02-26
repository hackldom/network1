package com.company;
import java.net.*;
import java.io.*;

public class Main {
    private InetAddress inet = null;

    public void resolve(String host) {
        try {
            // Try to create an instance of InetAddress using the factory method (public static).
            // If fails, may throw an instance of UnknownHostException.
            inet = InetAddress.getByName( host );

            // Use two getter methods to print the results. Can also just print the object itself (which combines both).
            getHostInfo();
        }
        catch( UnknownHostException e ){ 		// If an exception was thrown, echo to stdout.
            e.printStackTrace();
        }
    }

    private void getHostInfo() {
        System.out.println( "Host name : " + inet.getHostName   () );
        System.out.println( "IP Address: " + inet.getHostAddress() );
        System.out.println("The hash code is " + inet.hashCode());
        System.out.println("The canonical hostname is " + inet.getCanonicalHostName());
    }

    public static void main( String[] args ) {
        Main lookup = new Main();
        lookup.resolve( args[0] );				// The first command line argument is args[0].
    }
}


