package DAO;

import java.util.List;

import Entity.admin;
import Entity.categorie;
import Entity.client;
import Entity.commande;
import Entity.produit;

public interface ICatalogue {
	public void ajouterProduit(produit p);
	public List<produit> getAllProduits();
	public produit getProduit(int id);
	public void removeProduit(int id);
	public void updateProduit(produit p);
	public List<produit> getProduitPMC(String mc);
	
	public void ajouterClient(client c);
	public List<client> getAllClients();
	public client getClient(int id);
	public void removeClient(int id);
	public void updateClient(client c);
	
	
	public void ajouterCategorie(categorie ca);
	public List<categorie> getAllCategories();
	public categorie getCategorie(int id);
	public void removeCategorie(int id);
	public void updateCategorie(categorie ca);
	public List<produit> getProduitPC(int id);
	
	public void ajouterCommande(commande co);
	public List<commande> getAllCommandes();
	
	public List<admin> getAdmin();
}
