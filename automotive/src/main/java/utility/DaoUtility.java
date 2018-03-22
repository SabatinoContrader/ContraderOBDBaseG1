package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.automotive.dto.NoleggioDTO;
import com.project.dao.CarDAO;
import com.project.dao.ConnessioneDB;
import com.project.model.Auto;
import com.project.model.Azienda;
import com.project.model.Utente;
import com.project.model.Dispositivo;

public class DaoUtility {

	public static List<Azienda> getListaOfficine() {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        List<Azienda> lista = new ArrayList<>();


        String QUERY = "select * from azienda";


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nLista Officine");
            }


            while (resultSet.next()) {

                System.out.println("Trovate Aziende!");

                Azienda a = new Azienda(resultSet.getString("Denominazione"), resultSet.getString("NomeReferente"), resultSet.getString("CognomeReferente"), resultSet.getString("Email"),
                        resultSet.getString("Telefono"), resultSet.getString("Latitudine"),
                        resultSet.getString("Longitudine"), resultSet.getString("Tipologia"), resultSet.getDate("DataInserimento"), resultSet.getString("Citta"), null);

                a.id = resultSet.getInt("ID");
                
                lista.add(a);

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Lista Officine!");
        }

    return lista;
    }
	
	
	public static List<Utente> getListaUtenti() {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        List<Utente> lista = new ArrayList<>();


        String QUERY = "select * from utente";


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nLista Utenti");
            }


            while (resultSet.next()) {

                System.out.println("Trovati Utenti!");

                Utente u = new Utente(resultSet.getInt("ID"), resultSet.getString("Nome"), resultSet.getString("Cognome"), resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("Stato"), resultSet.getInt("IdAzienda"), resultSet.getDate("DataRegistrazione"), resultSet.getInt("Ruolo"), resultSet.getString("Telefono"), null);
                
                lista.add(u);

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Lista Utenti!");
        }

    return lista;
    }
	
	
	public static Azienda getDatiAzienda(Utente u) {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        Azienda a;


        String QUERY = "select * from azienda where ID = "+ u.getIdAzienda();


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nAzienda");
            }


            while (resultSet.next()) {

                System.out.println("Azienda....!");

                a = new Azienda(resultSet.getString("Denominazione"), resultSet.getString("NomeReferente"), resultSet.getString("CognomeReferente"), resultSet.getString("Email"),
                        resultSet.getString("Telefono"), resultSet.getString("Latitudine"),
                        resultSet.getString("Longitudine"), resultSet.getString("Tipologia"), resultSet.getDate("DataInserimento"), resultSet.getString("Citta"), null);

                a.id = resultSet.getInt("ID");
                
                return a;

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Azienda!");
        }

    return null;
    }
	
	
	public static List<Azienda> getListaClientiBusiness(int IdAzienda) {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        List<Azienda> lista = new ArrayList<>();


        String QUERY = "select distinct(IdAziendaPrivata), Denominazione, NomeReferente, CognomeReferente, Email, Citta, DataInserimento, Telefono from auto_aziendali aa inner join dispositivo d on aa.IdAuto = d.IdAuto inner join azienda_privata ap on ap.ID = aa.IdAziendaPrivata where d.IdAzienda = "+IdAzienda;


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nLista Clienti Business dell'Azienda");
            }


            while (resultSet.next()) {

                System.out.println("Trovati Clienti!");

                Azienda a = new Azienda(resultSet.getString("Denominazione"), resultSet.getString("NomeReferente"), resultSet.getString("CognomeReferente"), resultSet.getString("Email"), resultSet.getString("Telefono"), null, null, null, resultSet.getDate("DataInserimento"), resultSet.getString("Citta"), null);
                a.id = IdAzienda;
                
                lista.add(a);

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Lista Clienti Business!");
        }

    return lista;
    }
	
	public static List<Utente> getListaClientiAzienda(int IdAzienda) {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        List<Utente> lista = new ArrayList<>();


        String QUERY = "select distinct(IdUtente), Nome, Cognome, Email, Password, DataRegistrazione, Ruolo, IdAziendaPrivata, Stato, Telefono from auto_utente au inner join dispositivo d on au.IdAuto = d.IdAuto inner join utente u on u.ID = au.IdUtente where d.IdAzienda = "+IdAzienda;


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nLista Clienti dell'Azienda");
            }


            while (resultSet.next()) {

                System.out.println("Trovati Clienti!");

                Utente u = new Utente(resultSet.getInt("IdUtente"), resultSet.getString("Nome"), resultSet.getString("Cognome"), resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("Stato"), IdAzienda, resultSet.getDate("DataRegistrazione"), resultSet.getInt("Ruolo"), resultSet.getString("Telefono"), null);
                
                lista.add(u);

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Lista Clienti!");
        }

    return lista;
    }
	
	
	public static NoleggioDTO noleggioAutoClientePrivato(int IdAuto) {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        
        NoleggioDTO noleggio = new NoleggioDTO();


        String QUERY = "select * from auto_utente where IdAuto = "+IdAuto;


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nLista Noleggi");
            }


            while (resultSet.next()) {

                System.out.println("Trovato Utente Privato!");

                noleggio.idAuto = IdAuto;
                noleggio.idUtente = resultSet.getInt("IdUtente");
                noleggio.KmMaxNoleggio = resultSet.getInt("MaxKmNoleggio");
                
                return noleggio;

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Noleggio!");
        }

    return null;
    }
	


	public static NoleggioDTO noleggioAutoClienteBusiness(int IdAuto) {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        
        NoleggioDTO noleggio = new NoleggioDTO();


        String QUERY = "select * from auto_aziendali where IdAuto = "+IdAuto;


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nLista Noleggi");
            }


            while (resultSet.next()) {

                System.out.println("Trovato Utente Privato!");

                noleggio.idAuto = IdAuto;
                noleggio.idUtente = resultSet.getInt("IdUtente");
                noleggio.KmMaxNoleggio = resultSet.getInt("MaxKmNoleggio");
                noleggio.idAziendaPrivata = resultSet.getInt("IdAziendaPrivata");
                
                return noleggio;

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Noleggio!");
        }

    return null;
    }

	

	public static Azienda getDatiAziendaPrivata(int idAziendaPrivata) {
		

        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        Azienda a;


        String QUERY = "select * from azienda_privata where ID = "+ idAziendaPrivata;


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nAzienda Privata");
            }


            while (resultSet.next()) {

                System.out.println("Azienda Privata....!");

                a = new Azienda(resultSet.getString("Denominazione"), resultSet.getString("NomeReferente"), resultSet.getString("CognomeReferente"), resultSet.getString("Email"),
                        resultSet.getString("Telefono"), null,
                        null, null, resultSet.getDate("DataInserimento"), resultSet.getString("Citta"), null);

                a.id = resultSet.getInt("ID");
                
                return a;

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Azienda Privata!");
        }

    return null;
		
		
		
		

		
	}

	
	public static List<Auto> getAutoAziendaPrivata(int idAziendaPrivata){
		

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<Auto> lista = new ArrayList<>();

		String QUERY = "select * from auto_aziendali aa inner join auto a on aa.IdAuto = a.ID where aa.IdAziendaPrivata = "+ idAziendaPrivata;


		try {
			resultSet = null;
			statement = conn.prepareStatement(QUERY);
			resultSet = statement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				System.out.println("\nAuto dell'azienda privata");
			}


			while (resultSet.next()) {

				//System.out.println("Trovate Auto Associate!");

				Auto a = new Auto(resultSet.getInt("ID"), resultSet.getString("Marca"), resultSet.getString("Modello"), resultSet.getString("Targa"),
						resultSet.getString("NumeroTelaio"), resultSet.getInt("KmAttuali"),
						resultSet.getInt("KmInizioNoleggio"), resultSet.getDate("ScadenzaRevisione"),
						resultSet.getDate("ScadenzaTagliando"), resultSet.getDate("ScadenzaAssicurazione"),
						resultSet.getDate("ScadenzaBollo"), resultSet.getString("TipologiaAuto"), resultSet.getInt("DaNoleggio"));

				lista.add(a);

			}


		} catch (SQLException e) {
			System.out.println("Errore di Recupero Lista Auto Azienda Privata!");
		}

		return lista;
		
		
	}
	
	
}
