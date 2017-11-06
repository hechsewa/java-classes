package login;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

public class LoginProgram {
    public static void main(String[] argv){
      /*Login log = */new Login ("ala", "makota");
	  try{
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(rd);

        // TODO: prosba o wpisanie hasła i loginu
		System.out.println("enter login: ");
		String login = bfr.readLine();
		System.out.println("enter haslo: ");
        String haslo = bfr.readLine();

        /*TODO: sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */
        if(Login.check(login, haslo))
        	System.out.println("OK");
        else throw new IOException("incorrect login or password");

	  }catch(IOException e){e.printStackTrace();}

    }
}
