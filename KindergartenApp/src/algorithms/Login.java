package algorithms;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;

public class Login {
	//source for encryption algorithm
	//https://subscription.packtpub.com/book/security/9781849697767/1/ch01lvl1sec09/creating-a-strong-hash-simple
	public String encrypt(String input)
	{
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(input.getBytes());
			byte byteData[] = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < byteData.length; i++)
			{
				sb.append(Integer.toString(
						(byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex)
		{
			Logger.getLogger("SHA-1").log(Level.SEVERE, null, ex);
			return null;
		}
	}
	public String id_gen()
	{
		String res = "";
		Random rand = new Random();
		for(int i = 0; i < 5; i++)
		{
			int rand_range = rand.nextInt(3);
			if(rand_range == 0) res += rand.nextInt(10);
			else if(rand_range == 1) res += (char) ((char) rand.nextInt(26)+65);
			else res += (char) ((char) rand.nextInt(26)+97);
		}
		return res;
	}
	//returns error message
	public String processPwd(String pwd)
	{
		if(pwd.length() > 7 && pwd.length() < 41)
		{
			boolean hasSymbol = false;
			boolean hasCapital = false;
			boolean hasLowerCase = false;
			boolean hasInt = false;
			for(int i = 0; i < pwd.length(); i++)
			{
				if(pwd.charAt(i) > 64 && pwd.charAt(i) < 91) hasCapital = true;
				else if(pwd.charAt(i) > 96 && pwd.charAt(i) < 123) hasLowerCase = true;
				else if(pwd.charAt(i) > 47 && pwd.charAt(i) < 58) hasInt = true;
				else hasSymbol = true;
			}
			String error = "The password must include the following: ";
			if(!hasCapital) error += "one capital, ";
			if(!hasLowerCase) error += ", one lowercase";
			if(!hasInt) error += ", one integer";
			if(!hasSymbol) error += ", and one symbol";
			if(!hasCapital || !hasLowerCase || !hasInt || !hasSymbol) return error;
			return "";
		}
		else
		{
			if(pwd.length() < 8) return "Password must be atleast 8 chars";
			return "Password must be shorter than 41 chars";
		}
	}
	
	public String processUsr(String usr)
	{
		if(usr.length() > 3 && usr.length() < 31)
		{
			int i = 0;
			while(i < usr.length())
			{
				if((usr.charAt(i) < 48 || usr.charAt(i) > 57) && (usr.charAt(i) < 65 || usr.charAt(i) > 90)
					&& (usr.charAt(i) < 97 || usr.charAt(i) > 122)) return "The username only allows symbols 0-9, A-Z, a-z";
				i++;
			}
			return "";
		}
		else
		{
			if(usr.length() < 4) return "Usernamme must be atleast 4 chars";
			return "Username must be less than 31 chars";
		}
	}
}
