package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.admin;
import Entity.categorie;
import Entity.client;
import Entity.commande;
import Entity.produit;

public class catalogue implements ICatalogue{

	@Override
	public void ajouterProduit(produit p) {
		Connection cx = singletonConnection.getConnection();
		
		try {
			PreparedStatement ps= cx.prepareStatement("insert into produit (nom,prix,quantite,categorie_id,image) values (?,?,?,?,?)");
			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setInt(4, p.getCategorie_id());
			ps.setString(5, p.getImage());
			ps.executeUpdate();
			//cx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<produit> getAllProduits() {
		Connection cx = singletonConnection.getConnection();
		List<produit> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from produit");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				produit p = new produit();
				p.setId(rs.getInt(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				p.setCategorie_id(rs.getInt(5));
				p.setImage(rs.getString(6));
				liste.add(p);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
		
		
	}

	@Override
	public produit getProduit(int id) {
		Connection connection=singletonConnection.getConnection();
		produit p=null;
		try {
			PreparedStatement ps=connection.prepareStatement("select * from produit where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p=new produit();
				p.setId(rs.getInt(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				p.setCategorie_id(rs.getInt(5));
				p.setImage(rs.getString(5));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void removeProduit(int id) {
		Connection connection = singletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("delete from produit where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProduit(produit p) {
		Connection connection=singletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("update produit set nom=?,prix=?,quantite=?,categorie_id=?,image=? where id=?");
			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setInt(4, p.getCategorie_id());
			ps.setString(5, p.getImage());
			ps.setInt(6, p.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<produit> getProduitPMC(String mc) {
		Connection connection=singletonConnection.getConnection();
		// TODO Auto-generated method stub
		List<produit>liste=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from produit where nom like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				produit p=new produit();
				p.setId(rs.getInt(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				p.setCategorie_id(rs.getInt(5));
				p.setImage(rs.getString(6));
				liste.add(p);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}


	@Override
	public void ajouterClient(client c) {
		Connection cx = singletonConnection.getConnection();
		
		try {
			PreparedStatement ps= cx.prepareStatement("insert into client (nom,prenom,email,password) values (?,?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getEmail());
			ps.setInt(4, c.getPassword());
			ps.executeUpdate();
			//cx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<client> getAllClients() {
		Connection cx = singletonConnection.getConnection();
		List<client> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from client");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				client c = new client();
				c.setId(rs.getInt(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setPassword(rs.getInt(5));
				liste.add(c);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public client getClient(int id) {
		Connection connection=singletonConnection.getConnection();
		client c=null;
		try {
			PreparedStatement ps=connection.prepareStatement("select * from client where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				c=new client();
				c.setId(rs.getInt(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setPassword(rs.getInt(5));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void removeClient(int id) {
		Connection connection = singletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("delete from client where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateClient(client c) {
		Connection connection=singletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("update client set nom=?,prenom=?,email=?,password=? where id=?");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getEmail());
			ps.setInt(4, c.getPassword());
			ps.setInt(5, c.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void ajouterCategorie(categorie ca) {
		Connection cx = singletonConnection.getConnection();
		
		try {
			PreparedStatement ps= cx.prepareStatement("insert into categorie (nom) values (?)");
			ps.setString(1, ca.getNom());
			
			ps.executeUpdate();
			//cx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<categorie> getAllCategories() {
		Connection cx = singletonConnection.getConnection();
		List<categorie> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from categorie");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				categorie ca = new categorie();
				ca.setId(rs.getInt(1));
				ca.setNom(rs.getString(2));
				
				liste.add(ca);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public categorie getCategorie(int id) {
		Connection connection=singletonConnection.getConnection();
		categorie ca=null;
		try {
			PreparedStatement ps=connection.prepareStatement("select * from categorie where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ca=new categorie();
				ca.setId(rs.getInt(1));
				ca.setNom(rs.getString(2));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ca;
	}

	@Override
	public void removeCategorie(int id) {
		Connection connection = singletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("delete from categorie where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCategorie(categorie ca) {
		Connection connection=singletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("update categorie set nom=? where id=?");
			ps.setString(1, ca.getNom());
			ps.setInt(2, ca.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<produit> getProduitPC(int id) {
		Connection cx = singletonConnection.getConnection();
		List<produit> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from produit where categorie_id=?");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				produit p = new produit();
				p.setId(rs.getInt(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				p.setCategorie_id(rs.getInt(5));
				liste.add(p);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
		
		
	}
	
	

	@Override
	public void ajouterCommande(commande co) {
		Connection cx = singletonConnection.getConnection();
		
		try {
			PreparedStatement ps= cx.prepareStatement("insert into commande (client_id,produit_id,quantiteComm) values (?,?,?)");
			ps.setInt(1, co.getClient_id());
			ps.setInt(2, co.getProduit_id());
			ps.setInt(3, co.getQuantiteComm());
			ps.executeUpdate();
			//cx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<commande> getAllCommandes() {
		Connection cx = singletonConnection.getConnection();
		List<commande> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from commande");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				commande co = new commande();
				co.setId(rs.getInt(1));
				co.setClient_id(rs.getInt(2));
				co.setProduit_id(rs.getInt(3));
				co.setQuantiteComm(rs.getInt(4));
				
				liste.add(co);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public List<admin> getAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
