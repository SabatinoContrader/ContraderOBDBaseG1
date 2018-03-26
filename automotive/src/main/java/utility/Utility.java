package utility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class Utility {

	public static String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /*
	public static void closeConnection(ResultSet rs, PreparedStatement ps,Connection dataConnection, boolean closeConnection) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e1) {
				System.out.println("Exception in close ResultSet" +e1.getMessage());
			}
		}
		if (ps!=null) {
			try {
				ps.close();
			} catch (SQLException e1) {
				System.out.println("Exception in close PreparedStatement"+e1.getMessage());
			}
		}
		if (closeConnection) {
			if (dataConnection != null) {
				try {
					dataConnection.close();
				} catch (SQLException e) {
					System.out.println("Exception in close connection"+e.getMessage());
				}
			}
		}
	}
*/
	public final static void clearConsole()
	{
		System.out.println(new String(new char[50]).replace("\0", "\r\n"));
	}
	
	public static int getGiorniScadenzaGenerica(Date scadenza){
        DateTime oggi = new DateTime(System.currentTimeMillis());
        DateTime scadenzaGenerica = new DateTime(scadenza);
		return Days.daysBetween(oggi, scadenzaGenerica).getDays();
	}
}
