package com.java.cypher;

import java.util.Scanner;

import java.math.BigInteger;

import java.security.MessageDigest;

/**
* Engineered and developed by Jhonny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 1.8.0_31, Standard Edition.
* Development Environment: VIM 7.3
* Date: 01/08/2016, Time: 23:12:31.
* 
* Additional Info.
*
* Source Code Target Or Details:
*
*               [ MD5, SHA-1 and SHA-256 Encryption Methods ]
*
* Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal not for commercial purposes.
* Developer Contact: jtrejosb@live.com || jtrejosb@gmail.com || jtrejosb@icloud.com
* Mobile: --
*/

public class Cypher {
  public static void main( String[] args ) {
    System.out.print( "Type in some info: " );
    String info = new Scanner( System.in ).nextLine();

    System.out.println( "MD5: " + new Cypher().hashData( info, "MD5" ) );
    System.out.println( "SHA-1: " + new Cypher().hashData( info, "SHA-1" ) );
    System.out.println( "SHA-256: " + new Cypher().hashData( info, "SHA-256" ) );
  }

  public String hashData( String data, String cypherMethod ) {
    String hashText = "";

    try {
      MessageDigest MD = MessageDigest.getInstance( cypherMethod );
      byte[] bytes = MD.digest( data.getBytes() );
      BigInteger number = new BigInteger( 1, bytes );
      hashText = number.toString( 16 );

      while( hashText.length() < 32 ) {
        hashText = "0" + hashText;
      }
    } catch( Exception e ) {
      e.printStackTrace();
    }

    return hashText;
  }
}
